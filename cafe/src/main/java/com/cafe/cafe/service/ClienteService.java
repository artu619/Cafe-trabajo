package com.cafe.cafe.service;

import java.util.List;

import com.cafe.cafe.model.Cliente;

public interface ClienteService {
    List<Cliente> getAllClientes();
    Cliente getClienteById(Long id);
    Cliente createCliente(Cliente cliente);
    Cliente updateCliente(Long id, Cliente cliente);
    void deleteCliente(Long id);
} 