package com.example.demo.service;

import com.example.demo.model.PlanoEntity;
import com.example.demo.model.dto.PlanoDTO;
import com.example.demo.repository.PlanoRepository;
import com.example.demo.utils.DtoConvesorToEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlanoService {
    @Autowired
    private PlanoRepository planoRepository;

    public boolean cadastrarPlano(PlanoDTO dto) {
        PlanoEntity planoEntity = new PlanoEntity();
        try {
            DtoConvesorToEntity.DtoToEntity(dto, planoEntity);
            planoRepository.save(planoEntity);
            return true;
        } catch (Exception e) {
            e.printStackTrace(); // Log para diagnóstico de erro
            return false;
        }
    }


    public List<PlanoDTO> listarPlanos() {
        try {
            List<PlanoEntity> planoEntities = planoRepository.findAll();
            List<PlanoDTO> planoDTOList = new ArrayList<>();
            for (PlanoEntity planoEntity : planoEntities) {
                PlanoDTO planoDTO = DtoConvesorToEntity.entityToDto(planoEntity, new PlanoDTO());
                planoDTOList.add(planoDTO);
            }
            return planoDTOList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean deletarPlano(Long id) {
        Optional<PlanoEntity> planoEntity = planoRepository.findById(id);
        if(!planoEntity.isPresent()){
            return false;
        }
        try{
            if(planoEntity.isPresent()){
                planoRepository.delete(planoEntity.get());
            }
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean editarPlano(Long id, PlanoDTO planoDTO) {
        try{
            Optional<PlanoEntity> planoEntity = planoRepository.findById(id);
            if(planoEntity.isPresent()){
                PlanoEntity plano = planoEntity.get();
                DtoConvesorToEntity.DtoToEntity(planoDTO, plano);
                planoRepository.save(plano);
                return true;
            }
            return false;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public PlanoDTO getPlano(Long id) {
        try{
            Optional<PlanoEntity> planoEntity = planoRepository.findById(id);
            if(planoEntity.isPresent()){
                return DtoConvesorToEntity.entityToDto(planoEntity.get(), new PlanoDTO());
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
