package com.br.joel.Agendamento.services;

import com.br.joel.Agendamento.domain.Agenda;
import com.br.joel.Agendamento.domain.Paciente;
import com.br.joel.Agendamento.repository.AgendaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AgendaService {
    @Autowired
    AgendaRepository agendaRepository;


    public List<Agenda> getAllPacientes() {
        return  agendaRepository.findAll();
    }

    public  List<Agenda> create(Agenda agenda) {
        agendaRepository.save(agenda);

        return getAllPacientes();
    }



}
