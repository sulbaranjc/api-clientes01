package com.example.api_clientes01.dao.impl;

import com.example.api_clientes01.dao.PaisDAO;
import com.example.api_clientes01.model.Pais;
import com.example.api_clientes01.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PaisDAOImpl implements PaisDAO {

    @Autowired
    private PaisRepository paisRepository;

    @Override
    public List<Pais> findAll() {
        return paisRepository.findAll();
    }

    @Override
    public Optional<Pais> findById(Long id) {
        return paisRepository.findById(id);
    }

    @Override
    public Optional<Pais> findByNombre(String nombre) {
        return paisRepository.findByNombre(nombre);
    }

    @Override
    public Pais save(Pais pais) {
        return paisRepository.save(pais);
    }

    @Override
    public void deleteById(Long id) {
        paisRepository.deleteById(id);
    }
}
