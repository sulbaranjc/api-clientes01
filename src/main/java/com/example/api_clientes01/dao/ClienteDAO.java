package com.example.api_clientes01.dao;

import com.example.api_clientes01.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteDAO {
    List<Cliente> findAll();
    Optional<Cliente> findById(Long id);
    Cliente save(Cliente cliente);
    void deleteById(Long id);
}
