package com.ccam.ccamv2.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

@Data
@Entity
@Table(name = "exercicios")
public class Exercicio {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "cliente_id", nullable = false)
    private UUID clienteId;

    @Column(name = "dia_semana", nullable = false)
    private String diaSemana; // "Segunda-feira", "Terça-feira", etc.

    @Column(name = "nome_exercicio", nullable = false)
    private String nomeExercicio;

    private String series;     // Ex: "4"
    private String repeticoes; // Ex: "10 a 12 reps"
    private String carga;      // Ex: "20kg"

    @Column(name = "imagem_url")
    private String imagemUrl;
}