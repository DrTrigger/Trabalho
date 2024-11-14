package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "SolicitacaoAlteracao")
@Table(name = "solicitacaoalteracao")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SolicitacaoAlteracaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solicitacao")
    private Long idSolicitacao;

    @Column(name = "id_ficha", nullable = false)
    private Long idFicha;

    @Column(name = "tipo_alteracao", nullable = false)
    private String tipoAlteracao;

    @Column(name = "detalhes")
    private String detalhes;

    @Column(name = "data_solicitacao", nullable = false)
    private LocalDateTime dataSolicitacao;

    @Column(name = "status")
    private String status;

    @Column(name = "id_aprovador")
    private Long idAprovador;

    @Column(name = "data_resposta")
    private LocalDateTime dataResposta;
}
