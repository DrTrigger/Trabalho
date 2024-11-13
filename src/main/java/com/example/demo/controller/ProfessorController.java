package com.example.demo.controller;

import com.example.demo.model.dto.AlunoDTO;
import com.example.demo.model.dto.ProfessorDTO;
import com.example.demo.model.dto.ProfessorResponseDTO;
import com.example.demo.service.AlunoService;
import com.example.demo.service.ProfessorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarProfessor(@Valid @RequestBody ProfessorDTO professorDTO){
        if(professorService.cadastrarProfessor(professorDTO)){
            return ResponseEntity.ok("Criado");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar aluno");
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ProfessorResponseDTO>> listProfessor(){
        List<ProfessorResponseDTO> professorResponseDTOList = professorService.listProfessor();
        if(!professorResponseDTOList.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(professorResponseDTOList);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deleteProfessor(@PathVariable Long id){
        if(professorService.deleteProfessor(id)){
            return ResponseEntity.status(HttpStatus.OK).body("Aluno deletado com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao deletar");
    }


    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editarProfessor(@PathVariable Long id, @Valid @RequestBody AlunoDTO alunoDTO){
        if(professorService.editarProfessor(id, alunoDTO)){
            return ResponseEntity.status(HttpStatus.OK).body("Aluno atualizado com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao editar.");
    }
}
