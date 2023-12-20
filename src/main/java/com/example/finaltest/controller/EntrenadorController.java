package com.example.finaltest.controller;

import com.example.finaltest.entities.Entrenador;
import com.example.finaltest.repository.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/entrenadores")

public class EntrenadorController {
    @Autowired
    EntrenadorRepository entrenadorRepository;
    @GetMapping
    public List<Entrenador> getEntrenadoresAll() {
        return entrenadorRepository.findAll();
    }
    @GetMapping("/{id}")
    public Entrenador getEntrenadoresbyId(@PathVariable Integer id) {
        Optional<Entrenador> entrenador = entrenadorRepository.findById(id);
        if (entrenador.isPresent()) {
            return entrenador.get();
        }
        return null;
    }
    @PostMapping
    public Entrenador postEntrenador(@RequestBody Entrenador entrenador) {
        entrenadorRepository.save(entrenador);
        return entrenador;
    }
    @PutMapping("/{id}")
    public Entrenador putEntrenadoresbyId(@PathVariable Integer id, @RequestBody Entrenador entrenador) {
        Optional<Entrenador> entrenadorCurrent = entrenadorRepository.findById(id);
        if (entrenadorCurrent.isPresent()) {
            Entrenador entrenadorReturn = entrenadorCurrent.get();
            entrenadorReturn.setNombre(entrenador.getNombre());
            entrenadorReturn.setEmail(entrenador.getEmail());
            entrenadorRepository.save(entrenadorReturn);
            return entrenadorReturn;
        }
        return null;
    }
}