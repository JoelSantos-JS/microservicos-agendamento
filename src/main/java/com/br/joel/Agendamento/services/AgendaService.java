package com.br.joel.Agendamento.services;

import com.br.joel.Agendamento.domain.Agenda;
import com.br.joel.Agendamento.domain.Paciente;
import com.br.joel.Agendamento.repository.AgendaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AgendaService {
    @Autowired
    AgendaRepository agendaRepository;


    public Page<Agenda> getAll(Pageable pageable) {
        return  agendaRepository.findAll(pageable);
    }

    public  Agenda getById(Long id) {
        return  agendaRepository.findById(id).get();
    }

    public  Agenda create(Agenda agenda) {
   

        return      agendaRepository.save(agenda);
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
