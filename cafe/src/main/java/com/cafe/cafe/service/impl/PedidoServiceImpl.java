package com.cafe.cafe.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cafe.cafe.model.Pedido;
import com.cafe.cafe.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService {
    private final List<Pedido> pedidos = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong();

    @Override
    public List<Pedido> getAllPedidos() {
        return new ArrayList<>(pedidos);
    }

    @Override
    public Pedido getPedidoById(Long id) {
        if (id == null) return null;
        return pedidos.stream()
                .filter(pedido -> pedido.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Pedido createPedido(Pedido pedido) {
        if (pedido == null || pedido.getClienteId() == null || 
            pedido.getCafeId() == null || pedido.getCantidad() <= 0) {
            return null;
        }
        pedido.setId(idGenerator.incrementAndGet());
        pedidos.add(pedido);
        return pedido;
    }

    @Override
    public Pedido updatePedido(Long id, Pedido pedidoActualizado) {
        if (id == null || pedidoActualizado == null || 
            pedidoActualizado.getClienteId() == null || 
            pedidoActualizado.getCafeId() == null || 
            pedidoActualizado.getCantidad() <= 0) {
            return null;
        }

        for (int i = 0; i < pedidos.size(); i++) {
            if (pedidos.get(i).getId().equals(id)) {
                pedidoActualizado.setId(id);
                pedidos.set(i, pedidoActualizado);
                return pedidoActualizado;
            }
        }
        return null;
    }

    @Override
    public void deletePedido(Long id) {
        if (id != null) {
            pedidos.removeIf(pedido -> pedido.getId().equals(id));
        }
    }

    @Override
    public List<Pedido> getPedidosByClienteId(Long clienteId) {
        if (clienteId == null) return new ArrayList<>();
        return pedidos.stream()
                .filter(pedido -> pedido.getClienteId().equals(clienteId))
                .collect(Collectors.toList());
    }
} 