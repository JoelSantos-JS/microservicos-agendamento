package com.br.joel.Agendamento.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AgendaDTO {

    private  String descricao;


    private LocalDateTime horario;

    private LocalDateTime data_criacao;

    private String email;

    private PacienteDTO paciente ;





}
