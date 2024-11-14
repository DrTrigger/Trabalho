package com.example.demo.repository;

import com.example.demo.model.EquipamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipamentoRepository extends JpaRepository<EquipamentoEntity, Long> {
}
