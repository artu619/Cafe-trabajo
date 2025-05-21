package com.cafe.cafe.controllers;

import com.cafe.cafe.model.Cafe;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;





import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/cafes")
public class CafesController {

    private List<Cafe> cafes = new ArrayList<>();

    @GetMapping
    public List<Cafe> obtenerCafes() {
        return cafes;
    }

    @PostMapping
    public String agregarCafe(@RequestBody Cafe cafe) {
        // Validar que el ID no esté ya en uso
        boolean existe = cafes.stream().anyMatch(c -> c.getId().equals(cafe.getId()));
        if (existe) {
            return "Error: El ID " + cafe.getId() + " ya está en uso.";
        }

        cafes.add(cafe);
        return "Café agregado: ID " + cafe.getId() +
                ", Nombre " + cafe.getNombre() +
                ", Precio $" + cafe.getPrecio() +
                ", Origen " + cafe.getOrigen();

    }

    @GetMapping("/{id}")
    public Cafe obtenerCafePorId(@PathVariable Long id) {
        return cafes.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    public String eliminarCafe(@PathVariable Long id) {
        boolean eliminado = cafes.removeIf(c -> c.getId().equals(id));
        return eliminado ? "Café eliminado con ID: " + id : "Café no encontrado con ID: " + id;
    }
}

