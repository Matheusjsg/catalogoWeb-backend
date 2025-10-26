package com.ecommerce.simples.business.mapstruct;

import com.ecommerce.simples.business.dto.Request.ItemPedidoRequestDTO;
import com.ecommerce.simples.business.dto.Response.ItemPedidoResponseDTO;
import com.ecommerce.simples.infrastructure.entities.ImagemEntity;
import com.ecommerce.simples.infrastructure.entities.ItemPedidoEntity;
import com.ecommerce.simples.infrastructure.entities.ProdutoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;


@Mapper(componentModel = "spring")
public interface ItemPedidoMapper {


    @Mapping(target = "produto", source = "produtoId", qualifiedByName = "mapProduto")
    ItemPedidoEntity toEntity(ItemPedidoRequestDTO dto);

    @Mapping(target = "produto.imagens", source = "produto.imagens", qualifiedByName = "mapImagens")
    ItemPedidoResponseDTO toResponseDTO(ItemPedidoEntity entity);

    @Named("mapProduto")
    default ProdutoEntity mapProduto(Long produtoId) {
        if (produtoId == null) return null;
        ProdutoEntity produto = new ProdutoEntity();
        produto.setId(produtoId);
        return produto;
    }

    @Named("mapImagens")
    default List<String> mapImagens(List<ImagemEntity> imagens) {
        if (imagens == null) return List.of();
        return imagens.stream()
                .map(ImagemEntity::getNomeArquivo)
                .collect(Collectors.toList());
    }
}
