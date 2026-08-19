package com.ccam.ccamv2.repository;

import com.ccam.ccamv2.model.Financeiro;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface FinanceiroRepository extends JpaRepository<Financeiro, UUID> {
    // Busca as cobranças de um aluno específico, da mais nova para a mais velha
    List<Financeiro> findByClienteIdOrderByVencimentoDesc(UUID clienteId);
}