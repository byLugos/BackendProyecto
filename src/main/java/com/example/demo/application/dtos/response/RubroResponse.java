package com.example.demo.application.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RubroResponse {
    private Long id;
    private String nombre;
    private Double montoAsignado;
    private Double montoUtilizado;
    private Date fechaLimite;
}
