package com.gilberto.capsula_do_tempo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "capsulas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Capsula {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    @Column(columnDefinition = "TEXT")
    private String mensagem;
    private String caminhoImagem;
    private LocalDate dataEntrega;
    private Boolean entregue = false;
    private LocalDateTime dataCriacao = LocalDateTime.now();
}
