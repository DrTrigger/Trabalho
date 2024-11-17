package com.example.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FichaDTO implements DTO {
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private Long idAluno;
    private Long idProfessor;
}