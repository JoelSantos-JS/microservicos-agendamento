package com.br.joel.Agendamento.services;

import com.br.joel.Agendamento.domain.Paciente;
import com.br.joel.Agendamento.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {
    @Autowired
    PacienteRepository pacienteRepository;



    public List<Paciente> getAllPacientes() {
        return  pacienteRepository.findAll();
    }

    public  Paciente getById(Long id ) {
        return  pacienteRepository.findById(id).get();
    }

    public  List<Paciente> createPaciente(Paciente paciente) {
        pacienteRepository.save(paciente);

        return  getAllPacientes();
    }


    public  List<Paciente> updatePaciente(Long id , Paciente paciente) {
        Paciente paciente1 = pacienteRepository.getOne(id);
        paciente1.setNome(paciente.getNome());
        paciente1.setCpf(paciente.getCpf());
        paciente1.setSobrenome(paciente.getSobrenome());
        paciente1.setEmail(paciente.getEmail());

        pacienteRepository.save(paciente1);

        return  getAllPacientes();
    }


    public  void  deleteById(long id ) {
        pacienteRepository.deleteById(id);
    }
}
