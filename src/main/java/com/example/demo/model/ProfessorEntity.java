package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name = "Professor")
@Entity(name = "Professor")
@Setter
@Getter
public class ProfessorEntity extends PessoaEntity{

    private double salario;

    @Pattern(regexp = "^CREF\\s\\d{6}-[GP]/[A-Z]{2}$", message = "Número de registro do CREF inválido")
    private String cref;

    private int carga_horaria_semanal;

    /**
     * @param id
     * @param nome
     * @param data_nascimento
     * @param email
     * @param senha
     */
    public ProfessorEntity(Long id, String nome, LocalDateTime data_nascimento, String email, String senha, double salario, String cref, int carga_horaria_semanal) {
        super(id, nome, data_nascimento, email, senha);
        this.salario = salario;
        this.cref = cref;
        this.carga_horaria_semanal = carga_horaria_semanal;
    }
}
