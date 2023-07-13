package com.br.joel.Agendamento.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.print.attribute.standard.MediaSize;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Table(name = "agenda")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name = "descricao")
    private  String descricao;

    @Column(name = "data_hora")
    private LocalDateTime horario;
    @Column(name = "data_criacao")
    private LocalDateTime data_criacao;
    @Column(name = "email")
    private String email;
    @ManyToOne()
    private Set<Paciente> paciente = new HashSet<>();
}
