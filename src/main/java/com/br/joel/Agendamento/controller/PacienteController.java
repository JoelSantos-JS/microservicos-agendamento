package com.br.joel.Agendamento.controller;

import com.br.joel.Agendamento.DTO.PacienteDTO;
import com.br.joel.Agendamento.domain.Paciente;
import com.br.joel.Agendamento.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/paciente")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;



    @GetMapping
    public ResponseEntity<Page<PacienteDTO>> getAll(Pageable pageable) {
        return  ResponseEntity.ok().body(pacienteService.getAllPacientes(pageable));
    }


    @GetMapping(value = "/{id}")
    public  ResponseEntity<PacienteDTO> getById(@PathVariable Long id) {
        return  ResponseEntity.ok().body(pacienteService.getById(id));
    }



    @PostMapping
    public  ResponseEntity<PacienteDTO> create(@RequestBody PacienteDTO paciente) throws Exception {
     return  ResponseEntity.ok().body(pacienteService.createPaciente(paciente));
    }



    @PutMapping(value = "/{id}")
    public  ResponseEntity<PacienteDTO> update(@PathVariable long
                                                   id , @RequestBody PacienteDTO paciente) {
    return  ResponseEntity.ok().body(pacienteService.updatePaciente(id,paciente));
    }


    @DeleteMapping(value = "/{id}")
    public  ResponseEntity<Void> delete(@PathVariable long id) {
        pacienteService.deleteById(id);

        return  ResponseEntity.noContent().build();
    }
}
