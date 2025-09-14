package com.ecommerce.simples.business.mapstruct;


import com.ecommerce.simples.business.dto.Request.CategoriaRequestDTO;
import com.ecommerce.simples.business.dto.Response.CategoriaResponseDTO;
import com.ecommerce.simples.infrastructure.entities.CategoriaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    CategoriaEntity toEntity(CategoriaRequestDTO dto);
    CategoriaResponseDTO toResponse(CategoriaEntity entity);
}
