package com.easyplanning.demo.api.controller;

import com.easyplanning.demo.domain.common.routes;
import com.easyplanning.demo.domain.dto.UsuarioDTO;
import com.easyplanning.demo.domain.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = routes.API + routes.Usuario.USUARIO)
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(value = routes.Usuario.SAVE_USUARIO)
    public UsuarioDTO save(@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.save(usuarioDTO);
    }

    @GetMapping(value = routes.Usuario.GET_USUARIO)
    public List<UsuarioDTO> get() {
        return usuarioService.getAll();
    }

    @PostMapping(value = routes.Usuario.LOGIN)
    public ResponseEntity<?> findByEmailAndClave(@RequestBody UsuarioDTO usuarioDTO) {
        Optional<UsuarioDTO> usuarioDTOOptional;
        usuarioDTOOptional = usuarioService.findByEmailAndClave(usuarioDTO.getEmail(), usuarioDTO.getClave());
        if (usuarioDTOOptional.isPresent()) {
            return ResponseEntity.ok(usuarioDTOOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping(value = routes.Usuario.UPDATE_USUARIO)
    public ResponseEntity<?> update(@RequestBody UsuarioDTO usuarioDTO) {
        Optional<UsuarioDTO> userOptional = usuarioService.findById(usuarioDTO.getEmail());
        if(userOptional.isPresent()) {
            usuarioService.save(usuarioDTO);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}