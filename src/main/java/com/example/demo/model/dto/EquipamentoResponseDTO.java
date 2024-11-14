package com.example.demo.model.dto;

import com.example.demo.model.TipoEquipamentoEntity;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EquipamentoResponseDTO implements DTO{
    private Long idEquipamento;
    private String nome;
    private Double peso;
    private String fabricante;
    private LocalDateTime dataAquisicao;
    private String estado;
    private String descricao;
    private TipoEquipamentoDTO tipoEquipamento;
}
