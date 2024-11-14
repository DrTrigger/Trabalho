package com.example.demo.utils;

import com.example.demo.model.PlanoEntity;
import com.example.demo.model.dto.DTO;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class DtoConvesorToEntity{
    /**
     * Transforma o DTO recebido pelo VIEW em um Entity
     * @param dto
     * @param entity
     * @param <D>
     * @param <E>
     */
    public static <D extends DTO, E> void DtoToEntity(D dto, E entity){
        List<Field> fieldsEntity = getAllFields(entity.getClass());
        //Field[] fieldsEntity = entity.getClass().getDeclaredFields();
        for (Field fieldEntity : fieldsEntity) {
            fieldEntity.setAccessible(true);
            try {
                // Busca o campo correspondente no DTO
                Field fieldDto = dto.getClass().getDeclaredField(fieldEntity.getName());
                fieldDto.setAccessible(true);
                if(fieldDto.get(dto) == null){ //Se for vazio, para que alterar?
                    continue;
                }
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
    public static <E, D extends DTO> D entityToDto(E entity, D dto){
        Field[] fieldsDTOList = dto.getClass().getDeclaredFields();
        List<Field> fieldsEntity = getAllFields(entity.getClass());
        // pego todos os campos declarados no DTO. O nome.
        for(Field fieldDTO: fieldsDTOList){ //percorre campo por campo
            fieldDTO.setAccessible(true); //defino o campo do DTO para acessivel
            try{
                for(Field fieldx: fieldsEntity){
                    if(fieldx.getName().equalsIgnoreCase(fieldDTO.getName())){
                        fieldx.setAccessible(true);
                        try {
                            fieldDTO.set(dto, fieldx.get(entity));
                        } catch (IllegalArgumentException e) {
                            StringBuilder caminho = new StringBuilder();
                            caminho.append(entity.getClass().getPackageName());
                            caminho.append(".dto.");
                            caminho.append(fieldx.get(entity).getClass().getSimpleName().replace("Entity", "DTO"));
                            Class<?> clazz = Class.forName(String.valueOf(caminho));
                            D instancia = entityToDto( fieldx.get(entity), (D) clazz.getDeclaredConstructor().newInstance());

                            fieldDTO.set(dto, instancia);
                            // Tento converter ele pra um DTO, se possivel.
                            //entityToDto(fieldx.get(entity), fieldx.getName().equalsIgnoreCase(fieldDTO.getName()));
                        }
                        fieldx.setAccessible(false);
                        break;
                    }
                }
                //teste
                //Field fieldEntity = entity.getClass().getDeclaredField(fieldDTO.getName());
                //fieldEntity.setAccessible(true);
                //fieldDTO.set(dto, fieldEntity.get(entity));
            }
            catch (Exception e){
                e.printStackTrace();
            }

        }
        return dto;
    }


    private static List<Field> getAllFields(Class<?> clazz) {
        List<Field> fields = new ArrayList<>();
        while (clazz != null) { // Percorre até o topo da hierarquia
            for (Field field : clazz.getDeclaredFields()) {
                fields.add(field);
            }
            clazz = clazz.getSuperclass(); // Avança para a superclasse
        }
        return fields;
    }

    public static <E, D extends DTO> D entityToDto(E entity, D dto, int repeat){
        if(repeat > 1){
            return null;
        }
        Field[] fieldsDTOList = dto.getClass().getDeclaredFields();
        List<Field> fieldsEntity = getAllFields(entity.getClass());
        // pego todos os campos declarados no DTO. O nome.
        for(Field fieldDTO: fieldsDTOList){ //percorre campo por campo
            fieldDTO.setAccessible(true); //defino o campo do DTO para acessivel
            try{
                for(Field fieldx: fieldsEntity){
                    if(fieldx.getName().equalsIgnoreCase(fieldDTO.getName())){
                        fieldx.setAccessible(true);
                        try {
                            fieldDTO.set(dto, fieldx.get(entity));
                        } catch (IllegalArgumentException e) {
                            StringBuilder caminho = new StringBuilder();
                            caminho.append(entity.getClass().getPackageName());
                            caminho.append(".dto.");
                            caminho.append(fieldx.get(entity).getClass().getSimpleName().replace("Entity", "DTO"));
                            Class<?> clazz = Class.forName(String.valueOf(caminho));
                            D instancia = entityToDto( fieldx.get(entity), (D) clazz.getDeclaredConstructor().newInstance(), repeat++);

                            fieldDTO.set(dto, instancia);
                            // Tento converter ele pra um DTO, se possivel.
                            //entityToDto(fieldx.get(entity), fieldx.getName().equalsIgnoreCase(fieldDTO.getName()));
                        }
                        fieldx.setAccessible(false);
                        break;
                    }
                }
                //teste
                //Field fieldEntity = entity.getClass().getDeclaredField(fieldDTO.getName());
                //fieldEntity.setAccessible(true);
                //fieldDTO.set(dto, fieldEntity.get(entity));
            }
            catch (Exception e){
                e.printStackTrace();
            }

        }
        return dto;
    }

}

