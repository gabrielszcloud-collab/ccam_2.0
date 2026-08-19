package com.ccam.ccamv2.service;

import com.ccam.ccamv2.model.Cliente;
import com.ccam.ccamv2.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service // Avisa ao Spring que esta classe contém as regras de negócio
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente salvar(Cliente cliente) {
        // Regra: Verifica se o e-mail ou CPF já existem no banco
        if (repository.findByEmail(cliente.getEmail()).isPresent()) {
            throw new RuntimeException("E-mail já cadastrado!");
        }
        if (repository.findByCpf(cliente.getCpf()).isPresent()) {
            throw new RuntimeException("CPF já cadastrado!");
        }
        return repository.save(cliente);
    }

    public Cliente fazerLogin(String email, String cpf) {
        // Regra: Tenta achar o aluno. Se não achar, devolve um erro.
        return repository.findByEmailAndCpf(email, cpf)
                .orElseThrow(() -> new RuntimeException("E-mail ou senha (CPF) incorretos."));
    }

    public List<Cliente> listarTodos() {
        return repository.findAll();
    }
}