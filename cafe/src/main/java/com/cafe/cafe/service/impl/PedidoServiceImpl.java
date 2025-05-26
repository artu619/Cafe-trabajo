package com.cafe.cafe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe.cafe.model.Pedido;
import com.cafe.cafe.repository.PedidoRepository;
import com.cafe.cafe.service.PedidoService;

@Service
@Transactional
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido getPedidoById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo");
        }
        return pedidoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Pedido no encontrado con ID: " + id));
    }

    @Override
    public Pedido createPedido(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("El pedido no puede ser nulo");
        }
        if (pedido.getCliente() == null || pedido.getCliente().getId() == null) {
            throw new IllegalArgumentException("El cliente es obligatorio");
        }
        if (pedido.getCafe() == null || pedido.getCafe().getId() == null) {
            throw new IllegalArgumentException("El café es obligatorio");
        }
        if (pedido.getCantidad() <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que 0");
        }

        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido updatePedido(Long id, Pedido pedido) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo");
        }
        if (pedido == null) {
            throw new IllegalArgumentException("El pedido no puede ser nulo");
        }
        if (pedido.getCliente() == null || pedido.getCliente().getId() == null) {
            throw new IllegalArgumentException("El cliente es obligatorio");
        }
        if (pedido.getCafe() == null || pedido.getCafe().getId() == null) {
            throw new IllegalArgumentException("El café es obligatorio");
        }
        if (pedido.getCantidad() <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que 0");
        }

        return pedidoRepository.findById(id)
            .map(pedidoExistente -> {
                pedidoExistente.setCliente(pedido.getCliente());
                pedidoExistente.setCafe(pedido.getCafe());
                pedidoExistente.setCantidad(pedido.getCantidad());
                return pedidoRepository.save(pedidoExistente);
            })
            .orElseThrow(() -> new RuntimeException("Pedido no encontrado con ID: " + id));
    }

    @Override
    public void deletePedido(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo");
        }
        if (!pedidoRepository.existsById(id)) {
            throw new RuntimeException("Pedido no encontrado con ID: " + id);
        }
        pedidoRepository.deleteById(id);
    }

    @Override
    public List<Pedido> getPedidosByClienteId(Long clienteId) {
        if (clienteId == null) {
            throw new IllegalArgumentException("El ID del cliente no puede ser nulo");
        }
        return pedidoRepository.findByCliente_Id(clienteId);
    }
} 