package com.easyplanning.demo.domain.dto;

import com.easyplanning.demo.persistence.entity.Local;
import com.easyplanning.demo.persistence.entity.Paquete;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO {

        private Long id;

        private String descripcion;


        private List<Paquete> paquetes;


        private List<Local> locales;

}
