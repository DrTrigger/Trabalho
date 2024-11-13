package com.example.demo.service;

import com.example.demo.model.AlunoEntity;
import com.example.demo.model.ProfessorEntity;
import com.example.demo.model.dto.AlunoDTO;
import com.example.demo.model.dto.ProfessorDTO;
import com.example.demo.model.dto.ProfessorResponseDTO;
import com.example.demo.repository.ProfessorRepository;
import com.example.demo.utils.DtoConvesorToEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public boolean cadastrarProfessor(ProfessorDTO professorDTO) {
        try{
            ProfessorEntity professorEntity = new ProfessorEntity();
            DtoConvesorToEntity.DtoToEntity(professorDTO, professorEntity);
            professorRepository.save(professorEntity);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public List<ProfessorResponseDTO> listProfessor() {
        try{
            List<ProfessorEntity> professorEntityList = professorRepository.findAll();
            if(professorEntityList.isEmpty()){
                return null;
            }
            List<ProfessorResponseDTO> professorResponseDTOList = new ArrayList<>();
            for(ProfessorEntity professorEntity: professorEntityList){
                try{
                    professorResponseDTOList.add(DtoConvesorToEntity.entityToDto(professorEntity,
                            new ProfessorResponseDTO(), 0));
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                return professorResponseDTOList;
            }
        }
        catch (Exception e){

        }
        return null;
    }

    public boolean deleteProfessor(Long id) {
        try {
            Optional<ProfessorEntity> professorEntity = professorRepository.findById(id);
            if (professorEntity.isPresent()) {
                professorRepository.delete(professorEntity.get());
                return true;
            }
            return false;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean editarProfessor(Long id, ProfessorDTO ProfessorDTO) {
        try{
            Optional<ProfessorEntity> professorEntity = professorRepository.findById(id);
            if(professorEntity.isPresent()){
                DtoConvesorToEntity.DtoToEntity(ProfessorDTO, professorEntity.get());
                professorRepository.save(professorEntity.get());
            }
            return true;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
