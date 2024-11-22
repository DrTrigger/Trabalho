package com.example.demo.controller;


import com.example.demo.model.SolicitacaoAlteracaoEntity;
import com.example.demo.model.dto.SolicitacaoAlteracaoDTO;
import com.example.demo.service.SolicitacaoAlteracaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ficha/alteracao")
public class SolicitacaoAlteracaoController {
    @Autowired
    private SolicitacaoAlteracaoService solicitacaoService;

    @PostMapping("/solicitar")
    public ResponseEntity<String> criarSolicitacao(@Valid @RequestBody SolicitacaoAlteracaoDTO SolicitacaoDTO) {
        if(solicitacaoService.criarSolicitacao(SolicitacaoDTO)){
            return ResponseEntity.ok().body("Criado");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar solicitacao");
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<SolicitacaoAlteracaoDTO> getSolicitacao(@PathVariable Long id){
        SolicitacaoAlteracaoDTO solicitacaoDTO = solicitacaoService.getSolicitacao(id);
        if(solicitacaoDTO != null){
            return ResponseEntity.ok(solicitacaoDTO);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


    @PutMapping("/editar")
    public ResponseEntity<String> editarSolicitacao(@Valid @RequestBody SolicitacaoAlteracaoDTO solicitacaoDto, Long id){
        if(solicitacaoService.editarSolicitacao(solicitacaoDto, id)){
            return ResponseEntity.ok().body("Solicitacao atualizada com sucesso");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao editar.");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarSolicitacao(@PathVariable Long id){
        if(solicitacaoService.deletarSolicitacao(id)){
            return ResponseEntity.ok().body("Deletado");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao deletar solicitacao");
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<SolicitacaoAlteracaoDTO>> listarSolicitacoes(){
        List<SolicitacaoAlteracaoDTO> l_Solicitacoes= solicitacaoService.listarSolicitacoes();
        if(!l_Solicitacoes.isEmpty()){
            return ResponseEntity.ok(l_Solicitacoes);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
