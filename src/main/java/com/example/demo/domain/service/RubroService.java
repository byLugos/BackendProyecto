package com.example.demo.domain.service;

import com.example.demo.domain.models.Rubro;
import com.example.demo.domain.ports.in.rubro.RubroIn;
import com.example.demo.domain.ports.out.rubro.RubroOut;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RubroService implements RubroIn {

    private final RubroOut rubroOut;

    public RubroService(RubroOut rubroOut) {
        this.rubroOut = rubroOut;
    }

    @Override
    public Rubro crearRubro(String nombre, Double montoAsignado, Date fechaLimite) {
        Rubro rubro = new Rubro(null, nombre, montoAsignado, fechaLimite);
        return rubroOut.guardarRubro(rubro);
    }

    @Override
    public Rubro actualizarRubro(Long id, String nombre, Double montoAsignado, Date fechaLimite) {
        Rubro rubro = rubroOut.buscarPorId(id);
        if (rubro == null) {
            throw new IllegalArgumentException("El rubro con ID " + id + " no existe.");
        }
        rubro.setNombre(nombre);
        rubro.setMontoAsignado(montoAsignado);
        rubro.setFechaLimite(fechaLimite);
        return rubroOut.guardarRubro(rubro);
    }

    @Override
    public void eliminarRubro(Long id) {
        rubroOut.eliminarRubro(id);
    }

    @Override
    public Rubro obtenerRubroPorId(Long id) {
        Rubro rubro = rubroOut.buscarPorId(id);
        if (rubro == null) {
            throw new IllegalArgumentException("El rubro con ID " + id + " no existe.");
        }
        return rubro;
    }

    @Override
    public List<Rubro> listarRubros() {
        return rubroOut.buscarTodos();
    }
}
