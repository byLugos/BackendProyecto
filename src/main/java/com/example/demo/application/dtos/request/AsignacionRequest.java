package com.example.demo.application.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
public class AsignacionRequest {
    private String nombre;
    private Double monto;
    private Date fecha;
    private String descripcion;
}
