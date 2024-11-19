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
public class LocalDTO {
    private Long idLocal;
    private String status;

    private String nombre;
    private String ubicacion;
    private double precio;
    private Categoria categoria;
    private String descripcion;
    private byte[] img;

}
