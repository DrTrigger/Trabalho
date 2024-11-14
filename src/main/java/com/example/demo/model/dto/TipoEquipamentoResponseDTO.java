package com.example.demo.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TipoEquipamentoResponseDTO implements DTO{
    private Long idTipo;
    private String nomeTipo;
    private String descricao;
}
