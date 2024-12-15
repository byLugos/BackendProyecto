package com.example.demo.infraestructure.jpa.repos.adapters;

import com.example.demo.domain.models.Usuario;

import com.example.demo.domain.ports.out.usuario.UsuarioOut;
import com.example.demo.infraestructure.jpa.entities.UsuarioEntity;
import com.example.demo.infraestructure.jpa.repos.repositories.UsuarioJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UsuarioJpaAdapter implements UsuarioOut {

    private final UsuarioJpaRepository usuarioRepository;

    public UsuarioJpaAdapter(UsuarioJpaRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Optional<Usuario> findByEmail(String email) {
        return usuarioRepository.findByemail(email)
                .map(this::mapToDomain);
    }

    private Usuario mapToDomain(UsuarioEntity entity) {
        return new Usuario(entity.getId(), entity.getEmail(), entity.getPassword());
    }
}
