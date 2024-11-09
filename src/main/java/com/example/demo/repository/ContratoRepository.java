package com.example.demo.repository;

import com.example.demo.model.ContratoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContratoRepository extends JpaRepository<ContratoEntity, Long> {
    @Query("SELECT c FROM Contrato c WHERE c.aluno.id = :idPessoa AND c.status = 'ATIVO'")
    Optional<ContratoEntity> findByContratoAtivo(@Param("idPessoa") Long idPessoa);
}
