package com.example.demo.service;

import com.example.demo.model.AlunoEntity;
import com.example.demo.model.dto.AlunoDTO;
import com.example.demo.repository.AlunoRepository;
import com.example.demo.repository.ProfessorRepository;
import com.example.demo.utils.DtoConvesorToEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public boolean cadastrarAluno(AlunoDTO alunoDTO) {
        try{
            AlunoEntity alunoEntity = new AlunoEntity();
            DtoConvesorToEntity.DtoToEntity(alunoDTO, alunoEntity);
            alunoRepository.save(alunoEntity);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public List<AlunoDTO> listAlunos() {
        List<AlunoEntity> alunoEntities = alunoRepository.findAll();
        List<AlunoDTO> alunoDTOS = new ArrayList<>();
        for(AlunoEntity alunoEntity : alunoEntities){
            AlunoDTO alunoDTO = DtoConvesorToEntity.entityToDto(alunoEntity, new AlunoDTO());
            alunoDTOS.add(alunoDTO);
        }
        return alunoDTOS;
    }

    public boolean deleteAluno(Long id) {
        try {
            Optional<AlunoEntity> alunoEntity = alunoRepository.findById(id);
            if (alunoEntity.isPresent()) {
                alunoRepository.delete(alunoEntity.get());
                return true;
            }
            return false;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
