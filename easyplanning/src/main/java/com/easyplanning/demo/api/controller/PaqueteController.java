package com.easyplanning.demo.api.controller;

import com.easyplanning.demo.domain.common.routes;
import com.easyplanning.demo.domain.dto.PaqueteDTO;
import com.easyplanning.demo.domain.service.PaqueteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = routes.API + routes.Paquete.PAQUETE)

public class PaqueteController {
@Autowired
    private PaqueteService paqueteService;

    @PostMapping(value = routes.Paquete.SAVE_PAQUETE)
    public PaqueteDTO save(@RequestBody PaqueteDTO paqueteDTO){
        return paqueteService.save(paqueteDTO);
    }

    @GetMapping(value = routes.Paquete.GET_PAQUETE)
    public List<PaqueteDTO> get(){return paqueteService.getAll();}

    @PutMapping(value =routes.Paquete.UPDATE_PAQUETE)
    public ResponseEntity<?> update(@RequestBody PaqueteDTO paqueteDTO) {
        Optional<PaqueteDTO> paqueteDTOOptional = paqueteService.findById(paqueteDTO.getId());
        if(paqueteDTOOptional.isPresent()) {
            paqueteService.save(paqueteDTO);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
