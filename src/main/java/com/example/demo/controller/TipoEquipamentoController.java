package com.example.demo.controller;

import com.example.demo.model.dto.EquipamentoDTO;
import com.example.demo.model.dto.PlanoDTO;
import com.example.demo.model.dto.TipoEquipamentoDTO;
import com.example.demo.model.dto.TipoEquipamentoResponseDTO;
import com.example.demo.service.EquipamentoService;
import com.example.demo.service.PlanoService;
import com.example.demo.service.TipoEquipamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipamentos/tipos")
public class TipoEquipamentoController {

    @Autowired
    private TipoEquipamentoService tipoEquipamentoService;


    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarTipoEquipamento(@Valid @RequestBody TipoEquipamentoDTO dto){
        if(tipoEquipamentoService.cadastrarTipoEquipamento(dto)){
            return ResponseEntity.ok("Tudo certo");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar Tipo de equipamento");
    }


    @GetMapping("/listar")
    public ResponseEntity<List<TipoEquipamentoResponseDTO>> listarTipoEquipamento(){
        List<TipoEquipamentoResponseDTO> listTipoEquipamentos = tipoEquipamentoService.listarTipoEquipamento();
        if(listTipoEquipamentos != null){
            return ResponseEntity.status(HttpStatus.OK).body(listTipoEquipamentos);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }


    @GetMapping("/{id}")
    public ResponseEntity<TipoEquipamentoResponseDTO> getTipoEquipamento(@PathVariable Long id){
        TipoEquipamentoResponseDTO  tipoEquipamentoResponseDTO = tipoEquipamentoService.getTipoEquipamento(id);
        if(tipoEquipamentoResponseDTO != null){
            return ResponseEntity.status(HttpStatus.OK).body(tipoEquipamentoResponseDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }


    @PutMapping("/editar/{id}")
    public ResponseEntity<TipoEquipamentoDTO> editarTipoEquipamento(@PathVariable Long id, @Valid @RequestBody TipoEquipamentoDTO tipoEquipamentoDTO){
        if(tipoEquipamentoService.editarTipoEquipamento(id, tipoEquipamentoDTO)){
            return ResponseEntity.status(HttpStatus.OK).body(tipoEquipamentoDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }


    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarTipoEquipamento(@PathVariable Long id){
        if(tipoEquipamentoService.deletarTipoEquipamento(id)){
            return ResponseEntity.status(HttpStatus.OK).body("Deletado");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao deletar");
    }

}
