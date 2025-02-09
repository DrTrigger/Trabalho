package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.model.dto.*;
import com.example.demo.repository.AlunoRepository;
import com.example.demo.repository.FichaRepository;
import com.example.demo.repository.ProfessorRepository;
import com.example.demo.utils.DtoConvesorToEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FichaService {

    @Autowired
    private FichaRepository fichaRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    public List<FichaResponseDTO> listarFichas() {
        List<FichaEntity> fichaEntityList = fichaRepository.findAll();
        List<FichaResponseDTO> fichaResponseDTOList = new ArrayList<>();
        for (FichaEntity fichaEntity : fichaEntityList){
            FichaResponseDTO fichaResponseDTO = new FichaResponseDTO();
            fichaResponseDTO.setId(fichaEntity.getId());
            fichaResponseDTO.setData_inicio(fichaEntity.getData_inicio());
            fichaResponseDTO.setData_fim(fichaEntity.getData_fim());
            for(ExercicioFichaEntity exercicioFicha: fichaEntity.getExercicioFichaList()){
                ExercicioFichaResponseDTO exercicioFichaResponseDTO = new ExercicioFichaResponseDTO();
                exercicioFichaResponseDTO.setId_exercicio_ficha(exercicioFicha.getId_exercicio_ficha());
                exercicioFichaResponseDTO.setExercicio(DtoConvesorToEntity.entityToDto(exercicioFicha.getExercicio(), new ExercicioDTO()));
                exercicioFichaResponseDTO.setEquipamento(DtoConvesorToEntity.entityToDto(exercicioFicha.getEquipamento(), new EquipamentoResponseDTO()));
                exercicioFichaResponseDTO.setId_ficha(exercicioFicha.getFicha().getId());
                exercicioFichaResponseDTO.setMatricula_aluno(exercicioFicha.getFicha().getAluno().getMatricula_aluno());
                exercicioFichaResponseDTO.setPeso(exercicioFicha.getPeso());
                exercicioFichaResponseDTO.setTempo_descanso(exercicioFicha.getTempo_descanso());
                exercicioFichaResponseDTO.setNumero_repeticao(exercicioFicha.getNumero_repeticao());
                fichaResponseDTO.getExercicioFichaList().add(exercicioFichaResponseDTO);
            }
            fichaResponseDTO.setProfessor(DtoConvesorToEntity.entityToDto(fichaEntity.getProfessor(), new ProfessorResponseDTO()));
            fichaResponseDTO.setAluno(DtoConvesorToEntity.entityToDto(fichaEntity.getAluno(), new AlunoDTO()));
            fichaResponseDTOList.add(fichaResponseDTO);
            //fichaResponseDTOList.add(DtoConvesorToEntity.entityToDto(fichaEntity, fichaResponseDTO, 0));
        }
        return fichaResponseDTOList;
    }

    public boolean cadastrarFicha(FichaDTO fichaDTO) {
        try{
             //um aluno pode ter varias fichas, no caso dele ser um atléta, pode ocorrer dele ter fichas periódicas... Entao, complica.
            FichaEntity ficha = new FichaEntity();
            Optional<AlunoEntity> aluno = alunoRepository.findById(fichaDTO.getIdAluno());
            Optional<ProfessorEntity> professor = professorRepository.findById(fichaDTO.getIdProfessor());

            ficha.setAluno(aluno.orElse(null));
            ficha.setProfessor(professor.orElse(null));
            ficha.setData_inicio(fichaDTO.getDataInicio());
            ficha.setData_fim(fichaDTO.getDataFim());
            fichaRepository.save(ficha);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean editarFicha(Long id, FichaDTO fichaDTO) {
        Optional<FichaEntity> ficha = fichaRepository.findById(id);
        if(ficha.isPresent()){
            FichaEntity auxFicha = ficha.get();

            Optional<AlunoEntity> aluno = alunoRepository.findById(fichaDTO.getIdAluno());
            aluno.ifPresent(auxFicha::setAluno);
            Optional<ProfessorEntity> professor = professorRepository.findById(fichaDTO.getIdProfessor());
            professor.ifPresent(auxFicha::setProfessor);

            auxFicha.setData_inicio(fichaDTO.getDataInicio());
            auxFicha.setData_fim(fichaDTO.getDataFim());
            fichaRepository.save(auxFicha);
        }
        return false;
    }

    public boolean deletarExercicio(Long id) {
        Optional<FichaEntity> ficha = fichaRepository.findById(id);
        if(ficha.isPresent()){fichaRepository.deleteById(id); return true;}
        return false;
    }

    public FichaResponseDTO getFicha(Long id) {
        try{
            Optional<FichaEntity> fichaEntityS = fichaRepository.findById(id);
            if(fichaEntityS.isPresent()){
                FichaEntity fichaEntity = fichaEntityS.get();
                FichaResponseDTO fichaResponseDTO = new FichaResponseDTO();
                fichaResponseDTO.setId(fichaEntity.getId());
                fichaResponseDTO.setData_inicio(fichaEntity.getData_inicio());
                fichaResponseDTO.setData_fim(fichaEntity.getData_fim());
                for(ExercicioFichaEntity exercicioFicha: fichaEntity.getExercicioFichaList()){
                    ExercicioFichaResponseDTO exercicioFichaResponseDTO = new ExercicioFichaResponseDTO();
                    exercicioFichaResponseDTO.setId_exercicio_ficha(exercicioFicha.getId_exercicio_ficha());
                    exercicioFichaResponseDTO.setExercicio(DtoConvesorToEntity.entityToDto(exercicioFicha.getExercicio(), new ExercicioDTO()));
                    exercicioFichaResponseDTO.setEquipamento(DtoConvesorToEntity.entityToDto(exercicioFicha.getEquipamento(), new EquipamentoResponseDTO()));
                    exercicioFichaResponseDTO.setId_ficha(exercicioFicha.getFicha().getId());
                    exercicioFichaResponseDTO.setMatricula_aluno(exercicioFicha.getFicha().getAluno().getMatricula_aluno());
                    exercicioFichaResponseDTO.setPeso(exercicioFicha.getPeso());
                    exercicioFichaResponseDTO.setTempo_descanso(exercicioFicha.getTempo_descanso());
                    exercicioFichaResponseDTO.setNumero_repeticao(exercicioFicha.getNumero_repeticao());
                    fichaResponseDTO.getExercicioFichaList().add(exercicioFichaResponseDTO);
                }
                fichaResponseDTO.setProfessor(DtoConvesorToEntity.entityToDto(fichaEntity.getProfessor(), new ProfessorResponseDTO()));
                fichaResponseDTO.setAluno(DtoConvesorToEntity.entityToDto(fichaEntity.getAluno(), new AlunoDTO()));
                return fichaResponseDTO;
            }

        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
