package com.example.demo.application.handler;

import com.example.demo.application.dtos.request.RubroRequest;
import com.example.demo.application.dtos.response.RubroResponse;
import com.example.demo.application.mapper.RubroMapper;
import com.example.demo.domain.ports.in.rubro.RubroIn;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class RubroHandler {
    private final RubroIn rubroService;

    public RubroHandler(RubroIn rubroService) {
        this.rubroService = rubroService;
    }

    public RubroResponse crearRubro(RubroRequest request) {
        return RubroMapper.toResponse(rubroService.crearRubro(
                request.getNombre(),
                request.getMontoAsignado(),
                request.getFechaLimite()
        ));
    }

    public List<RubroResponse> listarRubros() {
        return rubroService.listarRubros().stream()
                .map(RubroMapper::toResponse)
                .collect(Collectors.toList());
    }

    public RubroResponse obtenerRubro(Long id) {
        return RubroMapper.toResponse(rubroService.obtenerRubroPorId(id));
    }

    public RubroResponse actualizarRubro(Long id, RubroRequest request) {
        return RubroMapper.toResponse(rubroService.actualizarRubro(
                id,
                request.getNombre(),
                request.getMontoAsignado(),
                request.getFechaLimite()
        ));
    }

    public void eliminarRubro(Long id) {
        rubroService.eliminarRubro(id);
    }
}
