package com.easyplanning.demo.domain.mapper;


import com.easyplanning.demo.domain.dto.LocalDTO;
import com.easyplanning.demo.persistence.entity.Local;

public class LocalMapper {
    public static Local toEntity(LocalDTO localDTO) {
        Local local = new Local();
        local.setIdLocal(localDTO.getIdLocal());
        local.setCategoria(localDTO.getCategoria());
        local.setNombre(localDTO.getNombre());
        local.setPrecio(localDTO.getPrecio());
        local.setUbicacion(localDTO.getUbicacion());
        local.setDescripcion(localDTO.getDescripcion());
        local.setImg(localDTO.getImg());
        local.setStatus(localDTO.getStatus());
        return local;
    }

    public static LocalDTO toDTO(Local local) {
        LocalDTO localDTO = new LocalDTO();
        localDTO.setIdLocal(local.getIdLocal());
        localDTO.setCategoria(local.getCategoria());
        localDTO.setNombre(local.getNombre());
        localDTO.setPrecio(local.getPrecio());
        localDTO.setUbicacion(local.getUbicacion());
        localDTO.setDescripcion(local.getDescripcion());
        localDTO.setImg(local.getImg());
        localDTO.setStatus(local.getStatus());


        return localDTO;
    }

}
