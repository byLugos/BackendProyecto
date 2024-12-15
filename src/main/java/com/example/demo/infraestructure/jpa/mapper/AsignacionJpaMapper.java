package com.example.demo.infraestructure.jpa.mapper;

import com.example.demo.domain.models.Asignacion;
import com.example.demo.infraestructure.jpa.entities.AsignacionEntity;

public class AsignacionJpaMapper {
    public static Asignacion toDomain(AsignacionEntity entity) {
        return new Asignacion(
                entity.getId(),
                entity.getMonto(),
                entity.getFecha(),
                entity.getDescripcion()
        );
    }

    public static AsignacionEntity toEntity(Asignacion asignacion) {
        AsignacionEntity entity = new AsignacionEntity();
        entity.setId(asignacion.getId());
        entity.setMonto(asignacion.getMonto());
        entity.setFecha(asignacion.getFecha());
        entity.setDescripcion(asignacion.getDescripcion());
        return entity;
    }
}
