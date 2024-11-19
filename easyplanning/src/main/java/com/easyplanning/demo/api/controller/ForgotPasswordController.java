package com.easyplanning.demo.api.controller;

import com.easyplanning.demo.domain.service.EmailServiceImpl;
import com.easyplanning.demo.domain.service.JwtService;
import com.easyplanning.demo.domain.service.UsuarioService;
import com.easyplanning.demo.persistence.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/forgot-password")
public class ForgotPasswordController {

    @Autowired
    private UsuarioService userService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private EmailServiceImpl emailService;


    @PostMapping("/email")
    public ResponseEntity<String> requestPasswordReset(@RequestBody Map<String, String> email) {
        System.out.println(email.get("email"));
        try {

        String Email = email.get("email");
        Usuario user = userService.findByEmail(Email);
        System.out.println();
        if (user == null) {
            return ResponseEntity.badRequest().body("No se encontró un usuario con ese correo electrónico.");
        }
        }catch (Exception e){
            System.out.println(e);
        }
        return ResponseEntity.ok("Exito.");
    }

    @PostMapping("/reset")
    public ResponseEntity<String> resetPassword(@RequestBody Map<String, String> payload) {
        System.out.println(payload);
        String newPassword=payload.get("newPassword");
        String email=payload.get("email");
            userService.resetPassword(email, newPassword);
            return ResponseEntity.ok("Contraseña restablecida exitosamente.");

    }
}