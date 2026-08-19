package com.ccam.ccamv2.controller;

import com.ccam.ccamv2.model.Mural;
import com.ccam.ccamv2.repository.MuralRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mural")
@CrossOrigin(origins = "*")
public class MuralController {

    private final MuralRepository repository;

    public MuralController(MuralRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Mural>> listarMural() {
        return ResponseEntity.ok(repository.findAllByOrderByDataPublicacaoDesc());
    }

    @PostMapping
    public ResponseEntity<Mural> publicarAviso(@RequestBody Mural aviso) {
        return ResponseEntity.ok(repository.save(aviso));
    }
}