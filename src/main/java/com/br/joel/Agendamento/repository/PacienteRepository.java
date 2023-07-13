package com.br.joel.Agendamento.repository;

import com.br.joel.Agendamento.domain.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente , Long> {
    List<Paciente> findByName(String nome);
}
