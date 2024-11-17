package com.example.demo.repository;

import com.example.demo.model.ExercicioFichaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExercicioFichaRepository extends JpaRepository<ExercicioFichaEntity, Long> {
}
