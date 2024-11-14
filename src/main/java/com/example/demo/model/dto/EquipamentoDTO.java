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
public class EquipamentoDTO implements DTO {
    private String nome;
    private Long id_tipo_equipamento;
    private Double peso;
    private String fabricante;
    private LocalDateTime dataAquisicao;
    private String estado;
    private String descricao;
}
