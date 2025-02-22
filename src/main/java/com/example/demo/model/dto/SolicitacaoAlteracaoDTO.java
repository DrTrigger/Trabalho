package com.example.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SolicitacaoAlteracaoDTO implements DTO{
    private Long idFicha;
    private String tipoAlteracao;
    private String detalhes;
    private LocalDateTime dataSolicitacao;
    private String status;
    private Long idAprovador;
    private LocalDateTime dataResposta;
}
