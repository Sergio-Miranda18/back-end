package com.easyplanning.demo.persistence.repository;

import com.easyplanning.demo.persistence.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


@org.springframework.stereotype.Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    Optional<Usuario> findByEmail(String email);
    Usuario findUserByEmail(String email);
    public Usuario findByEmailAndClave(String email, String clave);
}
