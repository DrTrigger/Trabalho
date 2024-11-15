package com.example.demo.model.dto;

import lombok.Setter;

import java.time.LocalDateTime;

public record FichaDTO (LocalDateTime data_inicio, LocalDateTime data_fim, Long id_aluno, Long id_professor ) implements DTO{

}
