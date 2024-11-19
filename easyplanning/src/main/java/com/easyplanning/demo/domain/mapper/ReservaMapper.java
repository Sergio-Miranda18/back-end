package com.easyplanning.demo.domain.mapper;

import com.easyplanning.demo.domain.dto.PaqueteDTO;
import com.easyplanning.demo.domain.dto.ReservaDTO;
import com.easyplanning.demo.persistence.entity.Paquete;
import com.easyplanning.demo.persistence.entity.Reserva;

public class ReservaMapper {
    public static Reserva toEntity(ReservaDTO reservaDTO) {
        Reserva reserva = new Reserva();
        reserva.setId(reservaDTO.getId());
        reserva.setLocal(reservaDTO.getLocal());
        reserva.setEmail(reservaDTO.getEmail());
        reserva.setEstado(reservaDTO.getEstado());
        reserva.setFecha(reservaDTO.getFecha());
        reserva.setPrecio(reservaDTO.getPrecio());
        reserva.setCategoria(reservaDTO.getCategoria());
        reserva.setPaquete(reservaDTO.getPaquete());
        reserva.setMotivocancelacion(reservaDTO.getMotivocancelacion());
        return reserva;
    }

    public static ReservaDTO toDTO(Reserva reserva) {
        ReservaDTO reservaDTO = new ReservaDTO();
        reservaDTO.setId(reserva.getId());
        reservaDTO.setLocal(reserva.getLocal());
        reservaDTO.setEmail(reserva.getEmail());
        reservaDTO.setEstado(reserva.getEstado());
        reservaDTO.setFecha(reserva.getFecha());
        reservaDTO.setPrecio(reserva.getPrecio());
        reservaDTO.setCategoria(reserva.getCategoria());
        reservaDTO.setPaquete(reserva.getPaquete());
        reservaDTO.setMotivocancelacion(reserva.getMotivocancelacion());
        return reservaDTO;
    }
}
