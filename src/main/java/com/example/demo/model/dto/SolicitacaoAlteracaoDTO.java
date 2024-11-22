package com.example.demo.model.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class SolicitacaoAlteracaoDTO implements DTO{
        private Long idSolicitacao;
        private Long idFicha;
        private String tipoAlteracao;
        private String detalhes;
        private LocalDateTime dataSolicitacao;
        private String status;
        private Long idAprovador;
        private LocalDateTime dataResposta;

        public SolicitacaoAlteracaoDTO get() {
                return this;
        }
}
