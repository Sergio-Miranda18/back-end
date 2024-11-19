package com.easyplanning.demo.api.controller;

import com.easyplanning.demo.domain.common.routes;
import com.easyplanning.demo.domain.dto.LocalDTO;
import com.easyplanning.demo.domain.mapper.LocalMapper;
import com.easyplanning.demo.domain.service.LocalService;
import com.easyplanning.demo.persistence.entity.Categoria;
import com.easyplanning.demo.persistence.entity.Local;
import com.easyplanning.demo.persistence.repository.CategoriaRepository;
import com.easyplanning.demo.persistence.repository.LocalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = routes.API + routes.Local.LOCAL)


public class LocalController {
@Autowired
    private LocalService localService;
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private LocalRepository localRepository;


    @PostMapping(value = routes.Local.SAVE_LOCAL, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<String> save(
            @RequestPart("img") MultipartFile file,
            @RequestParam("nombre") String nombre,
            @RequestParam("ubicacion") String ubicacion,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("precio") double precio,
            @RequestParam("categoriaId") Long categoriaId
    ) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Debe seleccionar un archivo.");
        }
        try {
            // Crear y configurar LocalDTO con los parámetros recibidos
            LocalDTO localDTO = new LocalDTO();
            localDTO.setNombre(nombre);
            localDTO.setUbicacion(ubicacion);
            localDTO.setDescripcion(descripcion);
            localDTO.setPrecio(precio);
            localDTO.setStatus("Activado");
            // Buscar la categoría por su ID
            Optional<Categoria> categoriaOpt = categoriaRepository.findById(categoriaId);
            if (categoriaOpt.isPresent()) {
                localDTO.setCategoria(categoriaOpt.get());
            } else {
                return ResponseEntity.badRequest().body("Categoría no encontrada.");
            }
            if (!file.isEmpty()) {
                localDTO.setImg(file.getBytes());  // Guardar imagen como byte[]
            }

            localService.save(localDTO);

            return ResponseEntity.ok("Local guardado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error al procesar la imagen.");
        }
    }

    @GetMapping(value = routes.Local.GET_LOCAL)
    public List<LocalDTO> get(){return localService.getAll();}

    @PutMapping(value = routes.Local.UPDATE_LOCAL + "/{id}")
    public ResponseEntity<?> update(
            @PathVariable Long id,
            @RequestPart(value = "img", required = false) MultipartFile file,
            @RequestParam("nombre") String nombre,
            @RequestParam("ubicacion") String ubicacion,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("precio") double precio,
            @RequestParam("categoriaId") Long categoriaId) {
        try {
            // Buscar el Local por ID
            Local local = localRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Local no encontrado"));

            // Asignar los nuevos valores
            local.setNombre(nombre);
            local.setUbicacion(ubicacion);
            local.setDescripcion(descripcion);
            local.setPrecio(precio);

            // Validar y asignar la categoría
            Categoria categoria = categoriaRepository.findById(categoriaId)
                    .orElseThrow(() -> new IllegalArgumentException("Categoría no encontrada"));
            local.setCategoria(categoria);

            // Procesar imagen si está presente
            if (file != null && !file.isEmpty()) {
                local.setImg(file.getBytes());
            }

            // Guardar cambios
            localService.save(LocalMapper.toDTO(local));

            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al procesar la imagen.");
        }
    }
    @GetMapping("/{idLocal}")
    public ResponseEntity<Double> getPrecioById(@PathVariable Long idLocal) {
        Optional<LocalDTO> localDTOOptional = localService.findById(idLocal);
        if (localDTOOptional.isPresent()) {
            Double precio = localDTOOptional.get().getPrecio(); // Asume que getPrecio() devuelve el precio del lugar
            return ResponseEntity.ok(precio);
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping( "/delete/{codigo}")
    public ResponseEntity<?> delete(@PathVariable Long codigo) {


            Local local = localRepository.findById(codigo)
                    .orElseThrow(() -> new IllegalArgumentException("Local no encontrado"));
            // Crear y configurar LocalDTO con los parámetros recibidos
            local.setStatus("Desactivado");
            localService.save(LocalMapper.toDTO(local));
            return ResponseEntity.ok().build();

    }
}
