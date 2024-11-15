package com.example.demo.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ExercicioDTO implements DTO{
    private Long id_exercicio;
    private String grupoMuscular;
    private String nome;
}
