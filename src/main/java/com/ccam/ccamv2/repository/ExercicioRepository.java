package com.ccam.ccamv2.repository;

import com.ccam.ccamv2.model.Exercicio;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface ExercicioRepository extends JpaRepository<Exercicio, UUID> {
    // Busca o treino de um aluno para o dia específico
    List<Exercicio> findByClienteIdAndDiaSemana(UUID clienteId, String diaSemana);
}