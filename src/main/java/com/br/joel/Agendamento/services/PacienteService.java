package com.br.joel.Agendamento.services;

import com.br.joel.Agendamento.DTO.PacienteDTO;
import com.br.joel.Agendamento.domain.Paciente;
import com.br.joel.Agendamento.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
@Transactional
public class PacienteService {
    @Autowired
    PacienteRepository pacienteRepository;



    public Page<PacienteDTO> getAllPacientes(Pageable pageable) {
        Page<Paciente > paciente = pacienteRepository.findAll(pageable);

         Page<PacienteDTO> pacienteDTO = paciente.map(e -> new PacienteDTO(e));paciente.stream().map(e -> new PacienteDTO(e)).toList();
            return  pacienteDTO;
    }

    public  Paciente getById(Long id ) {
        return  pacienteRepository.findById(id).get();
    }

    public PacienteDTO createPaciente(PacienteDTO paciente) throws Exception {
        List<Paciente> pacientesExistentes = pacienteRepository.findAll();

        if (pacientesExistentes.stream().anyMatch(e -> e.getCpf().equals(paciente.cpf()))) {
            throw new RuntimeException("CPF já existe na lista de pacientes!");
        }

        Paciente novoPaciente = new Paciente();
        novoPaciente.setNome(paciente.nome());
        novoPaciente.setCpf(paciente.cpf());
        novoPaciente.setSobrenome(paciente.sobrenome());
        novoPaciente.setEmail(paciente.email());

        Paciente pacienteSalvo = pacienteRepository.save(novoPaciente);

        return new PacienteDTO(pacienteSalvo);
    }


    public  PacienteDTO updatePaciente(Long id , PacienteDTO paciente) {
        Paciente paciente1 = getById(id);
        paciente1.setNome(paciente.nome());
        paciente1.setCpf(paciente.cpf());
        paciente1.setSobrenome(paciente.sobrenome());
        paciente1.setEmail(paciente.email());

        pacienteRepository.save(paciente1);

        return  new PacienteDTO(paciente1);
    }


    public  void  deleteById(long id ) {
        pacienteRepository.deleteById(id);
    }


    public  List<Paciente> findCpf(String cpf) {
        List<Paciente> paciente = pacienteRepository.findByCpf(cpf);

        return paciente;
    }
}
