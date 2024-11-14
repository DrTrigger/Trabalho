package com.example.demo.controller;

import com.example.demo.model.dto.EquipamentoDTO;
import com.example.demo.model.dto.EquipamentoResponseDTO;
import com.example.demo.model.dto.TipoEquipamentoDTO;
import com.example.demo.model.dto.TipoEquipamentoResponseDTO;
import com.example.demo.service.EquipamentoService;
import com.example.demo.service.TipoEquipamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipamento")
public class EquipamentoController {

    @Autowired
    private EquipamentoService equipamentoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarEquipamento(@Valid @RequestBody EquipamentoDTO dto){
        if(equipamentoService.cadastrarEquipamento(dto)){
            return ResponseEntity.ok("Tudo certo");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar de equipamento");
    }


    @GetMapping("/listar")
    public ResponseEntity<List<EquipamentoResponseDTO>> listarEquipamento(){
        List<EquipamentoResponseDTO> listEquipamentos = equipamentoService.listarEquipamento();
        if(!listEquipamentos.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(listEquipamentos);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }


    @GetMapping("/{id}")
    public ResponseEntity<EquipamentoResponseDTO> getEquipamento(@PathVariable Long id){
        EquipamentoResponseDTO equipamentoResponseDTO = equipamentoService.getEquipamento(id);
        if(equipamentoResponseDTO != null){
            return ResponseEntity.status(HttpStatus.OK).body(equipamentoResponseDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }


    @PutMapping("/editar/{id}")
    public ResponseEntity<EquipamentoDTO> editarEquipamento(@PathVariable Long id, @Valid @RequestBody EquipamentoDTO equipamentoDTO){
        if(equipamentoService.editarEquipamento(id, equipamentoDTO)){
            return ResponseEntity.status(HttpStatus.OK).body(equipamentoDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }


    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarEquipamento(@PathVariable Long id){
        if(equipamentoService.deletarEquipamento(id)){
            return ResponseEntity.status(HttpStatus.OK).body("Deletado");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao deletar");
    }
}
