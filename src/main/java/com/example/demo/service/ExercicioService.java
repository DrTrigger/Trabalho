package com.example.demo.service;

import com.example.demo.model.ExercicioEntity;
import com.example.demo.model.dto.ExercicioDTO;
import com.example.demo.repository.ExercicioRepository;
import com.example.demo.utils.DtoConvesorToEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExercicioService {
    @Autowired
    private ExercicioRepository exercicioRepository;

    public boolean cadastrarExercicio(ExercicioDTO exercicioDTO) {
        ExercicioEntity exercicio = new ExercicioEntity();
        exercicio.setGrupoMuscular(exercicioDTO.getGrupoMuscular());
        exercicio.setNome(exercicioDTO.getNome());
        exercicioRepository.save(exercicio);
        return true;
    }

    public List<ExercicioDTO> listarExercicios() {
        try{
            List<ExercicioEntity> exercicioEntities = exercicioRepository.findAll();
            List<ExercicioDTO> exercicioDTOS = new ArrayList<>();
            for (ExercicioEntity exercicio : exercicioEntities){
                exercicioDTOS.add(DtoConvesorToEntity.entityToDto(exercicio, new ExercicioDTO()));
            }
            return exercicioDTOS;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deletarExercicio(Long id) {
        Optional<ExercicioEntity> exercicio = exercicioRepository.findById(id);
        if (exercicio.isPresent()) {
            exercicioRepository.delete(exercicio.get());
            return true;
        }
        return false;
    }

    public boolean editarExercicio(Long id, ExercicioDTO exercicioDTO) {
        Optional<ExercicioEntity> optionalExercicio = exercicioRepository.findById(id);
        if (optionalExercicio.isPresent()) {
            ExercicioEntity exercicio = optionalExercicio.get();
            exercicio.setGrupoMuscular(exercicioDTO.getGrupoMuscular());
            exercicio.setNome(exercicioDTO.getNome());
            exercicioRepository.save(exercicio);
            return true;
        }
        return false;
    }
}
