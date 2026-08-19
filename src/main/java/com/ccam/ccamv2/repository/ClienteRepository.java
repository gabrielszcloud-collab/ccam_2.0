package com.ccam.ccamv2.repository;

import com.ccam.ccamv2.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

// JpaRepository<Tabela, TipoDaChavePrimaria>
public interface ClienteRepository extends JpaRepository<Cliente, UUID> {

    // O Spring cria o SQL automaticamente só por lermos o nome deste método em inglês
    // Equivalente a: SELECT * FROM clientes WHERE email = ? AND cpf = ?
    Optional<Cliente> findByEmailAndCpf(String email, String cpf);

    // Equivalente a: SELECT * FROM clientes WHERE email = ?
    Optional<Cliente> findByEmail(String email);

    // Equivalente a: SELECT * FROM clientes WHERE cpf = ?
    Optional<Cliente> findByCpf(String cpf);
}