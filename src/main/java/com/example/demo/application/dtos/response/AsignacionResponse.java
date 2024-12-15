package com.example.demo.application.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

//Uso de Lombok para ahorrar escritura de código
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AsignacionResponse {
    private Long id;
    private String nombre;
    private Double monto;
    private Date fecha;
    private String descripcion;
}
