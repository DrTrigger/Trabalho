package com.example.demo.repository;

import com.example.demo.model.EquipamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipamentoRepository extends JpaRepository<EquipamentoEntity, Long> {
}
