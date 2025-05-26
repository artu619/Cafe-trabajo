package com.cafe.cafe.controllers;

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
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<Pedido>> obtenerPedidos() {
        return ResponseEntity.ok(pedidoService.getAllPedidos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> obtenerPedido(@PathVariable Long id) {
        Pedido pedido = pedidoService.getPedidoById(id);
        if (pedido != null) {
            return ResponseEntity.ok(pedido);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<Pedido>> obtenerPedidosPorCliente(@PathVariable Long clienteId) {
        return ResponseEntity.ok(pedidoService.getPedidosByClienteId(clienteId));
    }

    @PostMapping
    public ResponseEntity<?> crearPedido(@RequestBody Pedido pedido) {
        try {
            if (pedido.getCliente() == null || pedido.getCliente().getId() == null) {
                return ResponseEntity.badRequest()
                    .body("Error: El cliente es obligatorio");
            }
            if (pedido.getCafe() == null || pedido.getCafe().getId() == null) {
                return ResponseEntity.badRequest()
                    .body("Error: El café es obligatorio");
            }
            if (pedido.getCantidad() <= 0) {
                return ResponseEntity.badRequest()
                    .body("Error: La cantidad debe ser mayor que 0");
            }

            Pedido pedidoGuardado = pedidoService.createPedido(pedido);
            return ResponseEntity.status(HttpStatus.CREATED)
                .body("Pedido creado exitosamente: " + pedidoGuardado.getId());
                
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error al procesar la solicitud: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> actualizarPedido(@PathVariable Long id, @RequestBody Pedido pedido) {
        if (pedido.getCliente() == null || pedido.getCliente().getId() == null || 
            pedido.getCafe() == null || pedido.getCafe().getId() == null ||
            pedido.getCantidad() <= 0) {
            return ResponseEntity.badRequest().build();
        }

        Pedido pedidoActualizado = pedidoService.updatePedido(id, pedido);
        if (pedidoActualizado != null) {
            return ResponseEntity.ok(pedidoActualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPedido(@PathVariable Long id) {
        Pedido pedido = pedidoService.getPedidoById(id);
        if (pedido != null) {
            pedidoService.deletePedido(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
} 