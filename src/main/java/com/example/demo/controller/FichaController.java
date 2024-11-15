package com.example.demo.controller;

import com.example.demo.model.FichaEntity;
import com.example.demo.model.dto.FichaDTO;
import com.example.demo.model.dto.FichaResponseDTO;
import com.example.demo.model.dto.TipoEquipamentoResponseDTO;
import com.example.demo.repository.FichaRepository;
import com.example.demo.service.FichaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ficha")
public class FichaController {
    @Autowired
    private FichaService fichaService;


    // Criar uma nova ficha
    @PostMapping("/cadastrar")
    public ResponseEntity<FichaResponseDTO> criarFicha(@Valid @RequestBody FichaDTO fichaDTO) {
        FichaResponseDTO fichaResponseDTO = fichaService.cadastrarFicha(fichaDTO);
        if (fichaResponseDTO != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(fichaResponseDTO);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<FichaResponseDTO>> listarfichas (){
        List<FichaResponseDTO> fichaResponseDTOList = fichaService.listarFichas();
        if(fichaResponseDTOList != null){
            return ResponseEntity.status(HttpStatus.OK).body(fichaResponseDTOList);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}
