package com.example.demo.domain.ports.out.usuario;

import com.example.demo.domain.models.Usuario;

import java.util.Optional;

public interface UsuarioOut {
    Optional<Usuario> findByEmail(String email);

}
