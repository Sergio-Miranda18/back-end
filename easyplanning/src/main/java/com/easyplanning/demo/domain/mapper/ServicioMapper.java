package com.easyplanning.demo.domain.mapper;


import com.easyplanning.demo.domain.dto.ServicioDTO;

import com.easyplanning.demo.persistence.entity.Servicio;

public class ServicioMapper {
    public static Servicio toEntity(ServicioDTO ServicioDTO) {
        Servicio servicio = new Servicio();
        servicio.setId(ServicioDTO.getId());
        servicio.setNombre(ServicioDTO.getNombre());
        servicio.setDescripcion(ServicioDTO.getDescripcion());
        return servicio;
    }

    public static ServicioDTO toDTO(Servicio servicio) {
        ServicioDTO ServicioDTO = new ServicioDTO();
        ServicioDTO.setId(servicio.getId());
        ServicioDTO.setNombre(servicio.getNombre());
        ServicioDTO.setDescripcion(servicio.getDescripcion());
        return ServicioDTO;
    }
}
