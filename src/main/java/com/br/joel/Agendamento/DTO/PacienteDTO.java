package com.br.joel.Agendamento.DTO;

import com.br.joel.Agendamento.domain.Paciente;

public class PacienteDTO {

    private  Long id;
    private String nome;
    private String sobrenome;
    private String email;
    private String cpf;

    public PacienteDTO() {
        // Construtor vazio
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PacienteDTO(long id, String nome, String sobrenome, String email, String cpf) {
        this.id =  id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.cpf = cpf;
    }

    public PacienteDTO(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getSobrenome(), paciente.getEmail(), paciente.getCpf());
    }

    // Getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
