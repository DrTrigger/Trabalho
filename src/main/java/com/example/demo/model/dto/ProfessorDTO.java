package com.example.demo.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
public class ProfessorDTO {
    private String nome;
    private LocalDateTime data_nascimento;
    private String cpf;
    private String email;
    private String senha;
    private Double salario;
    private String cref;
    private Integer carga_horaria_semanal;

    public ProfessorDTO(String nome, LocalDateTime data_nascimento, String cpf,
                        String email, String senha, Double salario, String cref,
                        Integer carga_horaria_semanal) {
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.salario = salario;
        this.cref = cref;
        this.carga_horaria_semanal = carga_horaria_semanal;
    }
}
