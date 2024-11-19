package com.example.demo.model.dto;

import com.example.demo.model.EquipamentoEntity;
import com.example.demo.model.ExercicioEntity;
import com.example.demo.model.FichaEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExercicioFichaResponseDTO implements DTO{
    private Long id_exercicio_ficha;
    private ExercicioDTO exercicio;
    private Long id_ficha;
    @JsonIgnore
    private String matricula_aluno;
    private EquipamentoResponseDTO equipamento;
    private Integer numero_repeticao;
    private Integer tempo_descanso;
    private Integer peso;
}
