package com.easyplanning.demo.api.controller;

import com.easyplanning.demo.domain.common.routes;
import com.easyplanning.demo.domain.dto.CategoriaDTO;
import com.easyplanning.demo.domain.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = routes.API + routes.Categoria.CATEGORIA)
public class CategoriaController {
    @Autowired

    private CategoriaService categoryService;

    @PostMapping(value = routes.Categoria.SAVE_CATEGORIA)
    public CategoriaDTO save(@RequestBody CategoriaDTO categoryDTO){
        return categoryService.save(categoryDTO);
    }

    @GetMapping(value = routes.Categoria.GET_CATEGORIA)
    public List<CategoriaDTO> get(){return categoryService.getAll();}

    @PutMapping(value =routes.Categoria.UPDATE_CATEGORIA)
    public ResponseEntity<?> update(@RequestBody CategoriaDTO categoryDTO) {
        Optional<CategoriaDTO> categoryDTOOptional = categoryService.findById(categoryDTO.getId());
        if(categoryDTOOptional.isPresent()) {
            categoryService.save(categoryDTO);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}

