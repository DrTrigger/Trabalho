package com.example.demo.service;

import com.example.demo.model.AlunoEntity;
import com.example.demo.model.ContratoEntity;
import com.example.demo.model.FichaEntity;
import com.example.demo.model.ProfessorEntity;
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
            Optional<AlunoEntity> aluno = alunoRepository.findById(fichaDTO.id_aluno());
            Optional<ProfessorEntity> professor = professorRepository.findById(fichaDTO.id_professor());

            ficha.setAluno(aluno.orElse(null));
            ficha.setProfessor(professor.orElse(null));
            ficha.setData_inicio(fichaDTO.data_inicio());
            ficha.setData_fim(fichaDTO.data_fim());
            fichaRepository.save(ficha);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
