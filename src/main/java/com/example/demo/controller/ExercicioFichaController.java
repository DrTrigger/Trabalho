package com.example.demo.controller;

import com.example.demo.model.ExercicioEntity;
import com.example.demo.model.ExercicioFichaEntity;
import com.example.demo.model.dto.ExercicioDTO;
import com.example.demo.model.dto.ExercicioFichaDTO;
import com.example.demo.model.dto.ExercicioFichaResponseDTO;
import com.example.demo.repository.ExercicioFichaRepository;
import com.example.demo.service.ExercicioFichaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercicio-ficha")
public class ExercicioFichaController {

    @Autowired
    private ExercicioFichaService exercicioFichaService;

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarExercicioFicha(@Valid @RequestBody ExercicioFichaDTO exercicioFichaDTO) {
        if (exercicioFichaService.cadastrarExercicioFicha(exercicioFichaDTO)) {
            return ResponseEntity.ok("Exercicio da ficha criado com sucesso");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar Exercicio");
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ExercicioFichaResponseDTO>> listarExercicioFicha(){
        List<ExercicioFichaResponseDTO> fichaResponseDTOList = exercicioFichaService.listarExercicioFicha();
        if(fichaResponseDTOList != null || fichaResponseDTOList.isEmpty()){
            return ResponseEntity.ok(fichaResponseDTOList);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}
