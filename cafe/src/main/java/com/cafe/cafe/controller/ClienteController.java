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

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes() {
        List<Cliente> clientes = clienteService.getAllClientes();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
        Cliente cliente = clienteService.getClienteById(id);
        return cliente != null ? 
            ResponseEntity.ok(cliente) : 
            ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        Cliente nuevoCliente = clienteService.createCliente(cliente);
        return nuevoCliente != null ? 
            ResponseEntity.status(HttpStatus.CREATED).body(nuevoCliente) : 
            ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        Cliente updatedCliente = clienteService.updateCliente(id, cliente);
        return updatedCliente != null ? 
            ResponseEntity.ok(updatedCliente) : 
            ResponseEntity.notFound().build();
    }

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