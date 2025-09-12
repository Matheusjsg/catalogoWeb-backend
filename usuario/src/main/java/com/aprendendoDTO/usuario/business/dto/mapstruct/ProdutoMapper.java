package com.aprendendoDTO.usuario.business.dto.mapstruct;

import com.aprendendoDTO.usuario.business.dto.ProdutoRequestDTO;
import com.aprendendoDTO.usuario.business.dto.ProdutoResponseDTO;
import com.aprendendoDTO.usuario.business.dto.UsuarioResponseDTO;
import com.aprendendoDTO.usuario.infrastructure.entities.ProdutoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    ProdutoEntity paraProdutoEntity(ProdutoRequestDTO dto);

    ProdutoResponseDTO paraProdutoResponse(ProdutoEntity entity);

    List<ProdutoEntity> paraListarProdutoResponseDTO(List<ProdutoEntity> listarProdutos);
}
