package com.example.demo.service;

import com.example.demo.model.PlanoEntity;
import com.example.demo.model.TipoEquipamentoEntity;
import com.example.demo.model.dto.PlanoDTO;
import com.example.demo.model.dto.TipoEquipamentoDTO;
import com.example.demo.model.dto.TipoEquipamentoResponseDTO;
import com.example.demo.repository.TipoEquipamentoRepository;
import com.example.demo.utils.DtoConvesorToEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TipoEquipamentoService {

    @Autowired
    private TipoEquipamentoRepository tipoEquipamentoRepository;

    public TipoEquipamentoResponseDTO getTipoEquipamento(Long id) {
        try{
            Optional<TipoEquipamentoEntity> tipoEquipamentoEntity = tipoEquipamentoRepository.findById(id);
            if(tipoEquipamentoEntity.isPresent()){
                return DtoConvesorToEntity.entityToDto(tipoEquipamentoEntity.get(), new TipoEquipamentoResponseDTO());
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean deletarTipoEquipamento(Long id) {
        Optional<TipoEquipamentoEntity> tipoEquipamentoEntity = tipoEquipamentoRepository.findById(id);
        if(!tipoEquipamentoEntity.isPresent()){
            return false;
        }
        try{
            if(tipoEquipamentoEntity.isPresent()){
                tipoEquipamentoRepository.delete(tipoEquipamentoEntity.get());
            }
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean cadastrarTipoEquipamento(TipoEquipamentoDTO dto) {
        TipoEquipamentoEntity tipoEquipamentoEntity = new TipoEquipamentoEntity();
        try {
            DtoConvesorToEntity.DtoToEntity(dto, tipoEquipamentoEntity);
            tipoEquipamentoRepository.save(tipoEquipamentoEntity);
            return true;
        } catch (Exception e) {
            e.printStackTrace(); // Log para diagnóstico de erro
            return false;
        }
    }

    public List<TipoEquipamentoResponseDTO> listarTipoEquipamento() {
        try {
            List<TipoEquipamentoEntity> tipoEquipamentoEntities = tipoEquipamentoRepository.findAll();
            List<TipoEquipamentoResponseDTO> tipoEquipamentoResponseDTOList = new ArrayList<>();
            for (TipoEquipamentoEntity tipoEquipamentoEntity : tipoEquipamentoEntities) {
                TipoEquipamentoResponseDTO tipoEquipamentoResponseDTO = DtoConvesorToEntity.entityToDto(tipoEquipamentoEntity, new TipoEquipamentoResponseDTO());
                tipoEquipamentoResponseDTOList.add(tipoEquipamentoResponseDTO);
            }
            return tipoEquipamentoResponseDTOList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean editarTipoEquipamento(Long id, TipoEquipamentoDTO tipoEquipamentoDTO) {
        try{
            Optional<TipoEquipamentoEntity> tipoEquipamentoEntity = tipoEquipamentoRepository.findById(id);
            if(tipoEquipamentoEntity.isPresent()){
                TipoEquipamentoEntity tipoEquipamento = tipoEquipamentoEntity.get();
                DtoConvesorToEntity.DtoToEntity(tipoEquipamentoDTO, tipoEquipamento);
                tipoEquipamentoRepository.save(tipoEquipamento);
                return true;
            }
            return false;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
