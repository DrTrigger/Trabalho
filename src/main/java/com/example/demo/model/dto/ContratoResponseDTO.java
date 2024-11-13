package com.example.demo.model.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
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

    public ContratoResponseDTO(Long id, AlunoDTO aluno,
                               PlanoDTO plano, String nome, LocalDateTime data_inicio,
                               LocalDateTime data_fim, LocalDateTime data_vencimento, String status,
                               Double valor_pago) {
        this.id = id;
        this.aluno = aluno;
        this.plano = plano;
        this.nome = nome;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.data_vencimento = data_vencimento;
        this.status = status;
        this.valor_pago = valor_pago;
    }
}
