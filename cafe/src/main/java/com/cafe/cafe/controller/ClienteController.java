package com.cafe.cafe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe.cafe.model.Cliente;
import com.cafe.cafe.service.ClienteService;

/**
 * Controlador REST para la gestión de clientes.
 * Proporciona endpoints para realizar operaciones CRUD sobre los clientes.
 */
@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    /**
     * Obtiene la lista de todos los clientes registrados
     * @return ResponseEntity con la lista de clientes y estado HTTP 200
     */
    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes() {
        List<Cliente> clientes = clienteService.getAllClientes();
        return ResponseEntity.ok(clientes);
    }

    /**
     * Obtiene un cliente específico por su ID
     * @param id Identificador del cliente
     * @return ResponseEntity con el cliente encontrado (200) o no encontrado (404)
     */
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
        Cliente cliente = clienteService.getClienteById(id);
        return cliente != null ? 
            ResponseEntity.ok(cliente) : 
            ResponseEntity.notFound().build();
    }

    /**
     * Crea un nuevo cliente
     * @param cliente Datos del cliente a crear
     * @return ResponseEntity con el cliente creado (201) o error (400)
     */
    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        Cliente nuevoCliente = clienteService.createCliente(cliente);
        return nuevoCliente != null ? 
            ResponseEntity.status(HttpStatus.CREATED).body(nuevoCliente) : 
            ResponseEntity.badRequest().build();
    }

    /**
     * Actualiza los datos de un cliente existente
     * @param id Identificador del cliente a actualizar
     * @param cliente Nuevos datos del cliente
     * @return ResponseEntity con el cliente actualizado (200) o no encontrado (404)
     */
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        Cliente updatedCliente = clienteService.updateCliente(id, cliente);
        return updatedCliente != null ? 
            ResponseEntity.ok(updatedCliente) : 
            ResponseEntity.notFound().build();
    }

    /**
     * Elimina un cliente del sistema
     * @param id Identificador del cliente a eliminar
     * @return ResponseEntity sin contenido (204) si se eliminó correctamente, o no encontrado (404)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        Cliente cliente = clienteService.getClienteById(id);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }
        clienteService.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }
} 