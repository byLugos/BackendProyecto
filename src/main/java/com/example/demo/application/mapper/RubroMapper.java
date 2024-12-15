package com.example.demo.application.mapper;

import com.example.demo.application.dtos.request.RubroRequest;
import com.example.demo.application.dtos.response.RubroResponse;
import com.example.demo.domain.models.Rubro;

public class RubroMapper {
    public static Rubro toEntity(RubroRequest request) {
        return new Rubro(null, request.getNombre(), request.getMontoAsignado(), request.getFechaLimite());
    }

    public static RubroResponse toResponse(Rubro rubro) {
        RubroResponse response = new RubroResponse();
        response.setId(rubro.getId());
        response.setNombre(rubro.getNombre());
        response.setMontoAsignado(rubro.getMontoAsignado());
        response.setMontoUtilizado(rubro.getMontoUtilizado());
        response.setFechaLimite(rubro.getFechaLimite());
        return response;
    }
}
