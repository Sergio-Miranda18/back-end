package com.easyplanning.demo.domain.dto;

import com.easyplanning.demo.persistence.entity.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaqueteDTO {
    private Long id;
    private String nombre;
    private String descripcion;
}
