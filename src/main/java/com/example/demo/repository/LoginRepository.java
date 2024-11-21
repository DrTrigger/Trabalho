package com.example.demo.repository;

import com.example.demo.model.AlunoEntity;
import com.example.demo.model.ContratoEntity;
import com.example.demo.model.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<PessoaEntity, Long> {
    @Query("SELECT p FROM Pessoa p WHERE p.email = :emailPessoa AND p.senha = :senhaPessoa")
    Optional<? extends PessoaEntity> fazerLogin(@Param("emailPessoa") String emailPessoa, @Param("senhaPessoa") String senhaPessoa);

}
