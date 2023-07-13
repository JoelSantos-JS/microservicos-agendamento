package com.br.joel.Agendamento.repository;

import com.br.joel.Agendamento.domain.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AgendaRepository extends JpaRepository<Agenda,Long> {
}
