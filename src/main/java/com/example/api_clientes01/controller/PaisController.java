package com.example.api_clientes01.controller;

import com.example.api_clientes01.model.Pais;
import com.example.api_clientes01.service.PaisService;
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
    private PaisService paisService;

    @GetMapping
    public List<Pais> getAllPaises() {
        return paisService.getAllPaises();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pais> getPaisById(@PathVariable Long id) {
        Optional<Pais> pais = paisService.getPaisById(id);
        return pais.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> createPais(@RequestBody Pais pais) {
        Optional<Pais> existingPais = paisService.getPaisByNombre(pais.getNombre());
        if (existingPais.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El país ya está registrado.");
        }
        paisService.createPais(pais);
        return ResponseEntity.status(HttpStatus.CREATED).body("País creado exitosamente.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pais> updatePais(@PathVariable Long id, @RequestBody Pais paisDetails) {
        Pais updatedPais = paisService.updatePais(id, paisDetails);
        if (updatedPais != null) {
            return ResponseEntity.ok(updatedPais);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePais(@PathVariable Long id) {
        paisService.deletePais(id);
        return ResponseEntity.ok().build();
    }
}
