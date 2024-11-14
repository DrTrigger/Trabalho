package com.example.demo.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class ContratoDTO implements DTO {
    private Long idPessoa;
    private Long idPlano;
    private String nome;
    private LocalDateTime data_inicio;
    private LocalDateTime data_fim;
    private LocalDateTime data_vencimento;
    private String status;
    private Double valor_pago;
}
