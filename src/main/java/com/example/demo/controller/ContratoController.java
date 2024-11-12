package com.example.demo.controller;

import com.example.demo.model.ContratoEntity;
import com.example.demo.model.dto.ContratoDTO;
import com.example.demo.model.dto.ContratoResponseDTO;
import com.example.demo.repository.ContratoRepository;
import com.example.demo.service.ContratoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/contrato")
public class ContratoController {
    @Autowired
    private ContratoService contratoService;

//    @Autowired
//    private ContratoRepository contratoRepository;

    /**
     *
     * @param dto
     * @return
     */
    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarContrato(@Valid @RequestBody ContratoDTO dto){
        if(contratoService.cadastrarContrato(dto)){
            return ResponseEntity.ok("Cadastrado");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Algo deu Errado");
    }

    /**
     *
     * @return
     */
    @GetMapping("/listar")
    public ResponseEntity<List<ContratoResponseDTO>> listarContratos(){
        List<ContratoResponseDTO> listContratos = contratoService.listarContratos();
        if(listContratos != null || listContratos.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(listContratos);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<ContratoResponseDTO> getContrato(@PathVariable Long id){
        ContratoResponseDTO contratoDTO = contratoService.getContrato(id);
        if(contratoDTO != null){
            return ResponseEntity.status(HttpStatus.OK).body(contratoDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    /**
     *
     * @param id
     * @param contratoDTO
     * @return
     */
    @PutMapping("/editar/{id}")
    public ResponseEntity<ContratoDTO> editarContrato(@PathVariable Long id, @Valid @RequestBody ContratoDTO contratoDTO){
        if(contratoService.editarContrato(id, contratoDTO)){
            return ResponseEntity.status(HttpStatus.OK).body(contratoDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarContrato(@PathVariable Long id){
        if(contratoService.deletarContrato(id)){
            return ResponseEntity.status(HttpStatus.OK).body("Deletado");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao deletar");
    }
}
