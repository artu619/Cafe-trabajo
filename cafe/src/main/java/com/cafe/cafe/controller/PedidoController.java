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

import com.cafe.cafe.model.Pedido;
import com.cafe.cafe.service.PedidoService;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<Pedido>> getAllPedidos() {
        List<Pedido> pedidos = pedidoService.getAllPedidos();
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getPedidoById(@PathVariable Long id) {
        Pedido pedido = pedidoService.getPedidoById(id);
        return pedido != null ? 
            ResponseEntity.ok(pedido) : 
            ResponseEntity.notFound().build();
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<Pedido>> getPedidosByClienteId(@PathVariable Long clienteId) {
        List<Pedido> pedidos = pedidoService.getPedidosByClienteId(clienteId);
        return ResponseEntity.ok(pedidos);
    }

    @PostMapping
    public ResponseEntity<Pedido> createPedido(@RequestBody Pedido pedido) {
        Pedido nuevoPedido = pedidoService.createPedido(pedido);
        return nuevoPedido != null ? 
            ResponseEntity.status(HttpStatus.CREATED).body(nuevoPedido) : 
            ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> updatePedido(@PathVariable Long id, @RequestBody Pedido pedido) {
        Pedido updatedPedido = pedidoService.updatePedido(id, pedido);
        return updatedPedido != null ? 
            ResponseEntity.ok(updatedPedido) : 
            ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePedido(@PathVariable Long id) {
        Pedido pedido = pedidoService.getPedidoById(id);
        if (pedido == null) {
            return ResponseEntity.notFound().build();
        }
        pedidoService.deletePedido(id);
        return ResponseEntity.noContent().build();
    }
} 