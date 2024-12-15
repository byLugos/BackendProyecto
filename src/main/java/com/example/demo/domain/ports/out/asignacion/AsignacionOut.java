package com.example.demo.domain.ports.out.asignacion;

import com.example.demo.domain.models.Asignacion;

import java.util.List;

public interface AsignacionOut {
    Asignacion guardarAsignacion(Asignacion asignacion);
    void eliminarAsignacion(Long id);
    Asignacion buscarPorId(Long id);
    List<Asignacion> buscarPorRubro(Long idRubro);
}
