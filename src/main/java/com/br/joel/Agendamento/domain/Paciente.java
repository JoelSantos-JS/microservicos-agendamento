package com.br.joel.Agendamento.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "paciente")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @NotEmpty(message = "O campo nome deve ser preenchido")
    private  String nome;

    @NotEmpty(message = "O campo sobrenome deve ser preenchido")
    private  String sobrenome;
    private  String cpf;

    @NotEmpty(message = "O campo email deve ser preenchido")
    private  String email;






}
