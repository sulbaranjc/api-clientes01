package com.example.api_clientes01.dao;

import com.example.api_clientes01.model.Pais;

import java.util.List;
import java.util.Optional;

public interface PaisDAO {
    List<Pais> findAll();
    Optional<Pais> findById(Long id);
    Optional<Pais> findByNombre(String nombre);
    Pais save(Pais pais);
    void deleteById(Long id);
}
