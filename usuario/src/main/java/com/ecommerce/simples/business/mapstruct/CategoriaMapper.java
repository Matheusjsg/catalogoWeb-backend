package com.ecommerce.simples.business.mapstruct;


import com.ecommerce.simples.business.dto.Request.CategoriaRequestDTO;
import com.ecommerce.simples.business.dto.Response.CategoriaResponseDTO;
import com.ecommerce.simples.infrastructure.entities.CategoriaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    @Mapping(target = "id", ignore = true)
    CategoriaEntity toEntity(CategoriaRequestDTO dto);

    CategoriaResponseDTO toResponse(CategoriaEntity entity);
}
