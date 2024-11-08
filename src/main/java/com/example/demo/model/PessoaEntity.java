package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

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

    private String cpf;

    @Email
    private String email;

    private String senha;


    /**
     *
     * @param id
     * @param nome
     * @param data_nascimento
     * @param cpf
     * @param email
     * @param senha
     */
    public PessoaEntity(Long id, String nome, LocalDateTime data_nascimento, String cpf, String email, String senha){
        this.id = id;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
    }

    public PessoaEntity(){
    }


}
