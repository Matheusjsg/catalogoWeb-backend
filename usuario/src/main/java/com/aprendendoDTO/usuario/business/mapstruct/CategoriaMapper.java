package com.aprendendoDTO.usuario.business.mapstruct;


import com.aprendendoDTO.usuario.business.dto.CategoriaRequestDTO;
import com.aprendendoDTO.usuario.business.dto.CategoriaResponseDTO;
import com.aprendendoDTO.usuario.infrastructure.entities.CategoriaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    CategoriaEntity toEntity(CategoriaRequestDTO dto);
    CategoriaResponseDTO toResponse(CategoriaEntity entity);
}
