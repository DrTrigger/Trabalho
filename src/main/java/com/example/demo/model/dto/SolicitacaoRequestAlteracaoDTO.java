package com.example.demo.model.dto;

import com.example.demo.model.ExercicioFichaEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SolicitacaoRequestAlteracaoDTO implements DTO{
    private Long idSolicitacao;
    private Long idFicha;
    private String tipoAlteracao;
    private String detalhes;
    private LocalDateTime dataSolicitacao;
    private String status;
    private Long idAprovador;
    private LocalDateTime dataResposta;
    private List<ExercicioFichaDTO> exercicios_da_ficha = new ArrayList<>();
}
