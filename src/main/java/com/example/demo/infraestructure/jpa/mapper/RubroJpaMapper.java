package com.example.demo.infraestructure.jpa.mapper;

import com.example.demo.domain.models.Rubro;
import com.example.demo.infraestructure.jpa.entities.RubroEntity;

import java.util.stream.Collectors;

public class RubroJpaMapper {
    public static Rubro toDomain(RubroEntity entity) {
        Rubro rubro = new Rubro(
                entity.getId(),
                entity.getNombre(),
                entity.getMontoAsignado(),
                entity.getFechaLimite()
        );
        rubro.setMontoUtilizado(entity.getMontoUtilizado());
        rubro.setAsignaciones(
                entity.getAsignaciones().stream()
                        .map(AsignacionJpaMapper::toDomain)
                        .collect(Collectors.toList())
        );
        return rubro;
    }

    public static RubroEntity toEntity(Rubro rubro) {
        RubroEntity entity = new RubroEntity();
        entity.setId(rubro.getId());
        entity.setNombre(rubro.getNombre());
        entity.setMontoAsignado(rubro.getMontoAsignado());
        entity.setMontoUtilizado(rubro.getMontoUtilizado());
        entity.setFechaLimite(rubro.getFechaLimite());
        entity.setAsignaciones(
                rubro.getAsignaciones().stream()
                        .map(AsignacionJpaMapper::toEntity)
                        .collect(Collectors.toList())
        );
        return entity;
    }
}
