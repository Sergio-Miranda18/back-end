package com.easyplanning.demo.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Local")
public class Local {

    @Column(name = "ID_Local")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLocal;

    @Column (name = "estado")
    private String status;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Ubicacion")
    private String ubicacion;

    @Column(name = "Descripcion")
    private String descripcion;


    @Column(name = "Precio")
    private double precio;

    @JoinColumn(name = "Categoria_id")
    @ManyToOne
    private Categoria categoria;

    @Lob
    @Column(name = "Imagen", columnDefinition = "LONGBLOB")
    private byte[] img;

}
