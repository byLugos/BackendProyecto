package com.example.demo.domain.service;

import com.example.demo.domain.models.Asignacion;
import com.example.demo.domain.models.Rubro;
import com.example.demo.domain.ports.in.asignacion.AsignacionIn;
import com.example.demo.domain.ports.out.asignacion.AsignacionOut;
import com.example.demo.domain.ports.out.rubro.RubroOut;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

//En arquitectura hexagonal cerrada no se debería usar esto
@Service
public class AsignacionService implements AsignacionIn {

    private final RubroOut rubroOut;
    private final AsignacionOut asignacionOut;

    public AsignacionService(RubroOut rubroOut, AsignacionOut asignacionOut) {
        this.rubroOut = rubroOut;
        this.asignacionOut = asignacionOut;
    }

    @Override
    public Asignacion agregarAsignacion(Long idRubro, Double monto, Date fecha, String descripcion) {
        Rubro rubro = rubroOut.buscarPorId(idRubro);
        if (rubro == null) {
            throw new IllegalArgumentException("El rubro con ID " + idRubro + " no existe.");
        }

        if (rubro.getMontoUtilizado() + monto > rubro.getMontoAsignado()) {
            throw new IllegalArgumentException("El monto supera el presupuesto asignado al rubro.");
        }

        Asignacion asignacion = new Asignacion(null, monto, fecha, descripcion);
        asignacion = asignacionOut.guardarAsignacion(asignacion);

        rubro.getAsignaciones().add(asignacion);
        rubro.setMontoUtilizado(rubro.getMontoUtilizado() + monto);
        rubroOut.guardarRubro(rubro);

        return asignacion;
    }

    @Override
    public List<Asignacion> listarAsignacionesPorRubro(Long idRubro) {
        Rubro rubro = rubroOut.buscarPorId(idRubro);
        if (rubro == null) {
            throw new IllegalArgumentException("El rubro con ID " + idRubro + " no existe.");
        }
        return rubro.getAsignaciones();
    }

    @Override
    public void eliminarAsignacion(Long idRubro, Long idAsignacion) {
        Rubro rubro = rubroOut.buscarPorId(idRubro);
        if (rubro == null) {
            throw new IllegalArgumentException("El rubro con ID " + idRubro + " no existe.");
        }

        Asignacion asignacion = asignacionOut.buscarPorId(idAsignacion);
        if (asignacion == null) {
            throw new IllegalArgumentException("La asignación con ID " + idAsignacion + " no existe.");
        }

        rubro.getAsignaciones().remove(asignacion);
        rubro.setMontoUtilizado(rubro.getMontoUtilizado() - asignacion.getMonto());
        rubroOut.guardarRubro(rubro);

        asignacionOut.eliminarAsignacion(idAsignacion);
    }
}
