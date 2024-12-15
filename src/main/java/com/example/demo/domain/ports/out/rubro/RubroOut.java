package com.example.demo.domain.ports.out.rubro;

import com.example.demo.domain.models.Rubro;

import java.util.List;

public interface RubroOut {
    Rubro guardarRubro(Rubro rubro);
    void eliminarRubro(Long id);
    Rubro buscarPorId(Long id);
    List<Rubro> buscarTodos();
}
