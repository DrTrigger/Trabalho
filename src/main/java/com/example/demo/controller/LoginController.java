package com.example.demo.controller;

import com.example.demo.model.AlunoEntity;
import com.example.demo.model.PessoaEntity;
import com.example.demo.model.ProfessorEntity;
import com.example.demo.model.dto.LoginDTO;
import com.example.demo.repository.LoginRepository;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/login")
public class LoginController{
    @Autowired
    private LoginRepository loginRepository;



    @GetMapping("/entrar")
    public ResponseEntity<?> fazerLogin(@RequestBody LoginDTO loginDTO) {
        Optional<? extends PessoaEntity> pessoa = loginRepository.fazerLogin(loginDTO.email(), loginDTO.senha());
        if (pessoa.isPresent()) {
            if (pessoa.get() instanceof AlunoEntity aluno) {
                //System.out.println("Login como aluno: " + aluno.getMatricula_aluno());
                return  ResponseEntity.ok(aluno);

            } else if (pessoa.get() instanceof ProfessorEntity professor) {
                return  ResponseEntity.ok(professor);
                //System.out.println("Login como professor: " + professor.getCref());
            }
        }
        return ResponseEntity.status(401).body("Credenciais inválidas. Verifique seu email e senha.");
    }

}
