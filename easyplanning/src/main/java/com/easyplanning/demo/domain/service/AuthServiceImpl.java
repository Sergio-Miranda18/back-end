package com.easyplanning.demo.domain.service;

import com.easyplanning.demo.api.controller.models.AuthResponse;
import com.easyplanning.demo.api.controller.models.AuthenticationRequest;
import com.easyplanning.demo.api.controller.models.RegisterRequest;
import com.easyplanning.demo.persistence.entity.Roles;
import com.easyplanning.demo.persistence.entity.Usuario;
import com.easyplanning.demo.persistence.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UsuarioRepository userRepository;
    private final EmailServiceImpl emailService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    @Override
    public AuthResponse register(RegisterRequest request) {
        var user = Usuario.builder()
                .email(request.getEmail())
                .clave(passwordEncoder.encode(request.getClave()))
                .nombre(request.getNombre())
                .apellido(request.getApellido())
                .documento(request.getDocumento())
                .telefono(request.getTelefono())
                .rol(Roles.USER)

                .build();
        userRepository.save(user);
        var jwtToken = jwtService.genereteToken((UserDetails) user);
        // Enviar correo electrónico de activación
        String mensajeHtml = String.format(
                "<h1>Estimado/a %s %s</h1>" +
                        "<p>¡Nos complace darte la bienvenida a EasyPlanning! Tu cuenta ha sido creada con éxito y ahora puedes comenzar a disfrutar de nuestros servicios para planificar y reservar eventos de manera fácil y rápida." +
                        "<br /><br />" +
                        "Tus credenciales de acceso son las siguientes:" +
                        "<br /><br />" +
                        "Usuario: %s" +
                        "<br /><br />" +
                        "Recuerda que puedes iniciar sesión en cualquier momento para gestionar tus reservas y explorar nuestras opciones de lugares, servicios y paquetes." +
                        "<br /><br />" +
                        "Si tienes alguna duda, no dudes en contactarnos." +
                        "<br /><br />" +
                        "¡Gracias por unirte a EasyPlanning!"+
                        "<br /><br />" +
                        "<br /><br />" +
                        "Saludos cordiales," +
                        "El equipo de EasyPlanning<br /><br />" ,
                user.getNombre(), user.getApellido(), user.getEmail()
        );

        emailService.sendEmails(
                new String[]{user.getEmail()},
                "¡Bienvenido a EasyPlanning! Tu cuenta ha sido creada con éxito",
                mensajeHtml
        );

        return AuthResponse.builder()
                .token(jwtToken).build();
    }

    @Override
    public AuthResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUser(),
                        request.getPassword()
                )
        );
        UserDetails user = userRepository.findByEmail(request.getUser()).orElseThrow();
        String jwtToken = jwtService.genereteToken(user);
        List<String> roles = user.getAuthorities().stream()
                .map(authority -> authority.getAuthority())
                .collect(Collectors.toList());

        return AuthResponse.builder()
                .token(jwtToken)
                .authorities(roles)
                .build();
    }
    @Override
    public Usuario getCurrentUser(Authentication authentication) {
        return (Usuario) authentication.getPrincipal();
}


}

