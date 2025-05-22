package com.cafe.cafe.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.cafe.cafe.model.Cliente;
import com.cafe.cafe.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
    private final List<Cliente> clientes = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong();

    @Override
    public List<Cliente> getAllClientes() {
        return new ArrayList<>(clientes);
    }

    @Override
    public Cliente getClienteById(Long id) {
        if (id == null) return null;
        return clientes.stream()
                .filter(cliente -> cliente.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Cliente createCliente(Cliente cliente) {
        if (cliente == null || cliente.getNombre() == null || cliente.getNombre().trim().isEmpty()) {
            return null;
        }
        cliente.setId(idGenerator.incrementAndGet());
        clientes.add(cliente);
        return cliente;
    }

    @Override
    public Cliente updateCliente(Long id, Cliente clienteActualizado) {
        if (id == null || clienteActualizado == null || 
            clienteActualizado.getNombre() == null || 
            clienteActualizado.getNombre().trim().isEmpty()) {
            return null;
        }
        
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId().equals(id)) {
                clienteActualizado.setId(id);
                clientes.set(i, clienteActualizado);
                return clienteActualizado;
            }
        }
        return null;
    }

    @Override
    public void deleteCliente(Long id) {
        if (id != null) {
            clientes.removeIf(cliente -> cliente.getId().equals(id));
        }
    }
} 