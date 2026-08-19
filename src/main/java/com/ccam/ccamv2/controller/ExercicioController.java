package com.ccam.ccamv2.controller;

import com.ccam.ccamv2.model.Exercicio;
import com.ccam.ccamv2.repository.ExercicioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/exercicios")
@CrossOrigin(origins = "*")
public class ExercicioController {

    private final ExercicioRepository repository;

    public ExercicioController(ExercicioRepository repository) {
        this.repository = repository;
    }

    // O Flutter vai chamar essa URL mandando o ID do aluno e o dia (ex: /api/exercicios/cliente/123/dia/Segunda-feira)
    @GetMapping("/cliente/{clienteId}/dia/{diaSemana}")
    public ResponseEntity<List<Exercicio>> buscarTreinoDoDia(@PathVariable UUID clienteId, @PathVariable String diaSemana) {
        return ResponseEntity.ok(repository.findByClienteIdAndDiaSemana(clienteId, diaSemana));
    }

    @PostMapping
    public ResponseEntity<Exercicio> adicionarExercicio(@RequestBody Exercicio exercicio) {
        return ResponseEntity.ok(repository.save(exercicio));
    }
}