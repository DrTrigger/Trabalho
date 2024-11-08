package com.example.demo.service;

import com.example.demo.model.PlanoEntity;
import com.example.demo.repository.PlanoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanoService {
    @Autowired
    private PlanoRepository planoRepository;


    public void cadastrarPlano(@Valid PlanoEntity planoEntity) {
        planoRepository.save(planoEntity);
    }

    public List<PlanoEntity> listarPlanos() {
        return planoRepository.findAll();
    }

    public void deletarPlano(Long id) {
        Optional<PlanoEntity> planoEntity = planoRepository.findById(id);
        if(planoEntity.isPresent()){
            planoRepository.delete(planoEntity.get());
        }

    }
}
