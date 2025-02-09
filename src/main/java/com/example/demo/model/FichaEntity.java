package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "Ficha")
@Table(name = "ficha")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FichaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ficha")
    private Long id;
    private LocalDateTime data_inicio;
    private LocalDateTime data_fim;

    @ManyToOne
    @JoinColumn(name = "id_aluno")
    //@JsonBackReference("aluno-ficha")
    private AlunoEntity aluno;

    @ManyToOne
    @JoinColumn(name = "id_professor")
    //@JsonBackReference("professor-ficha")
    private ProfessorEntity professor;

    @OneToMany(mappedBy = "ficha") // Changed from "exercicioficha" to "ficha"
    @JsonManagedReference
    private List<ExercicioFichaEntity> exercicioFichaList;


}
