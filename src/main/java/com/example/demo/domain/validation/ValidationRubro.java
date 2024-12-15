package com.example.demo.domain.validation;

import com.example.demo.domain.exception.BusinessException;
import com.example.demo.domain.exception.ValidationException;
import com.example.demo.domain.models.Rubro;
import java.util.Date;
public class ValidationRubro {

    // Validar los datos al crear o actualizar un Rubro
    public static void validarDatosRubro(String nombre, Double montoAsignado, Date fechaLimite) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new ValidationException("El nombre del rubro no puede estar vacío.");
        }

        if (nombre.length() > 50) {
            throw new ValidationException("El nombre del rubro no puede tener más de 50 caracteres.");
        }

        if (montoAsignado == null || montoAsignado <= 0) {
            throw new ValidationException("El monto asignado debe ser mayor a 0.");
        }

        if (fechaLimite == null) {
            throw new ValidationException("La fecha límite no puede ser nula.");
        }

        if (fechaLimite.before(new Date())) {
            throw new BusinessException("La fecha límite no puede ser anterior a la fecha actual.");
        }
    }

    // Validar que un Rubro exista
    public static void validarExistenciaRubro(Rubro rubro, Long id) {
        if (rubro == null) {
            throw new BusinessException("El rubro con ID " + id + " no existe.");
        }
    }
}
