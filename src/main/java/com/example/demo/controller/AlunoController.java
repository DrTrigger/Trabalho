package com.example.demo.controller;

import com.example.demo.model.AlunoEntity;
import com.example.demo.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarAluno(@Valid @RequestBody AlunoEntity alunoEntity){
        if(alunoService.cadastrarAluno(alunoEntity)){
            return ResponseEntity.ok("Criado");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar aluno");
    }
}
