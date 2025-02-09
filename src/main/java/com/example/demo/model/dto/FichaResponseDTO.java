package com.example.demo.model.dto;

import com.example.demo.model.AlunoEntity;
import com.example.demo.model.ProfessorEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class FichaResponseDTO implements DTO {
    private Long id;
    private LocalDateTime data_inicio;
    private LocalDateTime data_fim;
    private AlunoDTO aluno;
    private ProfessorResponseDTO professor;
    private List<ExercicioFichaResponseDTO> exercicioFichaList = new ArrayList<>();
}
