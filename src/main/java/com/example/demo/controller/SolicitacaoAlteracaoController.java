package com.example.demo.controller;

import com.example.demo.model.dto.SolicitacaoAlteracaoDTO;
import com.example.demo.model.dto.SolicitacaoRequestAlteracaoDTO;
import com.example.demo.service.SolicitacaoAlteracaoService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/solicitacao-alteracao")
public class SolicitacaoAlteracaoController {

    @Autowired
    private SolicitacaoAlteracaoService solicitacaoAlteracaoService;

    @PostMapping("/solicitar")
    public ResponseEntity<String> criarSolicitacao(@Valid @RequestBody SolicitacaoAlteracaoDTO SolicitacaoDTO) {
        if(solicitacaoAlteracaoService.criarSolicitacao(SolicitacaoDTO)){
            return ResponseEntity.ok().body("Criado");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar solicitacao");
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<SolicitacaoRequestAlteracaoDTO>> listarSolicitacoes(){
        List<SolicitacaoRequestAlteracaoDTO> l_Solicitacoes= solicitacaoAlteracaoService.listarSolicitacoes();
        if(!l_Solicitacoes.isEmpty()){
            return ResponseEntity.ok(l_Solicitacoes);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
