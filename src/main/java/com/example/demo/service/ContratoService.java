package com.example.demo.service;

import com.example.demo.model.AlunoEntity;
import com.example.demo.model.ContratoEntity;
import com.example.demo.model.PlanoEntity;
import com.example.demo.model.dto.ContratoDTO;
import com.example.demo.model.dto.ContratoResponseDTO;
import com.example.demo.repository.AlunoRepository;
import com.example.demo.repository.ContratoRepository;
import com.example.demo.repository.PlanoRepository;
import com.example.demo.utils.DtoConvesorToEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ContratoService {

    @Autowired
    private ContratoRepository contratoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private PlanoRepository planoRepository;

    public boolean cadastrarContrato(ContratoDTO dto) {
        try{

            if(contratoRepository.findByContratoAtivo(dto.getIdPessoa()).isPresent()){
                return false;
            }
            ContratoEntity contratoEntity = new ContratoEntity();
            contratoEntity.setNome(dto.getNome());

            Optional<AlunoEntity> aluno = alunoRepository.findById(dto.getIdPessoa());
            if (aluno.isPresent()) {
                contratoEntity.setAluno(aluno.get());
            } else {
                throw new RuntimeException("Aluno não encontrado com id: " + dto.getIdPessoa());
            }

            // Verifica se o plano existe antes de configurar
            Optional<PlanoEntity> plano = planoRepository.findById(dto.getIdPlano());
            if (plano.isPresent()) {
                contratoEntity.setPlano(plano.get());
            } else {
                throw new RuntimeException("Plano não encontrado com id: " + dto.getIdPlano());
            }
            contratoEntity.setStatus(dto.getStatus());
            contratoEntity.setData_inicio(dto.getData_inicio());
            contratoEntity.setData_vencimento(dto.getData_vencimento());
            contratoEntity.setData_fim(dto.getData_fim());
            contratoEntity.setValor_pago(dto.getValor_pago());

            contratoRepository.save(contratoEntity);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<ContratoResponseDTO> listarContratos() {
        List<ContratoEntity> contratoEntities = contratoRepository.findAll();
        List<ContratoResponseDTO> contratoDTOList = new ArrayList<>();
        for (ContratoEntity contratoEntity : contratoEntities){
            ContratoResponseDTO contratoDTO = new ContratoResponseDTO();
            contratoDTOList.add(DtoConvesorToEntity.entityToDto(contratoEntity, contratoDTO, 0));
            return contratoDTOList;
        }
        return null;
    }

    public ContratoResponseDTO getContrato(Long id) {
        return null;
    }

    public boolean editarContrato(Long id, @Valid ContratoDTO contratoDTO) {
        Optional<ContratoEntity> contratoEntity = this.contratoRepository.findById(id);
        if(contratoEntity.isPresent()){
            ContratoEntity contrato = contratoEntity.get();
            PlanoEntity plano = contrato.getPlano();

            Optional<PlanoEntity> newPlan = this.planoRepository.findById(contratoDTO.getIdPlano());
            if(newPlan.isPresent()){
                plano = null;
                contrato.setPlano(newPlan.get());
            }
            contrato.setStatus(contratoDTO.getStatus());
            contrato.setData_inicio(contratoDTO.getData_inicio());
            contrato.setData_vencimento(contratoDTO.getData_vencimento());
            contrato.setData_fim(contratoDTO.getData_fim());
            contrato.setValor_pago(contratoDTO.getValor_pago());
            this.contratoRepository.save(contrato);
        }
        return true;
    }

    public boolean deletarContrato(Long id) {
        Optional<ContratoEntity> contratoEntity = contratoRepository.findById(id);
        if(!contratoEntity.isPresent()){
            return false;
        }
        try{
            if(contratoEntity.isPresent()){
                contratoRepository.delete(contratoEntity.get());
            }
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
