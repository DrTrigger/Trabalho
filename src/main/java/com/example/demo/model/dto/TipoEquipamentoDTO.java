package com.example.demo.model.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TipoEquipamentoDTO implements DTO{
    private String nomeTipo;
    private String descricao;
}
