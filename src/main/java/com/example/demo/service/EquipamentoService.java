package com.example.demo.service;

import com.example.demo.model.dto.EquipamentoDTO;
import com.example.demo.model.dto.EquipamentoResponseDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipamentoService {

    public boolean cadastrarEquipamento(@Valid EquipamentoDTO dto) {
        return false;
    }

    public List<EquipamentoResponseDTO> listarEquipamento() {
        return null;
    }

    public EquipamentoResponseDTO getEquipamento(Long id) {
        return null;
    }

    public boolean editarEquipamento(Long id, @Valid EquipamentoDTO equipamentoDTO) {
        return false;
    }


    public boolean deletarEquipamento(Long id) {
        return false;
    }
}
