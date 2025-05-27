package com.cafe.cafe.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cafe.cafe.model.Pedido;

public interface PedidoService {
    Page<Pedido> getAllPedidos(Pageable pageable);
    Page<Pedido> getPedidosByClienteId(Long clienteId, Pageable pageable);
    Pedido getPedidoById(Long id);
    Pedido createPedido(Pedido pedido);
    Pedido updatePedido(Long id, Pedido pedido);
    void deletePedido(Long id);
} 