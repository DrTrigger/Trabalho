package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "Plano")
@Entity(name = "Plano")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PlanoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idplano")
    private Long id;

    private String nome;

    private String descricao;

    public Double valor;

    private int duracao_meses;

    //OBS!
    //A anotação cascade = CascadeType.ALL
    // no JPA define que todas as operações de persistência realizadas na entidade "mestre" também serão aplicadas automaticamente nas entidades associadas.
//    @OneToMany(mappedBy = "plano", cascade = CascadeType.ALL)
//    @JsonManagedReference("plano-contrato")
//    private List<ContratoEntity> contratos;

}
