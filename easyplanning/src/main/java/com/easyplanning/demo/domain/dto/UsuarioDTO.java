package com.easyplanning.demo.domain.dto;


import com.easyplanning.demo.persistence.entity.Roles;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UsuarioDTO  {


    private String nombre;


    private String apellido;


    private String telefono;


    private String documento;

    private String email;

    private String clave;

    private Roles rol;

}
