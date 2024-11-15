package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Exercicio")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExercicioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_exercicio")
    private Long id_exercicio;

    @Column(name = "grupo_muscular")
    private String grupoMuscular;

    @Column(name = "nome")
    private String nome;

}
