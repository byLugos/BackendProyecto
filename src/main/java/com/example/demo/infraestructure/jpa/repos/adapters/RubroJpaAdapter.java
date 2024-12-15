package com.example.demo.infraestructure.jpa.repos.adapters;

import com.example.demo.domain.models.Rubro;
import com.example.demo.domain.ports.out.rubro.RubroOut;
import com.example.demo.infraestructure.jpa.entities.RubroEntity;
import com.example.demo.infraestructure.jpa.mapper.RubroJpaMapper;
import com.example.demo.infraestructure.jpa.repos.repositories.RubroJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RubroJpaAdapter implements RubroOut {
    private final RubroJpaRepository rubroJpaRepository;

    public RubroJpaAdapter(RubroJpaRepository rubroJpaRepository) {
        this.rubroJpaRepository = rubroJpaRepository;
    }

    @Override
    public Rubro guardarRubro(Rubro rubro) {
        RubroEntity entity = RubroJpaMapper.toEntity(rubro);
        entity = rubroJpaRepository.save(entity);
        return RubroJpaMapper.toDomain(entity);
    }

    @Override
    public void eliminarRubro(Long id) {
        rubroJpaRepository.deleteById(id);
    }

    @Override
    public Rubro buscarPorId(Long id) {
        return rubroJpaRepository.findById(id)
                .map(RubroJpaMapper::toDomain)
                .orElse(null);
    }

    @Override
    public List<Rubro> buscarTodos() {
        return rubroJpaRepository.findAll().stream()
                .map(RubroJpaMapper::toDomain)
                .collect(Collectors.toList());
    }
}
