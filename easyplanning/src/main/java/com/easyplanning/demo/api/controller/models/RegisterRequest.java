package com.easyplanning.demo.api.controller.models;

import com.easyplanning.demo.persistence.entity.Roles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String nombre;


    private String apellido;


    private String telefono;


    private String documento;

    private String email;

    private String clave;

    private Roles rol;

}
