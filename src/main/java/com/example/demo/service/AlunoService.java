package com.example.demo.service;

import com.example.demo.model.AlunoEntity;
import com.example.demo.repository.AlunoRepository;
import com.example.demo.repository.ProfessorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public boolean cadastrarAluno(AlunoEntity alunoEntity) {
        try{
            alunoRepository.save(alunoEntity);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
