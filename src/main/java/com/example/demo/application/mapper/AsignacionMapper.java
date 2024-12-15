package com.example.demo.application.mapper;

import com.example.demo.application.dtos.request.AsignacionRequest;
import com.example.demo.application.dtos.response.AsignacionResponse;
import com.example.demo.domain.models.Asignacion;

public class AsignacionMapper {

    public static Asignacion toEntity(AsignacionRequest request) {
        return new Asignacion(null, request.getNombre(), request.getMonto(), request.getFecha(), request.getDescripcion());
    }

    public static AsignacionResponse toResponse(Asignacion asignacion) {
        AsignacionResponse response = new AsignacionResponse();
        response.setId(asignacion.getId());
        response.setNombre(asignacion.getNombre());
        response.setMonto(asignacion.getMonto());
        response.setFecha(asignacion.getFecha());
        response.setDescripcion(asignacion.getDescripcion());
        return response;
    }
}
