package com.example.demo.controller;

import com.example.demo.model.ExercicioEntity;
import com.example.demo.model.ExercicioFichaEntity;
import com.example.demo.model.dto.ExercicioFichaResponseDTO;
import com.example.demo.repository.ExercicioFichaRepository;
import com.example.demo.service.ExercicioFichaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exercicio-ficha")
public class ExercicioFichaController {

    @Autowired
    private ExercicioFichaService exercicioFichaService;

    @GetMapping("/listar")
    public ResponseEntity<List<ExercicioFichaResponseDTO>> listarExercicioFicha(){
        List<ExercicioFichaResponseDTO> fichaResponseDTOList = exercicioFichaService.listarExercicioFicha();
        if(fichaResponseDTOList != null || fichaResponseDTOList.isEmpty()){
            return ResponseEntity.ok(fichaResponseDTOList);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}
