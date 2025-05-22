package com.cafe.cafe.service;

import java.util.List;

import com.cafe.cafe.model.Pedido;

public interface PedidoService {
    List<Pedido> getAllPedidos();
    Pedido getPedidoById(Long id);
    Pedido createPedido(Pedido pedido);
    Pedido updatePedido(Long id, Pedido pedido);
    void deletePedido(Long id);
    List<Pedido> getPedidosByClienteId(Long clienteId);
} 