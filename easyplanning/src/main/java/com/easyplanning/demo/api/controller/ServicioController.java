package com.easyplanning.demo.api.controller;

import com.easyplanning.demo.domain.common.routes;
import com.easyplanning.demo.domain.dto.ServicioDTO;
import com.easyplanning.demo.domain.service.ServicioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = routes.API + routes.Servicios.SERVICIOS)

public class ServicioController {
    @Autowired
    private ServicioService servicioService;

    @PostMapping(value = routes.Servicios.SAVE_SERVICIOS)
    public ServicioDTO save(@RequestBody ServicioDTO servicioDTO){
        return servicioService.save(servicioDTO);
    }

    @GetMapping(value = routes.Servicios.GET_SERVICIOS)
    public List<ServicioDTO> get(){return servicioService.getAll();}

    @PutMapping(value =routes.Servicios.UPDATE_SERVICIOS)
    public ResponseEntity<?> update(@RequestBody ServicioDTO servicioDTO) {
        Optional<ServicioDTO> servicioDTOOptional = servicioService.findById(servicioDTO.getId());
        if(servicioDTOOptional.isPresent()) {
            servicioService.save(servicioDTO);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}