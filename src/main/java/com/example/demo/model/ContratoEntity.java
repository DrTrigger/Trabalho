package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "Contrato")
@Table(name = "Contrato")
@Setter
@Getter
public class ContratoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcontrato")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idpessoa", nullable = false)
    @JsonBackReference("aluno-contrato")
    private AlunoEntity aluno;

    private LocalDateTime data_inicio;

    private LocalDateTime data_fim;

    private LocalDateTime data_vencimento;

    private String nome;

    private String status;

    private Double valor_pago;

    @ManyToOne
    @JoinColumn(name = "idplano")
    @JsonBackReference("plano-contrato")
    private PlanoEntity plano;

}
