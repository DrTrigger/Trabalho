package com.example.demo.model.dto;

import com.example.demo.model.ContratoEntity;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
public class AlunoDTO {
    private Long id;
    private String nome;
    private LocalDateTime data_nascimento;
    private String cpf;
    private String email;
    private String senha;
    private LocalDateTime data_matricula;
    private String matricula_aluno;
    private String restricao_medica;
    private List<ContratoDTO> contratos;

    public AlunoDTO(Long id, String nome, String restricao_medica, String matricula_aluno,
                    LocalDateTime data_matricula, String senha, String email, LocalDateTime data_nascimento,
                    String cpf, List<ContratoDTO> contratos) {
        this.id = id;
        this.nome = nome;
        this.restricao_medica = restricao_medica;
        this.matricula_aluno = matricula_aluno;
        this.data_matricula = data_matricula;
        this.senha = senha;
        this.email = email;
        this.data_nascimento = data_nascimento;
        this.cpf = cpf;
        this.contratos = contratos;
    }

    public AlunoDTO() {
    }
}
