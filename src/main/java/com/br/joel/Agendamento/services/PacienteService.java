package com.br.joel.Agendamento.services;

import com.br.joel.Agendamento.DTO.PacienteDTO;
import com.br.joel.Agendamento.domain.Paciente;
import com.br.joel.Agendamento.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
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

    @Autowired
    ModelMapper modelMapper;



    public Page<PacienteDTO> getAllPacientes(Pageable pageable) {
        Page<Paciente > paciente = pacienteRepository.findAll(pageable);

         Page<PacienteDTO> pacienteDTO = paciente.map(e -> new PacienteDTO(e));paciente.stream().map(e -> new PacienteDTO(e)).toList();
            return  pacienteDTO;
    }

    public  PacienteDTO getById(Long id ) {
        PacienteDTO paciente = modelMapper.map(pacienteRepository.findById(id).get(), PacienteDTO.class);
        return  paciente;
    }

    public PacienteDTO createPaciente(PacienteDTO paciente) throws Exception {
        List<Paciente> pacientesExistentes = pacienteRepository.findAll();

        if (pacientesExistentes.stream().anyMatch(e -> e.getCpf().equals(paciente.getCpf()))) {
            throw new RuntimeException("CPF já existe na lista de pacientes!");
        }

        Paciente novoPaciente = modelMapper.map(paciente, Paciente.class);

        Paciente pacienteSalvo = pacienteRepository.save(novoPaciente);

        return modelMapper.map(pacienteSalvo, PacienteDTO.class);
    }


    public  PacienteDTO updatePaciente(Long id , PacienteDTO paciente) {
        Paciente paciente1 = pacienteRepository.findByid(id);

        if (paciente1 == null) {
            throw new RuntimeException("Paciente não encontrado");
        }

        modelMapper.map(paciente, paciente1);

        Paciente pacienteSalvo = pacienteRepository.save(paciente1);

        return  modelMapper.map(pacienteSalvo, PacienteDTO.class);


    }

    public  void  deleteById(long id ) {
        pacienteRepository.deleteById(id);
    }


    public  List<Paciente> findCpf(String cpf) {
        List<Paciente> paciente = pacienteRepository.findByCpf(cpf);

        return paciente;
    }
}
