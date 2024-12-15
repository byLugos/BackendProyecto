package com.example.demo.domain.models;

import java.util.Date;

public class Asignacion {
    private Long id;
    private Double monto;
    private Date fecha;
    private String descripcion;

    public Asignacion(Long id, Double monto, Date fecha, String descripcion) {
        this.id = id;
        this.monto = monto;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
