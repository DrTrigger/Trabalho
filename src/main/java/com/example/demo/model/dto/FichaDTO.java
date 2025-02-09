package com.example.demo.model.dto;

import com.example.demo.model.ContratoEntity;
import com.example.demo.model.ExercicioEntity;
import com.example.demo.model.ExercicioFichaEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FichaDTO implements DTO {
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private Long idAluno;
    private Long idProfessor;
}