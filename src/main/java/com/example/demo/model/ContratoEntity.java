package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
    @JoinColumn(name = "idpessoa")
    @JsonBackReference
    private AlunoEntity aluno;

    private String nome;

}
