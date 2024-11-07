package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Table(name = "Pessoa")
@Entity(name = "Pessoa")
@Setter
@Getter
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PessoaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpessoa")
    private Long id;

    private String nome;

    private LocalDateTime data_nascimento;

    @Email
    private String email;

    private String senha;

    /**
     *
     * @param id
     * @param nome
     * @param data_nascimento
     * @param email
     * @param senha
     */
    public PessoaEntity(Long id, String nome, LocalDateTime data_nascimento, String email, String senha){
        this.id = id;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.email = email;
        this.senha = senha;
    }


}
