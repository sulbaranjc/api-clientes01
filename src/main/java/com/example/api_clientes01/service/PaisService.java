package com.example.api_clientes01.service;

import com.example.api_clientes01.model.Pais;

import java.util.List;
import java.util.Optional;

public interface PaisService {
    List<Pais> getAllPaises();
    Optional<Pais> getPaisById(Long id);
    Optional<Pais> getPaisByNombre(String nombre);
    Pais createPais(Pais pais);
    Pais updatePais(Long id, Pais paisDetails);
    void deletePais(Long id);
}
