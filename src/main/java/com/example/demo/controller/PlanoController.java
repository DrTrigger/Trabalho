package com.example.demo.controller;

import com.example.demo.model.PlanoEntity;
import com.example.demo.model.dto.PlanoDTO;
import com.example.demo.service.PlanoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plano")
public class PlanoController {

    @Autowired
    private PlanoService planoService;

    /**
     *
     * @param dto
     * @return
     */
    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarPlano(@Valid @RequestBody PlanoDTO dto){
        if(planoService.cadastrarPlano(dto)){
            return ResponseEntity.ok("Tudo certo");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar plano");
    }

    /**
     *
     * @return
     */
    @GetMapping("/listar")
    public ResponseEntity<List<PlanoDTO>> listarPlanos(){
        List<PlanoDTO> listPlanos = planoService.listarPlanos();
        if(planoService != null){
            return ResponseEntity.status(HttpStatus.OK).body(listPlanos);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/plano/{id}")
    public ResponseEntity<PlanoDTO> getPlano(@PathVariable Long id){
        PlanoDTO planoDTO = planoService.getPlano(id);
        if(planoDTO != null){
            return ResponseEntity.status(HttpStatus.OK).body(planoDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    /**
     *
     * @param id
     * @param planoDTO
     * @return
     */
    @PutMapping("/editar/{id}")
    public ResponseEntity<PlanoDTO> editarPlano(@PathVariable Long id, @Valid @RequestBody PlanoDTO planoDTO){
        if(planoService.editarPlano(id, planoDTO)){
            return ResponseEntity.status(HttpStatus.OK).body(planoDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarPlano(@PathVariable Long id){
        if(planoService.deletarPlano(id)){
            return ResponseEntity.status(HttpStatus.OK).body("Deletado");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao deletar");
    }


}
