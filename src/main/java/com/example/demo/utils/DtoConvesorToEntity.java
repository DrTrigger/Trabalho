package com.example.demo.utils;

import com.example.demo.model.PlanoEntity;

import java.lang.reflect.Field;

public class DtoConvesorToEntity{
    /**
     * Transforma o DTO recebido pelo VIEW em um Entity
     * @param dto
     * @param entity
     * @param <D>
     * @param <E>
     */
    public static <D, E> void DtoToEntity(D dto, E entity){
        Field[] fieldsEntity = entity.getClass().getDeclaredFields();
        for (Field fieldEntity : fieldsEntity) {
            fieldEntity.setAccessible(true);
            try {
                // Busca o campo correspondente no DTO
                Field fieldDto = dto.getClass().getDeclaredField(fieldEntity.getName());
                fieldDto.setAccessible(true);
                // Copia o valor do campo do DTO para a entidade
                fieldEntity.set(entity, fieldDto.get(dto));
            } catch (NoSuchFieldException e) {
                // Campo não encontrado no DTO, ignora este campo e continua
                System.out.println("Campo não encontrado no DTO: " + fieldEntity.getName());
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } finally {
                fieldEntity.setAccessible(false);  // Retorna a visibilidade original
            }
        }
    }

    /**
     * Transforma uma instancia entity em um DTO, para enviar pro Front-end, encapsulando dados sensiveis.
     * @param entity
     * @param dto
     * @return
     * @param <E>
     * @param <D>
     */
    public static <E, D> D entityToDto(E entity, D dto){
        Field[] fieldsDTOList = dto.getClass().getDeclaredFields(); // pego todos os campos declarados no DTO. O nome.
        for(Field fieldDTO: fieldsDTOList){ //percorre campo por campo
            fieldDTO.setAccessible(true); //defino o campo do DTO para acessivel
            try{
                Field fieldEntity = entity.getClass().getDeclaredField(fieldDTO.getName());
                fieldEntity.setAccessible(true);
                fieldDTO.set(dto, fieldEntity.get(entity));
            }
            catch (Exception e){
                e.printStackTrace();
            }
            finally {

            }
        }
        return dto;
    }

}

