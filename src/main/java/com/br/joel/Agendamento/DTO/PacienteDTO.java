package com.br.joel.Agendamento.DTO;

import com.br.joel.Agendamento.domain.Paciente;


public record PacienteDTO(String nome, String sobrenome, String email, String cpf) {

    public PacienteDTO(Paciente paciente) {
        this(paciente.getNome(), paciente.getSobrenome(), paciente.getEmail(), paciente.getCpf());
    }
}
