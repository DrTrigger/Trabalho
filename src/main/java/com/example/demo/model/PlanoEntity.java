package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "Plano")
@Entity(name = "Plano")
@Setter
@Getter
public class PlanoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idplano")
    private Long id;

    private String nome;

    private String descricao;

    private int duracao_meses;


}
