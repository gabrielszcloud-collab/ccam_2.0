package com.ccam.ccamv2.controller;

import com.ccam.ccamv2.model.Financeiro;
import com.ccam.ccamv2.repository.FinanceiroRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/financeiro")
@CrossOrigin(origins = "*")
public class FinanceiroController {

    private final FinanceiroRepository repository;

    public FinanceiroController(FinanceiroRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<Financeiro>> buscarPorCliente(@PathVariable UUID clienteId) {
        return ResponseEntity.ok(repository.findByClienteIdOrderByVencimentoDesc(clienteId));
    }

    @PostMapping
    public ResponseEntity<Financeiro> registrarCobranca(@RequestBody Financeiro financeiro) {
        return ResponseEntity.ok(repository.save(financeiro));
    }
}