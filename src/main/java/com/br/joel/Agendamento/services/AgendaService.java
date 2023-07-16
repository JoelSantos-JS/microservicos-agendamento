package com.br.joel.Agendamento.services;

import com.br.joel.Agendamento.DTO.AgendaDTO;
import com.br.joel.Agendamento.DTO.PacienteDTO;
import com.br.joel.Agendamento.domain.Agenda;
import com.br.joel.Agendamento.domain.Paciente;
import com.br.joel.Agendamento.repository.AgendaRepository;
import com.br.joel.Agendamento.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AgendaService {
    @Autowired
    AgendaRepository agendaRepository;


    @Autowired
    ModelMapper modelMapper;
    @Autowired
    PacienteRepository pacienteRepository;

    @Autowired
    PacienteService pacienteService;

    public Page<Agenda> getAll(Pageable pageable) {
        return  agendaRepository.findAll(pageable);
    }

    public  Agenda getById(Long id) {
        return  agendaRepository.findById(id).get();
    }

    public Agenda create(AgendaDTO agendaDTO) throws Exception {
        Optional<Paciente> optPaciente = pacienteService.getByIdPaciente(agendaDTO.getPaciente().getId());

        if (optPaciente.isEmpty()) {
            throw new Exception("Paciente não encontrado");
        }

        Optional<Agenda> agenda = agendaRepository.findByHorario(agendaDTO.getHorario());
        if (agenda.isPresent()) {
            throw new Exception("Horário já cadastrado");
        }

        Agenda newAgenda = Agenda.builder()
                .descricao(agendaDTO.getDescricao())
                .horario(agendaDTO.getHorario())
                .email(agendaDTO.getEmail())
                .data_criacao(LocalDateTime.now())
                .paciente(optPaciente.get())
                .build();

        return agendaRepository.save(newAgenda);
    }




    public Agenda update(long id , Agenda agenda) {
        Agenda agenda1 = getById(id);
        agenda1.setDescricao(agenda.getDescricao());
        agenda1.setHorario(agenda.getHorario());
        agenda1.setEmail(agenda.getEmail());
        return  agendaRepository.save(agenda1);
    }



    public void delete(Long id) {
        agendaRepository.deleteById(id);
    }


}
