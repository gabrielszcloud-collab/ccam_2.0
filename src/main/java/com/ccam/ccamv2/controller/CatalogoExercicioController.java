package com.ccam.ccamv2.controller;

import com.ccam.ccamv2.model.CatalogoExercicio;
import com.ccam.ccamv2.repository.CatalogoExercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalogo")
@CrossOrigin(origins = "*") // Permite que o seu HTML acesse a API
public class CatalogoExercicioController {

    @Autowired
    private CatalogoExercicioRepository repository;

    @GetMapping
    public List<CatalogoExercicio> listarCatalogo() {
        return repository.findAll();
    }
}