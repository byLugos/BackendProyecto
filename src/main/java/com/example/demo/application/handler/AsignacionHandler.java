package com.example.demo.application.handler;

import com.example.demo.application.dtos.request.AsignacionRequest;
import com.example.demo.application.dtos.response.AsignacionResponse;
import com.example.demo.application.mapper.AsignacionMapper;
import com.example.demo.domain.ports.in.asignacion.AsignacionIn;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class AsignacionHandler {
    private final AsignacionIn asignacionService;

    public AsignacionHandler(AsignacionIn asignacionService) {
        this.asignacionService = asignacionService;
    }

    public AsignacionResponse agregarAsignacion(Long idRubro, AsignacionRequest request) {
        return AsignacionMapper.toResponse(asignacionService.agregarAsignacion(
                idRubro,
                request.getMonto(),
                request.getFecha(),
                request.getDescripcion()
        ));
    }

    public List<AsignacionResponse> listarAsignaciones(Long idRubro) {
        return asignacionService.listarAsignacionesPorRubro(idRubro).stream()
                .map(AsignacionMapper::toResponse)
                .collect(Collectors.toList());
    }

    public void eliminarAsignacion(Long idRubro, Long idAsignacion) {
        asignacionService.eliminarAsignacion(idRubro, idAsignacion);
    }
}
