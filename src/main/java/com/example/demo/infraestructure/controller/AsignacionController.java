package com.example.demo.infraestructure.controller;
import com.example.demo.application.dtos.request.AsignacionRequest;
import com.example.demo.application.dtos.response.AsignacionResponse;
import com.example.demo.application.handler.AsignacionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asignaciones")
public class AsignacionController {

    private final AsignacionHandler asignacionHandler;

    public AsignacionController(AsignacionHandler asignacionHandler) {
        this.asignacionHandler = asignacionHandler;
    }

    // Agregar una asignación a un rubro
    @PostMapping("/{idRubro}")
    public ResponseEntity<AsignacionResponse> agregarAsignacion(@PathVariable Long idRubro, @RequestBody AsignacionRequest request) {
        AsignacionResponse response = asignacionHandler.agregarAsignacion(idRubro, request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Listar todas las asignaciones de un rubro
    @GetMapping("/{idRubro}")
    public ResponseEntity<List<AsignacionResponse>> listarAsignaciones(@PathVariable Long idRubro) {
        List<AsignacionResponse> response = asignacionHandler.listarAsignaciones(idRubro);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Eliminar una asignación
    @DeleteMapping("/{idRubro}/{idAsignacion}")
    public ResponseEntity<Void> eliminarAsignacion(@PathVariable Long idRubro, @PathVariable Long idAsignacion) {
        asignacionHandler.eliminarAsignacion(idRubro, idAsignacion);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}