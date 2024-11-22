package com.example.demo.service;

import com.example.demo.model.SolicitacaoAlteracaoEntity;
import com.example.demo.model.dto.SolicitacaoAlteracaoDTO;
import com.example.demo.repository.SolicitacaoAlteracaoRepository;
import com.example.demo.utils.DtoConvesorToEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class SolicitacaoAlteracaoService {

    @Autowired
    private SolicitacaoAlteracaoRepository solicitacaoRepository;

    public boolean criarSolicitacao(@Valid SolicitacaoAlteracaoDTO solicitacaoDTO){

        try{
            SolicitacaoAlteracaoEntity solicitacaoEntity = new SolicitacaoAlteracaoEntity();
            DtoConvesorToEntity.DtoToEntity(solicitacaoDTO, solicitacaoEntity);
            solicitacaoRepository.save(solicitacaoEntity);
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletarSolicitacao(Long idSolicitacao){
        try{
            Optional<SolicitacaoAlteracaoEntity> solicitacaoEntity = solicitacaoRepository.findById(idSolicitacao);

            if(solicitacaoEntity.isPresent()){
                solicitacaoRepository.deleteById(idSolicitacao);
                return true;
            }
            return false;
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public SolicitacaoAlteracaoDTO getSolicitacao(Long idSolicitacao){
        try {
            SolicitacaoAlteracaoEntity solicitacaoEntity = solicitacaoRepository.findById(idSolicitacao).get();
            SolicitacaoAlteracaoDTO solicitacaoDTO = DtoConvesorToEntity.entityToDto(solicitacaoEntity, new SolicitacaoAlteracaoDTO());
            return solicitacaoDTO.get();
        }catch(Exception e){
            return null;
        }
    }

    public List<SolicitacaoAlteracaoDTO> listarSolicitacoes(){

        List<SolicitacaoAlteracaoEntity> solicitacaoEntities = solicitacaoRepository.findAll();
        List<SolicitacaoAlteracaoDTO> solicitacaoDTOS = new ArrayList<>();

        for(SolicitacaoAlteracaoEntity solicitacaoEntity : solicitacaoEntities){
            SolicitacaoAlteracaoDTO solicitacaoDTO = DtoConvesorToEntity.entityToDto(solicitacaoEntity, new SolicitacaoAlteracaoDTO());
            solicitacaoDTOS.add(solicitacaoDTO);
        }

        return solicitacaoDTOS;
    }

    public boolean editarSolicitacao(SolicitacaoAlteracaoDTO solicitacaoDTO, Long id ){
            return deletarSolicitacao(solicitacaoDTO.getIdSolicitacao()) && criarSolicitacao(solicitacaoDTO);
    }
}
