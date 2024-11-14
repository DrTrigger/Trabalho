package com.example.demo.model.dto;

import com.example.demo.model.ContratoEntity;
import com.example.demo.model.PlanoEntity;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class PlanoDTO implements DTO{
    private Long id;
    private String nome;
    private String descricao;
    private Double valor;
    private Integer duracao_meses;
    //private List<ContratoEntity> contratos;
}
