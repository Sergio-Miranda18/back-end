package com.easyplanning.demo.domain.mapper;

import com.easyplanning.demo.domain.dto.LocalDTO;
import com.easyplanning.demo.domain.dto.PaqueteDTO;
import com.easyplanning.demo.persistence.entity.Local;
import com.easyplanning.demo.persistence.entity.Paquete;

public class PaqueteMapper {
    public static Paquete toEntity(PaqueteDTO paquetedto) {
        Paquete paquete = new Paquete();
        paquete.setId(paquetedto.getId());
        paquete.setNombre(paquetedto.getNombre());
        paquete.setDescripcion(paquetedto.getDescripcion());
        return paquete;
    }

    public static PaqueteDTO toDTO(Paquete paquete) {
        PaqueteDTO paqueteDTO = new PaqueteDTO();
        paqueteDTO.setId(paquete.getId());
        paqueteDTO.setNombre(paquete.getNombre());
        paqueteDTO.setDescripcion(paquete.getDescripcion());
        return paqueteDTO;
    }
}
