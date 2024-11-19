package com.easyplanning.demo.domain.mapper;

import com.easyplanning.demo.domain.dto.CategoriaDTO;
import com.easyplanning.demo.persistence.entity.Categoria;

public class CategoriaMapper {
    public static Categoria toEntity(CategoriaDTO categoryDTO) {
        Categoria category = new Categoria();
        category.setId(categoryDTO.getId());
        category.setDescripcion(categoryDTO.getDescripcion());
        return category;
    }

    public static CategoriaDTO toDTO(Categoria category) {
        CategoriaDTO categoryDTO = new CategoriaDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setDescripcion(category.getDescripcion());
        return categoryDTO;
    }
}
