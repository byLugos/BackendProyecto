package com.example.demo.domain.service;

import com.example.demo.domain.models.Asignacion;
import com.example.demo.domain.models.Rubro;
import com.example.demo.domain.ports.in.asignacion.AsignacionIn;
import com.example.demo.domain.ports.out.asignacion.AsignacionOut;
import com.example.demo.domain.ports.out.rubro.RubroOut;
import com.example.demo.domain.validation.ValidationAsignacion;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AsignacionService implements AsignacionIn {

    private final RubroOut rubroOut;
    private final AsignacionOut asignacionOut;

    public AsignacionService(RubroOut rubroOut, AsignacionOut asignacionOut) {
        this.rubroOut = rubroOut;
        this.asignacionOut = asignacionOut;
    }

    @Override
    public Asignacion agregarAsignacion(Long idRubro, String nombre, Double monto, Date fecha, String descripcion) {
        Rubro rubro = rubroOut.buscarPorId(idRubro);

        // Validaciones de negocio y datos
        ValidationAsignacion.validarExistenciaRubro(rubro, idRubro);
        ValidationAsignacion.validarDatosAsignacion(nombre, monto, fecha, descripcion);
        ValidationAsignacion.validarPresupuesto(rubro, monto);
        ValidationAsignacion.validarFaltaDeRecursos(rubro, monto);
        ValidationAsignacion.validarRubroBajoGestion(rubro);
        ValidationAsignacion.validarFechaLimiteProxima(rubro);

        // Crear la asignación
        Asignacion asignacion = new Asignacion(null, nombre, monto, fecha, descripcion);
        asignacion = asignacionOut.guardarAsignacion(asignacion);

        // Actualizar rubro
        rubro.getAsignaciones().add(asignacion);
        rubro.setMontoUtilizado(rubro.getMontoUtilizado() + monto);
        rubroOut.guardarRubro(rubro);

        return asignacion;
    }


    @Override
    public List<Asignacion> listarAsignacionesPorRubro(Long idRubro) {
        Rubro rubro = rubroOut.buscarPorId(idRubro);
        ValidationAsignacion.validarExistenciaRubro(rubro, idRubro);

        return rubro.getAsignaciones();
    }

    @Override
    public void eliminarAsignacion(Long idRubro, Long idAsignacion) {
        Rubro rubro = rubroOut.buscarPorId(idRubro);
        ValidationAsignacion.validarExistenciaRubro(rubro, idRubro);

        Asignacion asignacion = asignacionOut.buscarPorId(idAsignacion);
        ValidationAsignacion.validarExistenciaAsignacion(asignacion, idAsignacion);

        rubro.getAsignaciones().remove(asignacion);
        rubro.setMontoUtilizado(rubro.getMontoUtilizado() - asignacion.getMonto());
        rubroOut.guardarRubro(rubro);

        asignacionOut.eliminarAsignacion(idAsignacion);
    }
}
