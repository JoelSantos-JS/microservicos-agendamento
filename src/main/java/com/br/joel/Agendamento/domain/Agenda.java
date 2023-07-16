package com.br.joel.Agendamento.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.time.LocalDateTime;

@Table(name = "agenda")
@Entity
@Data
@AllArgsConstructor

@Builder
public class Agenda implements Serializable {

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
    private Paciente paciente ;



    public  Agenda() {

    }
}
