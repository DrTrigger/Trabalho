package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "Aluno")
@Entity(name = "Aluno")
@Setter
@Getter
public class AlunoEntity extends PessoaEntity{

    private String matricula_aluno;

    private LocalDateTime data_matricula;

    private String restricao_medica;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ContratoEntity> contratos;

    /**
     *
     * @param id
     * @param nome
     * @param data_nascimento
     * @param cpf
     * @param email
     * @param senha
     * @param matricula_aluno
     * @param data_matricula
     * @param restricao_medica
     * @param contratos
     */
    public AlunoEntity(Long id, String nome, LocalDateTime data_nascimento, String cpf, String email, String senha,
                       String matricula_aluno, LocalDateTime data_matricula, String restricao_medica, List<ContratoEntity> contratos) {
        super(id, nome, data_nascimento, cpf, email, senha);
        this.matricula_aluno = matricula_aluno;
        this.data_matricula = data_matricula;
        this.restricao_medica = restricao_medica;
        this.contratos = contratos;
    }

    public AlunoEntity(){
        super();
    }
}
