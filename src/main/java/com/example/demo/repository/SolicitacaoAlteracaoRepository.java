package com.example.demo.repository;

import com.example.demo.model.SolicitacaoAlteracaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitacaoAlteracaoRepository extends JpaRepository<SolicitacaoAlteracaoEntity, Long> {
}
