package com.example.demo.repository;

import com.example.demo.model.TipoEquipamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoEquipamentoRepository extends JpaRepository<TipoEquipamentoEntity, Long> {
}
