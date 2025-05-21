package com.cafe.cafe.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe.cafe.model.Cafe;

@RestController
@RequestMapping("/coffee")
public class CafesController {

    private List<Cafe> cafes = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Cafe>> obtenerCafes() {
        return ResponseEntity.ok(cafes);
    }

    @PostMapping
    public ResponseEntity<?> agregarCafe(@RequestBody Cafe cafe) {
        try {
            // Verificar si el ID ya está en uso
            boolean existe = cafes.stream().anyMatch(c -> c.getId().equals(cafe.getId()));
            if (existe) {
                return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Error: El café con ID " + cafe.getId() + " ya existe");
            }

            // Validar campos obligatorios
            if (cafe.getId() == null) {
                return ResponseEntity.badRequest()
                    .body("Error: El ID es obligatorio");
            }
            if (cafe.getNombre() == null || cafe.getNombre().trim().isEmpty()) {
                return ResponseEntity.badRequest()
                    .body("Error: El nombre es obligatorio");
            }
            if (cafe.getPrecio() <= 0) {
                return ResponseEntity.badRequest()
                    .body("Error: El precio debe ser mayor que 0");
            }

            cafes.add(cafe);
            return ResponseEntity.status(HttpStatus.CREATED)
                .body("Café agregado exitosamente: " + cafe.getNombre());
                
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error al procesar la solicitud: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cafe> actualizarCafe(@PathVariable Long id, @RequestBody Cafe cafe) {
        // Validar campos obligatorios
        if (cafe.getId() == null || cafe.getNombre() == null || cafe.getPrecio() <= 0) {
            return ResponseEntity.badRequest().build();
        }

        Optional<Cafe> cafeExistente = cafes.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();

        if (cafeExistente.isPresent()) {
            cafes.removeIf(c -> c.getId().equals(id));
            cafes.add(cafe);
            return ResponseEntity.ok(cafe);
        }

        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Cafe> actualizarCafeParcial(@PathVariable Long id, @RequestBody Cafe cafe) {
        Optional<Cafe> cafeExistente = cafes.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();

        if (cafeExistente.isPresent()) {
            Cafe cafeActual = cafeExistente.get();
            
            // Actualizar solo los campos proporcionados
            if (cafe.getNombre() != null) {
                cafeActual.setNombre(cafe.getNombre());
            }
            if (cafe.getPrecio() > 0) {
                cafeActual.setPrecio(cafe.getPrecio());
            }
            if (cafe.getOrigen() != null) {
                cafeActual.setOrigen(cafe.getOrigen());
            }

            return ResponseEntity.ok(cafeActual);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCafe(@PathVariable Long id) {
        boolean eliminado = cafes.removeIf(c -> c.getId().equals(id));
        return eliminado ? 
            ResponseEntity.ok().build() : 
            ResponseEntity.notFound().build();
    }
}

