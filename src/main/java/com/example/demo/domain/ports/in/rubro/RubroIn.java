package com.example.demo.domain.ports.in.rubro;
import com.example.demo.domain.models.Rubro;
import java.util.Date;
import java.util.List;
public interface RubroIn {
    //Crear un rubro
    Rubro crearRubro(String nombre, Double montoAsignado, Date fechaLimite);
    // Actualizar un rubro
    Rubro actualizarRubro(Long id, String nombre, Double montoAsignado, Date fechaLimite);
    // Eliminar un rubro
    void eliminarRubro(Long id);
    // Obtener un rubro por su ID
    Rubro obtenerRubroPorId(Long id);
    // Listar todos los rubros
    List<Rubro> listarRubros();
}
