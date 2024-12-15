package com.example.demo.infraestructure.controller;

import com.example.demo.application.dtos.request.RubroRequest;
import com.example.demo.application.dtos.response.RubroResponse;
import com.example.demo.application.handler.RubroHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rubros")
public class RubroController {
    private final RubroHandler rubroHandler;

    public RubroController(RubroHandler rubroHandler) {
        this.rubroHandler = rubroHandler;
    }

    // Crear un rubro
    @PostMapping
    public ResponseEntity<RubroResponse> crearRubro(@RequestBody RubroRequest request) {
        RubroResponse response = rubroHandler.crearRubro(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Listar todos los rubros
    @GetMapping
    public ResponseEntity<List<RubroResponse>> listarRubros() {
        List<RubroResponse> response = rubroHandler.listarRubros();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Obtener un rubro por su ID
    @GetMapping("/{id}")
    public ResponseEntity<RubroResponse> obtenerRubro(@PathVariable Long id) {
        RubroResponse response = rubroHandler.obtenerRubro(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Actualizar un rubro
    @PutMapping("/{id}")
    public ResponseEntity<RubroResponse> actualizarRubro(@PathVariable Long id, @RequestBody RubroRequest request) {
        RubroResponse response = rubroHandler.actualizarRubro(id, request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Eliminar un rubro
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRubro(@PathVariable Long id) {
        rubroHandler.eliminarRubro(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}