package com.ecommerce.simples.business.mapstruct;


import com.ecommerce.simples.business.dto.Request.CategoriaRequestDTO;
import com.ecommerce.simples.business.dto.Response.CategoriaResponseDTO;
import com.ecommerce.simples.business.dto.Response.ProdutoResponseDTO;
import com.ecommerce.simples.infrastructure.entities.CategoriaEntity;
import com.ecommerce.simples.infrastructure.entities.ProdutoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    @Mapping(target = "id", ignore = true)

    CategoriaEntity toEntity(CategoriaRequestDTO dto);

    List<CategoriaResponseDTO> paraListarCategoriaResponse(List<CategoriaEntity> entities);


    CategoriaResponseDTO toResponse(CategoriaEntity entity);
}
