package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "Equipamento")
@Entity(name = "Equipamento")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EquipamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipamento")
    private Long idEquipamento;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "peso", nullable = false)
    private Double peso;

    @Column(name = "fabricante")
    private String fabricante;

    @Column(name = "data_aquisicao")
    private LocalDateTime dataAquisicao;

    @Column(name = "estado")
    private String estado;

    @Column(name = "descricao")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "tipo_fk", referencedColumnName = "id_tipo")
    private TipoEquipamentoEntity tipoEquipamento;

}
