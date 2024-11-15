package com.example.demo.controller;

import com.example.demo.model.ExercicioEntity;
import com.example.demo.model.dto.ExercicioDTO;
import com.example.demo.service.ExercicioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercicio")
public class ExercicioController {

    @Autowired
    private ExercicioService exercicioService;

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarExercicio(@Valid @RequestBody ExercicioDTO exercicioDTO) {
        if (exercicioService.cadastrarExercicio(exercicioDTO)) {
            return ResponseEntity.ok("Exercicio criado com sucesso");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar Exercicio");
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ExercicioDTO>> listarExercicios() {
        List<ExercicioDTO> exercicioList = exercicioService.listarExercicios();
        if (!exercicioList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(exercicioList);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarExercicio(@PathVariable Long id) {
        if (exercicioService.deletarExercicio(id)) {
            return ResponseEntity.status(HttpStatus.OK).body("Exercicio deletado com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao deletar Exercicio");
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editarExercicio(@PathVariable Long id, @Valid @RequestBody ExercicioDTO exercicioDTO) {
        if (exercicioService.editarExercicio(id, exercicioDTO)) {
            return ResponseEntity.status(HttpStatus.OK).body("Exercicio atualizado com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao editar Exercicio");
    }
}
