package com.example.demo.domain.entities;

import java.math.BigInteger;
import java.time.LocalDate;

public class Rubro {
    private Long id;
    private String nombre;
    private BigInteger presupuestoAsignado;
    private BigInteger presupuestoUsado;
    private LocalDate fechaCreacion;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public BigInteger getPresupuestoAsignado() {
        return presupuestoAsignado;
    }
    public void setPresupuestoAsignado(BigInteger presupuestoAsignado) {
        this.presupuestoAsignado = presupuestoAsignado;
    }
    public BigInteger getPresupuestoUsado() {
        return presupuestoUsado;
    }
    public void setPresupuestoUsado(BigInteger presupuestoUsado) {
        this.presupuestoUsado = presupuestoUsado;
    }
    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }
    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
