package com.easyplanning.demo.api.controller;

import com.easyplanning.demo.api.controller.models.AuthResponse;
import com.easyplanning.demo.api.controller.models.AuthenticationRequest;
import com.easyplanning.demo.api.controller.models.RegisterRequest;
import com.easyplanning.demo.domain.service.AuthService;
import com.easyplanning.demo.domain.service.JwtService;
import com.easyplanning.demo.domain.service.UsuarioService;
import com.easyplanning.demo.persistence.entity.Usuario;
import com.easyplanning.demo.persistence.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    @Autowired
    private AuthService authService;

    @GetMapping("/editar")
    public ResponseEntity<Usuario> getCurrentUser(Authentication authentication) {
        return ResponseEntity.ok(authService.getCurrentUser(authentication));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> Register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.register(request));
    }


    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authService.authenticate(request));
    }



}
