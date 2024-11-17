package com.example.demo.service;

import com.example.demo.model.ExercicioEntity;
import com.example.demo.model.ExercicioFichaEntity;
import com.example.demo.model.dto.*;
import com.example.demo.repository.EquipamentoRepository;
import com.example.demo.repository.ExercicioFichaRepository;
import com.example.demo.repository.ExercicioRepository;
import com.example.demo.repository.FichaRepository;
import com.example.demo.utils.DtoConvesorToEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExercicioFichaService {

    @Autowired
    private ExercicioFichaRepository exercicioFichaRepository;

    @Autowired
    private ExercicioRepository exercicioRepository;

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    @Autowired
    private FichaRepository fichaRepository;


    public List<ExercicioFichaResponseDTO> listarExercicioFicha() {
        try{
            List<ExercicioFichaEntity> fichaEntityList =  exercicioFichaRepository.findAll();
            List<ExercicioFichaResponseDTO> fichaResponseDTOList =  new ArrayList<>();
            if(!fichaEntityList.isEmpty()){
                for(ExercicioFichaEntity exercicioFicha : fichaEntityList){
                    ExercicioFichaResponseDTO exercicioFichaResponseDTO = new ExercicioFichaResponseDTO();
                    exercicioFichaResponseDTO.setId_exercicio_ficha(exercicioFicha.getId_exercicio_ficha());
                    exercicioFichaResponseDTO.setExercicio(DtoConvesorToEntity.entityToDto(exercicioFicha.getExercicio(), new ExercicioDTO()));
                    exercicioFichaResponseDTO.setEquipamento(DtoConvesorToEntity.entityToDto(exercicioFicha.getEquipamento(), new EquipamentoResponseDTO()));
                    exercicioFichaResponseDTO.setId_ficha(exercicioFicha.getFicha().getId());
                    exercicioFichaResponseDTO.setMatricula_aluno(exercicioFicha.getFicha().getAluno().getMatricula_aluno());
                    exercicioFichaResponseDTO.setPeso(exercicioFicha.getPeso());
                    exercicioFichaResponseDTO.setTempo_descanso(exercicioFicha.getTempo_descanso());
                    exercicioFichaResponseDTO.setNumero_repeticao(exercicioFicha.getNumero_repeticao());
                    fichaResponseDTOList.add(exercicioFichaResponseDTO);
                }
            }
            return fichaResponseDTOList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
