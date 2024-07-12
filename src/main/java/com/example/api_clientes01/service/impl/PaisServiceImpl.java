package com.example.api_clientes01.service.impl;

import com.example.api_clientes01.dao.PaisDAO;
import com.example.api_clientes01.model.Pais;
import com.example.api_clientes01.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaisServiceImpl implements PaisService {

    @Autowired
    private PaisDAO paisDAO;

    @Override
    public List<Pais> getAllPaises() {
        return paisDAO.findAll();
    }

    @Override
    public Optional<Pais> getPaisById(Long id) {
        return paisDAO.findById(id);
    }

    @Override
    public Optional<Pais> getPaisByNombre(String nombre) {
        return paisDAO.findByNombre(nombre);
    }

    @Override
    public Pais createPais(Pais pais) {
        return paisDAO.save(pais);
    }

    @Override
    public Pais updatePais(Long id, Pais paisDetails) {
        Optional<Pais> pais = paisDAO.findById(id);
        if (pais.isPresent()) {
            Pais paisToUpdate = pais.get();
            paisToUpdate.setNombre(paisDetails.getNombre());
            return paisDAO.save(paisToUpdate);
        } else {
            return null;
        }
    }

    @Override
    public void deletePais(Long id) {
        paisDAO.deleteById(id);
    }
}
