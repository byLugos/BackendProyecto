package com.example.demo.domain.validation;

import com.example.demo.domain.exception.BusinessException;
import com.example.demo.domain.exception.ValidationException;
import com.example.demo.domain.models.Asignacion;
import com.example.demo.domain.models.Rubro;

import java.util.Date;

public class ValidationAsignacion {

    // Validar los datos de la asignación
    public static void validarDatosAsignacion(String nombre, Double monto, Date fecha, String descripcion) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new ValidationException("El nombre de la asignación no puede estar vacío.");
        }

        if (nombre.length() > 50) {
            throw new ValidationException("El nombre de la asignación no puede tener más de 50 caracteres.");
        }

        if (monto == null || monto <= 0) {
            throw new ValidationException("El monto de la asignación debe ser mayor a 0.");
        }

        if (fecha == null) {
            throw new ValidationException("La fecha de la asignación no puede ser nula.");
        }

        if (fecha.after(new Date())) {
            throw new BusinessException("La fecha de la asignación no puede ser futura.");
        }

        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new ValidationException("La descripción de la asignación no puede estar vacía.");
        }
    }

    // Validar la existencia de un Rubro
    public static void validarExistenciaRubro(Rubro rubro, Long idRubro) {
        if (rubro == null) {
            throw new BusinessException("El rubro con ID " + idRubro + " no existe.");
        }
    }

    // Validar que la asignación no exceda el presupuesto del rubro
    public static void validarPresupuesto(Rubro rubro, Double monto) {
        if (rubro.getMontoUtilizado() + monto > rubro.getMontoAsignado()) {
            throw new BusinessException("El monto supera el presupuesto asignado al rubro.");
        }
    }

    // Validar la existencia de una asignación
    public static void validarExistenciaAsignacion(Asignacion asignacion, Long idAsignacion) {
        if (asignacion == null) {
            throw new BusinessException("La asignación con ID " + idAsignacion + " no existe.");
        }
    }

    // Validar si el monto asignado se acerca al presupuesto total (90% del presupuesto)
    public static void validarFaltaDeRecursos(Rubro rubro, Double monto) {
        double umbralAlerta = rubro.getMontoAsignado() * 0.9; // 90% del presupuesto
        if ((rubro.getMontoUtilizado() + monto) > umbralAlerta) {
            throw new BusinessException("Alerta: El monto asignado está próximo a superar el presupuesto del rubro.");
        }
    }

    // Validar si el rubro está bajo de gestión (presupuesto bajo)
    public static void validarRubroBajoGestion(Rubro rubro) {
        if (rubro.getMontoAsignado() < 1000) { // Rubro con presupuesto bajo (< 1000)
            throw new BusinessException("Alerta: El rubro '" + rubro.getNombre() + "' tiene un presupuesto muy bajo.");
        }
    }

    // Validar si la fecha límite del rubro está próxima (falta menos de 7 días)
    public static void validarFechaLimiteProxima(Rubro rubro) {
        long diferenciaEnMilisegundos = rubro.getFechaLimite().getTime() - new Date().getTime();
        long diasRestantes = diferenciaEnMilisegundos / (1000 * 60 * 60 * 24);

        if (diasRestantes <= 7) { // 7 días o menos
            throw new BusinessException("Alerta: El rubro '" + rubro.getNombre() + "' está próximo a cumplir su fecha límite.");
        }
    }
}
