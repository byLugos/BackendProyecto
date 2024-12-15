package com.example.demo.domain.models;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
public class Rubro {
    private Long id;
    private String nombre;
    private Double montoAsignado;
    private Double montoUtilizado;
    private Date fechaLimite;
    private List<Asignacion> asignaciones = new ArrayList<>();
    public Rubro(Long id, String nombre, Double montoAsignado, Date fechaLimite) {
        this.id = id;
        this.nombre = nombre;
        this.montoAsignado = montoAsignado;
        this.montoUtilizado = 0.0;
        this.fechaLimite = fechaLimite;
    }
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

    public Double getMontoAsignado() {
        return montoAsignado;
    }

    public void setMontoAsignado(Double montoAsignado) {
        this.montoAsignado = montoAsignado;
    }

    public Double getMontoUtilizado() {
        return montoUtilizado;
    }

    public void setMontoUtilizado(Double montoUtilizado) {
        this.montoUtilizado = montoUtilizado;
    }

    public Date getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public List<Asignacion> getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(List<Asignacion> asignaciones) {
        this.asignaciones = asignaciones;
    }
}
