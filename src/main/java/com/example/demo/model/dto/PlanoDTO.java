package com.example.demo.model.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PlanoDTO {
    private Long id;
    private String nome;
    private String descricao;
    private Double valor;
    private int duracao_meses;
}
