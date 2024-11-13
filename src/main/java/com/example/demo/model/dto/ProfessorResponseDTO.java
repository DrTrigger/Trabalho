package com.example.demo.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
public class ProfessorResponseDTO {
    private Long id;
    private String nome;
    private LocalDateTime data_nascimento;
    private String cpf;
    private String email;
    private String senha;
    private double salario;
    private String cref;
    private Integer carga_horaria_semanal;

    public ProfessorResponseDTO(Long id, String nome, LocalDateTime data_nascimento, String cpf,
                                String email, String senha, double salario, String cref,
                                Integer carga_horaria_semanal) {
        this.id = id;
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
