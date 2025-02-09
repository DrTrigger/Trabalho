package com.example.demo.service;

import com.example.demo.model.EquipamentoEntity;
import com.example.demo.model.PlanoEntity;
import com.example.demo.model.TipoEquipamentoEntity;
import com.example.demo.model.dto.EquipamentoDTO;
import com.example.demo.model.dto.EquipamentoResponseDTO;
import com.example.demo.model.dto.PlanoDTO;
import com.example.demo.repository.EquipamentoRepository;
import com.example.demo.repository.TipoEquipamentoRepository;
import com.example.demo.utils.DtoConvesorToEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EquipamentoService {
    @Autowired
    private EquipamentoRepository equipamentoRepository;
    @Autowired
    private TipoEquipamentoRepository tipoEquipamentoRepository;
    public boolean cadastrarEquipamento(EquipamentoDTO dto) {
        EquipamentoEntity equipamentoEntity = new EquipamentoEntity();
        try {
            equipamentoEntity.setNome(dto.getNome());
            equipamentoEntity.setPeso(dto.getPeso());
            equipamentoEntity.setDataAquisicao(dto.getDataAquisicao());
            equipamentoEntity.setDescricao(dto.getDescricao());
            equipamentoEntity.setEstado(dto.getEstado());
            equipamentoEntity.setFabricante(dto.getFabricante());
            Optional<TipoEquipamentoEntity> tipoEquipamentoEntity = tipoEquipamentoRepository.findById(dto.getId_tipo_equipamento());
            if(tipoEquipamentoEntity.isPresent()){
                equipamentoEntity.setTipoEquipamento(tipoEquipamentoEntity.get());
            }

            //DtoConvesorToEntity.DtoToEntity(dto, planoEntity);
            equipamentoRepository.save(equipamentoEntity);
            return true;
        } catch (Exception e) {
            e.printStackTrace(); // Log para diagnóstico de erro
            return false;
        }
    }

    public List<EquipamentoResponseDTO> listarEquipamento() {
        try {
            List<EquipamentoEntity> equipamentoEntityList = equipamentoRepository.findAll();
            List<EquipamentoResponseDTO> equipamentoResponseDTOS = new ArrayList<>();
            for (EquipamentoEntity equipamentoEntity : equipamentoEntityList) {
                EquipamentoResponseDTO equipamentoResponseDTO = DtoConvesorToEntity.entityToDto(equipamentoEntity, new EquipamentoResponseDTO(), 0);
                equipamentoResponseDTOS.add(equipamentoResponseDTO);
            }
            return equipamentoResponseDTOS;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public EquipamentoResponseDTO getEquipamento(Long id) {
        try{
            EquipamentoResponseDTO equipamentoResponseDTO = new EquipamentoResponseDTO();
            Optional<EquipamentoEntity> equipamentoEntity = equipamentoRepository.findById(id);
            if(equipamentoEntity.isPresent()){
                return DtoConvesorToEntity.entityToDto(equipamentoEntity.get(), equipamentoResponseDTO);
            }
            return  null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean editarEquipamento(Long id, EquipamentoDTO dto) {
        try{
            Optional<EquipamentoEntity> equipamentoEntity = equipamentoRepository.findById(id);// Pego quem eu quero mudar
            if(equipamentoEntity.isPresent()){
                EquipamentoEntity equipamento = equipamentoEntity.get();
                equipamento.setNome(dto.getNome());
                equipamento.setPeso(dto.getPeso());
                equipamento.setDataAquisicao(dto.getDataAquisicao());
                equipamento.setDescricao(dto.getDescricao());
                equipamento.setEstado(dto.getEstado());
                equipamento.setFabricante(dto.getFabricante());
                Optional<TipoEquipamentoEntity> tipoEquipamentoEntity = tipoEquipamentoRepository.findById(dto.getId_tipo_equipamento()); // garanto se o tipo que eu alterar existe
                if(tipoEquipamentoEntity.isPresent()){
                    equipamento.setTipoEquipamento(tipoEquipamentoEntity.get());
                }
                equipamentoRepository.save(equipamento);
                return true;
            }
            return false;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public boolean deletarEquipamento(Long id) {
        Optional<EquipamentoEntity> equipamentoEntity = equipamentoRepository.findById(id);
        if(!equipamentoEntity.isPresent()){
            return false;
        }
        try{
            equipamentoRepository.delete(equipamentoEntity.get());
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
