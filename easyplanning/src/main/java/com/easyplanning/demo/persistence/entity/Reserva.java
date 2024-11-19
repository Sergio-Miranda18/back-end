package com.easyplanning.demo.persistence.entity;

import jakarta.persistence.*;
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
@Entity
@Table(name = "Reserva")
public class Reserva {

    @Column(name = "ID")
    @Id
    private String id;

    @JoinColumn(name = "Id_Local")
    @ManyToOne
    private Local local;

    @JoinColumn(name = "Email")
    @ManyToOne
    private Usuario email;

    @Column(name = "Estado")
    private String estado;

    @Column(name = "Fecha")
    private Date fecha;

    @Column(name = "Precio")
    private BigInteger precio;

    @JoinColumn(name = "ID_Categoria")
    @ManyToOne
    private Categoria categoria;

    @JoinColumn(name = "ID_Paquete")
    @ManyToOne
    private Paquete paquete;

    @Column(name = "Motivo")
    private String motivocancelacion;
}
