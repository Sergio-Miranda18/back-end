package com.easyplanning.demo.domain.dto;

import com.easyplanning.demo.persistence.entity.Categoria;
import com.easyplanning.demo.persistence.entity.Local;
import com.easyplanning.demo.persistence.entity.Paquete;
import com.easyplanning.demo.persistence.entity.Usuario;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservaDTO {
    private String id;

    private Local local;
    private Usuario email;
    private String estado;
    private Date fecha;
    private BigInteger precio;
    private Categoria categoria;
    private Paquete paquete;
    private String motivocancelacion;
}
