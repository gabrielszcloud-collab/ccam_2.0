package com.ccam.ccamv2.controller;

import com.ccam.ccamv2.model.Cliente;
import com.ccam.ccamv2.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*") // Essencial: Permite que o seu site HTML consiga acessar a API sem bloqueios
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    // URL para CADASTRAR pelo site (POST /api/clientes)
    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody Cliente cliente) {
        try {
            Cliente novoCliente = service.salvar(cliente);
            return ResponseEntity.ok(novoCliente);
        } catch (RuntimeException e) {
            // Se der erro (ex: e-mail repetido), devolve o erro formatado
            return ResponseEntity.badRequest().body(Map.of("erro", e.getMessage()));
        }
    }

    // URL para o LOGIN do Flutter (POST /api/clientes/login)
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credenciais) {
        try {
            String email = credenciais.get("email");
            String cpf = credenciais.get("senha"); // O app manda como 'senha', mas nós validamos no campo CPF

            Cliente cliente = service.fazerLogin(email, cpf);
            return ResponseEntity.ok(cliente);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("erro", e.getMessage()));
        }
    }

    // URL para LISTAR todos (GET /api/clientes) - Útil para o Mural e CRM do site
    @GetMapping
    public ResponseEntity<List<Cliente>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }
}