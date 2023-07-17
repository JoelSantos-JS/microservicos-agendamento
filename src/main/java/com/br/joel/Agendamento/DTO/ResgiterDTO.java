package com.br.joel.Agendamento.DTO;

import com.br.joel.Agendamento.domain.Roles;

public record ResgiterDTO (String login, String password, Roles role){
}
