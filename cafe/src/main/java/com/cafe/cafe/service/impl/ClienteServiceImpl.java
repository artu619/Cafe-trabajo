package com.cafe.cafe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe.cafe.model.Cliente;
import com.cafe.cafe.repository.ClienteRepository;
import com.cafe.cafe.service.ClienteService;

@Service
@Transactional
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Page<Cliente> getAllClientes(Pageable pageable) {
        return clienteRepository.findAll(pageable);
    }

    @Override
    public Cliente getClienteById(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con id: " + id));
    }

    @Override
    public Cliente createCliente(Cliente cliente) {
        if (cliente.getNombre() == null || cliente.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del cliente no puede estar vacío");
        }
        if (cliente.getEmail() == null || cliente.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("El email del cliente no puede estar vacío");
        }
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente updateCliente(Long id, Cliente cliente) {
        Cliente existingCliente = getClienteById(id);
        
        if (cliente.getNombre() != null && !cliente.getNombre().trim().isEmpty()) {
            existingCliente.setNombre(cliente.getNombre());
        }
        if (cliente.getEmail() != null && !cliente.getEmail().trim().isEmpty()) {
            existingCliente.setEmail(cliente.getEmail());
        }
        if (cliente.getTelefono() != null) {
            existingCliente.setTelefono(cliente.getTelefono());
        }
        
        return clienteRepository.save(existingCliente);
    }

    @Override
    public void deleteCliente(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new RuntimeException("Cliente no encontrado con id: " + id);
        }
        clienteRepository.deleteById(id);
    }
} 