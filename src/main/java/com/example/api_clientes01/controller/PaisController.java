package com.example.api_clientes01.controller;

import com.example.api_clientes01.model.Pais;
import com.example.api_clientes01.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/paises")
public class PaisController {

    @Autowired
    private PaisRepository paisRepository;

    @GetMapping
    public List<Pais> getAllPaises() {
        return paisRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pais> getPaisById(@PathVariable Long id) {
        Optional<Pais> pais = paisRepository.findById(id);
        return pais.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> createPais(@RequestBody Pais pais) {
        Optional<Pais> existingPais = paisRepository.findByNombre(pais.getNombre());
        if (existingPais.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El país ya está registrado.");
        }
        paisRepository.save(pais);
        return ResponseEntity.status(HttpStatus.CREATED).body("País creado exitosamente.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pais> updatePais(@PathVariable Long id, @RequestBody Pais paisDetails) {
        Optional<Pais> pais = paisRepository.findById(id);
        if (pais.isPresent()) {
            Pais paisToUpdate = pais.get();
            paisToUpdate.setNombre(paisDetails.getNombre());
            final Pais updatedPais = paisRepository.save(paisToUpdate);
            return ResponseEntity.ok(updatedPais);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePais(@PathVariable Long id) {
        Optional<Pais> pais = paisRepository.findById(id);
        if (pais.isPresent()) {
            paisRepository.delete(pais.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
