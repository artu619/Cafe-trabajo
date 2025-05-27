package com.cafe.cafe.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cafe.cafe.model.Cliente;

public interface ClienteService {
    Page<Cliente> getAllClientes(Pageable pageable);
    Cliente getClienteById(Long id);
    Cliente createCliente(Cliente cliente);
    Cliente updateCliente(Long id, Cliente cliente);
    void deleteCliente(Long id);
} 