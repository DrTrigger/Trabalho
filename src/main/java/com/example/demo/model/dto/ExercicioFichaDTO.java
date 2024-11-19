package com.example.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ExercicioFichaDTO implements DTO{
    private Long id_exercicio;
    private Long id_ficha;
    private Long id_equipamento;
    private Integer numero_repeticao;
    private Integer tempo_descanso;
    private Integer peso;
}
