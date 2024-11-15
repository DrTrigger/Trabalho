package com.example.demo.controller;

import com.example.demo.model.FichaEntity;
import com.example.demo.model.dto.AlunoDTO;
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
    public ResponseEntity<String> criarFicha(@Valid @RequestBody FichaDTO fichaDTO) {
        if(fichaService.cadastrarFicha(fichaDTO)){
            return ResponseEntity.status(HttpStatus.CREATED).body("ficha criada com sucesso");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar ficha");
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
