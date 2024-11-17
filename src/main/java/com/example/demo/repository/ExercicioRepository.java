package com.example.demo.repository;

import com.example.demo.model.EquipamentoEntity;
import com.example.demo.model.ExercicioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExercicioRepository extends JpaRepository<ExercicioEntity, Long> {
}
