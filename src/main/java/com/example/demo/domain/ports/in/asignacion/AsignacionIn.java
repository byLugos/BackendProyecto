package com.example.demo.domain.ports.in.asignacion;

import com.example.demo.domain.models.Asignacion;

import java.util.Date;
import java.util.List;

public interface AsignacionIn {
    // Agregar una asignación a un rubro
    Asignacion agregarAsignacion(Long idRubro, Double monto, Date fecha, String descripcion);

    // Listar todas las asignaciones de un rubro
    List<Asignacion> listarAsignacionesPorRubro(Long idRubro);

    // Eliminar una asignación por su ID
    void eliminarAsignacion(Long idRubro, Long idAsignacion);
}
