package com.example.demo.controller;

import com.example.demo.model.AlunoEntity;
import com.example.demo.model.dto.AlunoDTO;
import com.example.demo.repository.AlunoRepository;
import com.example.demo.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    //@Autowired
    //private AlunoRepository alunoRepository;

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarAluno(@Valid @RequestBody AlunoDTO alunoDTO){
        if(alunoService.cadastrarAluno(alunoDTO)){
            return ResponseEntity.ok("Criado");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar aluno");
    }

    @GetMapping("/listar")
    public ResponseEntity<List<AlunoDTO>> listAlunos(){
        return ResponseEntity.ok(alunoService.listAlunos());
        //return ResponseEntity.ok(alunoRepository.findAll());
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deleteAluno(@PathVariable Long id){
        if(alunoService.deleteAluno(id)){
            return ResponseEntity.status(HttpStatus.OK).body("Aluno deletado com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao deletar");
    }
}
