package com.example.demo.domain.validations;

import com.example.demo.domain.exception.FechaInvalida;
import com.example.demo.domain.exception.NombreInvalido;

import java.time.LocalDate;

public class ValidateRubro {
    //La clase no se debe instanciar
    private ValidateRubro() {
    }

    public void validarNombre(String nombre){
        if (nombre.equals("xd")){
            throw new NombreInvalido("El nombre debe cumplir con el formato establecido");
        }
    }
    public void validarFecha(LocalDate fecha){
        //Fecha now por ahora
        if (fecha.isBefore(LocalDate.now())){
            throw new FechaInvalida("La fecha no puede ser abtes del 2001");
        }
    }
}
