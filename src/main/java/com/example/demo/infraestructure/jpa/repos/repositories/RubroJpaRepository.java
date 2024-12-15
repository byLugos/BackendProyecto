package com.example.demo.infraestructure.jpa.repos.repositories;

import com.example.demo.infraestructure.jpa.entities.RubroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RubroJpaRepository extends JpaRepository<RubroEntity, Long> {
}
