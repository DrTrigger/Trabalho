package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "ExercicioFicha")
@Table(name = "exercicioficha")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExercicioFichaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_exercicio_ficha")
    private Long id_exercicio_ficha;

    @ManyToOne
    @JoinColumn(name = "id_exercicio", nullable = false)
    private ExercicioEntity exercicio;

    @ManyToOne
    @JoinColumn(name = "id_ficha", nullable = false)
    private FichaEntity ficha;

    @ManyToOne
    @JoinColumn(name = "id_equipamento", nullable = false)
    private EquipamentoEntity equipamento;

    private Integer numero_repeticao;

    private Integer tempo_descanso;

    private Integer peso;

}
