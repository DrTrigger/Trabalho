package com.example.demo.model.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Setter
@Getter
public class ContratoResponseDTO {
    private Long id;
    private AlunoDTO aluno;
    private PlanoDTO plano;
    private String nome;
    private LocalDateTime data_inicio;
    private LocalDateTime data_fim;
    private LocalDateTime data_vencimento;
    private String status;
    private Double valor_pago;

}
