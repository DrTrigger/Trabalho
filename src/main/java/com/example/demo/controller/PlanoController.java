package com.example.demo.controller;

import com.example.demo.model.PlanoEntity;
import com.example.demo.service.PlanoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plano")
public class PlanoController {

    @Autowired
    private PlanoService planoService;

    @PostMapping("/criar")
    public ResponseEntity<String> cadastrarPlano(@Valid @RequestBody PlanoEntity planoEntity){
        planoService.cadastrarPlano(planoEntity);
        return ResponseEntity.ok("Tudo certo");
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarPlanos(){
        List<PlanoEntity> listPlanos = planoService.listarPlanos();
        return ResponseEntity.ok(listPlanos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePlano(@PathVariable Long id){
        planoService.deletarPlano(id);
        return ResponseEntity.ok("tudo Certo");
    }


}
