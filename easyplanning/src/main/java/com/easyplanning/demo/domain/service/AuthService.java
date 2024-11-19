package com.easyplanning.demo.domain.service;


import com.easyplanning.demo.api.controller.models.AuthResponse;
import com.easyplanning.demo.api.controller.models.AuthenticationRequest;
import com.easyplanning.demo.api.controller.models.RegisterRequest;
import com.easyplanning.demo.persistence.entity.Usuario;
import org.springframework.security.core.Authentication;

public interface AuthService {
    AuthResponse register (RegisterRequest Request );
    AuthResponse authenticate (AuthenticationRequest Request );

    Usuario getCurrentUser(Authentication authentication)


    ;
}
