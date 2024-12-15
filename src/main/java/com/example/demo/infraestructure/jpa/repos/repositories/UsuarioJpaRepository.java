package com.example.demo.infraestructure.jpa.repos.repositories;

import com.example.demo.infraestructure.jpa.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioJpaRepository extends JpaRepository<UsuarioEntity,Long> {
    Optional<UsuarioEntity> findByemail(String email);

}
