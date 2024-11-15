package com.example.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorResponseDTO implements DTO{
    private Long id;
    private String nome;
    private LocalDateTime data_nascimento;
    private String cpf;
    private String email;
    //private String senha;
    private Double salario;
    private String cref;
    private Integer carga_horaria_semanal;

}
