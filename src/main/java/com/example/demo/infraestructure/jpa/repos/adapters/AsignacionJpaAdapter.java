package com.example.demo.infraestructure.jpa.repos.adapters;

import com.example.demo.domain.models.Asignacion;
import com.example.demo.domain.ports.out.asignacion.AsignacionOut;
import com.example.demo.infraestructure.jpa.entities.AsignacionEntity;
import com.example.demo.infraestructure.jpa.mapper.AsignacionJpaMapper;
import com.example.demo.infraestructure.jpa.repos.repositories.AsignacionJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AsignacionJpaAdapter implements AsignacionOut {
    private final AsignacionJpaRepository asignacionJpaRepository;

    public AsignacionJpaAdapter(AsignacionJpaRepository asignacionJpaRepository) {
        this.asignacionJpaRepository = asignacionJpaRepository;
    }

    @Override
    public Asignacion guardarAsignacion(Asignacion asignacion) {
        AsignacionEntity entity = AsignacionJpaMapper.toEntity(asignacion);
        entity = asignacionJpaRepository.save(entity);
        return AsignacionJpaMapper.toDomain(entity);
    }

    @Override
    public void eliminarAsignacion(Long id) {
        asignacionJpaRepository.deleteById(id);
    }

    @Override
    public Asignacion buscarPorId(Long id) {
        return asignacionJpaRepository.findById(id)
                .map(AsignacionJpaMapper::toDomain)
                .orElse(null);
    }

    @Override
    public List<Asignacion> buscarPorRubro(Long idRubro) {
        return asignacionJpaRepository.findAll().stream()
                .map(AsignacionJpaMapper::toDomain)
                .collect(Collectors.toList());
    }

}
