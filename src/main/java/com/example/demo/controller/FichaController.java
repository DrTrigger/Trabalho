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

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editarFicha(@PathVariable(name = "id") Long id, FichaDTO fichaDTO){
        if(this.fichaService.editarFicha(id, fichaDTO)){
            return ResponseEntity.status(HttpStatus.OK).body("Editado com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarFicha(@PathVariable(name = "id") Long id){
        if (fichaService.deletarExercicio(id)) {
            return ResponseEntity.status(HttpStatus.OK).body("ficha deletada com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao deletar Exercicio");
    }

    @GetMapping("/{id}")
    public ResponseEntity<FichaResponseDTO> listarfichas (@PathVariable Long id){
        FichaResponseDTO fichaResponseDTO = fichaService.getFicha(id);
        if(fichaResponseDTO != null){
            return ResponseEntity.status(HttpStatus.OK).body(fichaResponseDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }


}
