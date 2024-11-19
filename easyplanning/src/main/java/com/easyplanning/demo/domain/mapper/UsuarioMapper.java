package com.easyplanning.demo.domain.mapper;


import com.easyplanning.demo.domain.dto.UsuarioDTO;
import com.easyplanning.demo.persistence.entity.Usuario;

public class UsuarioMapper {

    public static Usuario toEntity(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setApellido(usuarioDTO.getApellido());
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setDocumento(usuarioDTO.getDocumento());
        usuario.setClave(usuarioDTO.getClave());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setRol(usuarioDTO.getRol());
        usuario.setTelefono(usuarioDTO.getTelefono());
        return usuario;
    }

    public static UsuarioDTO toDTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setApellido(usuario.getApellido());
        usuarioDTO.setNombre(usuario.getNombre());
        usuarioDTO.setDocumento(usuario.getDocumento());
        usuarioDTO.setClave(usuario.getClave());
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setRol(usuario.getRol());
        usuarioDTO.setTelefono(usuario.getTelefono());
        return usuarioDTO;
    }
}
