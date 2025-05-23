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

/**
 * Controlador REST para la gestión de pedidos.
 * Proporciona endpoints para realizar operaciones CRUD sobre los pedidos de café.
 */
@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    /**
     * Obtiene la lista de todos los pedidos registrados
     * @return ResponseEntity con la lista de pedidos y estado HTTP 200
     */
    @GetMapping
    public ResponseEntity<List<Pedido>> getAllPedidos() {
        List<Pedido> pedidos = pedidoService.getAllPedidos();
        return ResponseEntity.ok(pedidos);
    }

    /**
     * Obtiene un pedido específico por su ID
     * @param id Identificador del pedido
     * @return ResponseEntity con el pedido encontrado (200) o no encontrado (404)
     */
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getPedidoById(@PathVariable Long id) {
        Pedido pedido = pedidoService.getPedidoById(id);
        return pedido != null ? 
            ResponseEntity.ok(pedido) : 
            ResponseEntity.notFound().build();
    }

    /**
     * Obtiene todos los pedidos realizados por un cliente específico
     * @param clienteId Identificador del cliente
     * @return ResponseEntity con la lista de pedidos del cliente y estado HTTP 200
     */
    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<Pedido>> getPedidosByClienteId(@PathVariable Long clienteId) {
        List<Pedido> pedidos = pedidoService.getPedidosByClienteId(clienteId);
        return ResponseEntity.ok(pedidos);
    }

    /**
     * Crea un nuevo pedido
     * @param pedido Datos del pedido a crear
     * @return ResponseEntity con el pedido creado (201) o error (400)
     */
    @PostMapping
    public ResponseEntity<Pedido> createPedido(@RequestBody Pedido pedido) {
        Pedido nuevoPedido = pedidoService.createPedido(pedido);
        return nuevoPedido != null ? 
            ResponseEntity.status(HttpStatus.CREATED).body(nuevoPedido) : 
            ResponseEntity.badRequest().build();
    }

    /**
     * Actualiza los datos de un pedido existente
     * @param id Identificador del pedido a actualizar
     * @param pedido Nuevos datos del pedido
     * @return ResponseEntity con el pedido actualizado (200) o no encontrado (404)
     */
    @PutMapping("/{id}")
    public ResponseEntity<Pedido> updatePedido(@PathVariable Long id, @RequestBody Pedido pedido) {
        Pedido updatedPedido = pedidoService.updatePedido(id, pedido);
        return updatedPedido != null ? 
            ResponseEntity.ok(updatedPedido) : 
            ResponseEntity.notFound().build();
    }

    /**
     * Elimina un pedido del sistema
     * @param id Identificador del pedido a eliminar
     * @return ResponseEntity sin contenido (204) si se eliminó correctamente, o no encontrado (404)
     */
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