package com.example.demo.infraestructure.jpa.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@Entity
public class RubroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private Double montoAsignado;

    private Double montoUtilizado;

    private Date fechaLimite;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "rubro_id")
    private List<AsignacionEntity> asignaciones = new ArrayList<>();

}
