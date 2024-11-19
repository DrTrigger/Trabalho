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
import java.util.Optional;

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

    public boolean cadastrarExercicioFicha(ExercicioFichaDTO exercicioFichaDTO) {
        try{
            ExercicioFichaEntity exercicioFicha = new ExercicioFichaEntity();

            exercicioFicha.setExercicio(exercicioRepository.findById(exercicioFichaDTO.getId_exercicio()).isPresent() ? exercicioRepository.findById(exercicioFichaDTO.getId_exercicio()).get() : null);
            exercicioFicha.setFicha(fichaRepository.findById(exercicioFichaDTO.getId_ficha()).isPresent() ? fichaRepository.findById(exercicioFichaDTO.getId_ficha()).get() : null);
            exercicioFicha.setNumero_repeticao(exercicioFichaDTO.getNumero_repeticao());
            exercicioFicha.setTempo_descanso(exercicioFichaDTO.getTempo_descanso());
            exercicioFicha.setPeso(exercicioFichaDTO.getPeso());
            exercicioFicha.setEquipamento(equipamentoRepository.findById(exercicioFichaDTO.getId_equipamento()).isPresent() ? equipamentoRepository.findById(exercicioFichaDTO.getId_equipamento()).get() : null);
            exercicioFichaRepository.save(exercicioFicha);
            return true;
        }catch (Exception e){
            throw new RuntimeException();
        }
    }

    public boolean editarExercicioFicha(Long id, ExercicioFichaDTO exercicioFichaDTO) {
        try{
            Optional<ExercicioFichaEntity> exercicioFicha = exercicioFichaRepository.findById(id);
            if(exercicioFicha.isPresent()){
                //ExercicioFichaEntity exercicioFichaEntity =  new ExercicioFichaEntity();
                DtoConvesorToEntity.DtoToEntity(exercicioFichaDTO, exercicioFicha.get());
                exercicioFichaRepository.saveAndFlush(exercicioFicha.get());
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
