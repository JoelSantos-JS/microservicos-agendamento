package com.br.joel.Agendamento.controller;

import com.br.joel.Agendamento.DTO.AgendaDTO;
import com.br.joel.Agendamento.domain.Agenda;
import com.br.joel.Agendamento.services.AgendaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/agenda")
public class AgendaController {

    @Autowired
    AgendaService agendaService;


    @GetMapping
    public ResponseEntity<Page<Agenda>> getALl(Pageable pageable) {

        return ResponseEntity.ok().body(agendaService.getAll(pageable));
    }


    @PostMapping
    public ResponseEntity<Agenda> save(@RequestBody AgendaDTO agenda) throws Exception {
        return ResponseEntity.ok().body(agendaService.create(agenda));
    }

    @PutMapping(value = "/{id}")

    public ResponseEntity<Agenda> update(@PathVariable long id, @RequestBody Agenda agenda) {
        return ResponseEntity.ok().body(agendaService.update(id, agenda));
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        agendaService.delete(id);
    return  ResponseEntity.noContent().build();
    }

}