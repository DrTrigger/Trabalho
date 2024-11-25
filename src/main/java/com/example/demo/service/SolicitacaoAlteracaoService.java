package com.example.demo.service;

import com.example.demo.model.ExercicioFichaEntity;
import com.example.demo.model.SolicitacaoAlteracaoEntity;
import com.example.demo.model.dto.*;
import com.example.demo.repository.ExercicioFichaRepository;
import com.example.demo.repository.SolicitacaoAlteracaoRepository;
import com.example.demo.utils.DtoConvesorToEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SolicitacaoAlteracaoService {

    @Autowired
    private SolicitacaoAlteracaoRepository solicitacaoAlteracaoRepository;

    @Autowired
    private ExercicioFichaRepository exercicioFichaRepository;

    public boolean criarSolicitacao(@Valid SolicitacaoAlteracaoDTO solicitacaoDTO){
        try{
            SolicitacaoAlteracaoEntity solicitacaoEntity = new SolicitacaoAlteracaoEntity();
            DtoConvesorToEntity.DtoToEntity(solicitacaoDTO, solicitacaoEntity);
            solicitacaoAlteracaoRepository.save(solicitacaoEntity);
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public List<SolicitacaoRequestAlteracaoDTO> listarSolicitacoes() {
        List<SolicitacaoAlteracaoEntity> solicitacaoEntities = solicitacaoAlteracaoRepository.findAll();
        List<SolicitacaoRequestAlteracaoDTO> solicitacaoDTOS = new ArrayList<>();

        for(SolicitacaoAlteracaoEntity solicitacaoEntity : solicitacaoEntities){
            SolicitacaoRequestAlteracaoDTO solicitacaoRequestAlteracaoDTO = DtoConvesorToEntity.entityToDto(solicitacaoEntity, new SolicitacaoRequestAlteracaoDTO());
            List<ExercicioFichaDTO> exercicioFichaResponseDTOS = new ArrayList<>();
            List<ExercicioFichaEntity>list = exercicioFichaRepository.findAllByFichaId(solicitacaoEntity.getIdFicha());
            for(ExercicioFichaEntity exercicioFicha : list){
                ExercicioFichaDTO exercicioFichaDTO = new ExercicioFichaDTO();
                exercicioFichaDTO.setId_exercicio(exercicioFicha.getId_exercicio_ficha());
                exercicioFichaDTO.setId_ficha(exercicioFicha.getFicha().getId());
                exercicioFichaDTO.setPeso(exercicioFicha.getPeso());
                exercicioFichaDTO.setTempo_descanso(exercicioFicha.getTempo_descanso());
                exercicioFichaDTO.setNumero_repeticao(exercicioFicha.getNumero_repeticao());
                exercicioFichaDTO.setId_exercicio(exercicioFicha.getExercicio().getId_exercicio());
                exercicioFichaDTO.setId_equipamento(exercicioFicha.getEquipamento().getIdEquipamento());
                exercicioFichaResponseDTOS.add(exercicioFichaDTO);
            }
            //List<ExercicioFichaEntity> exercicioFichaEntities = exercicioFichaRepository.findByIdFicha(solicitacaoEntity.getIdFicha());
            //solicitacaoRequestAlteracaoDTO.setExercicios_da_ficha();
            solicitacaoRequestAlteracaoDTO.setExercicios_da_ficha(exercicioFichaResponseDTOS);
            solicitacaoDTOS.add(solicitacaoRequestAlteracaoDTO);
        }
        return solicitacaoDTOS;
    }
}
