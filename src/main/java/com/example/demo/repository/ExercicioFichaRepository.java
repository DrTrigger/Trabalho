package com.example.demo.repository;

import com.example.demo.model.ContratoEntity;
import com.example.demo.model.ExercicioFichaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExercicioFichaRepository extends JpaRepository<ExercicioFichaEntity, Long> {

    @Query("SELECT ef FROM ExercicioFicha ef WHERE ef.ficha.id = :idFicha")
    List<ExercicioFichaEntity> findAllByFichaId(@Param("idFicha") Long idFicha);

}
