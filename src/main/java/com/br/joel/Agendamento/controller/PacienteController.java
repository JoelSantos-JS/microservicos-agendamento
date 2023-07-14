package com.br.joel.Agendamento.controller;

import com.br.joel.Agendamento.domain.Paciente;
import com.br.joel.Agendamento.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/paciente")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;



    @GetMapping
    public ResponseEntity<List<Paciente>> getAll() {
        return  ResponseEntity.ok().body(pacienteService.getAllPacientes());
    }



    @PostMapping
    public  ResponseEntity<List<Paciente>> create(@RequestBody Paciente paciente) throws Exception {
     return  ResponseEntity.ok().body(pacienteService.createPaciente(paciente));
    }



    @PutMapping(value = "/{id}")
    public  ResponseEntity<List<Paciente>> update(@PathVariable long
                                                   id , @RequestBody Paciente paciente) {
    return  ResponseEntity.ok().body(pacienteService.updatePaciente(id,paciente));
    }


    @DeleteMapping(value = "/{id}")
    public  ResponseEntity<Void> delete(@PathVariable long id) {
        pacienteService.deleteById(id);

        return  ResponseEntity.noContent().build();
    }
}
