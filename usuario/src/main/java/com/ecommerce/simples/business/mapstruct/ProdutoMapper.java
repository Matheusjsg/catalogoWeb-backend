package com.ecommerce.simples.business.mapstruct;

import com.ecommerce.simples.business.dto.Response.CategoriaResponseDTO;
import com.ecommerce.simples.business.dto.Request.ProdutoRequestDTO;
import com.ecommerce.simples.business.dto.Response.ProdutoResponseDTO;
import com.ecommerce.simples.infrastructure.entities.CategoriaEntity;
import com.ecommerce.simples.infrastructure.entities.ImagemEntity;
import com.ecommerce.simples.infrastructure.entities.ProdutoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "slug", ignore = true) // slug pode ser gerado no service
    @Mapping(target = "categoria", source = "categoriaId", qualifiedByName = "mapCategoria")
    @Mapping(target = "imagens", source = "imagens", qualifiedByName = "mapImagensStringToEntity")
    ProdutoEntity paraProdutoEntity(ProdutoRequestDTO dto);

    @Mapping(target = "categoria", source = "categoria", qualifiedByName = "mapCategoriaResponse")
    @Mapping(target = "imagens", source = "imagens", qualifiedByName = "mapImagensEntityToString")
    ProdutoResponseDTO paraProdutoResponse(ProdutoEntity entity);


    List<ProdutoResponseDTO> paraListarProdutoResponse(List<ProdutoEntity> entities);


    // -------- Métodos auxiliares --------

    // Categoria do requestDTO -> CategoriaEntity
    @Named("mapCategoria")
    default CategoriaEntity mapCategoria(Long categoriaId) {
        if (categoriaId == null) return null;
        CategoriaEntity categoria = new CategoriaEntity();
        categoria.setId(categoriaId);
        return categoria;
    }

    // CategoriaEntity -> CategoriaResponseDTO
    @Named("mapCategoriaResponse")
    default CategoriaResponseDTO mapCategoriaResponse(CategoriaEntity categoria) {
        if (categoria == null) return null;
        return new CategoriaResponseDTO(categoria.getId(), categoria.getNome());
    }

    // Imagens do requestDTO (String) -> Entity
    @Named("mapImagensStringToEntity")
    default List<ImagemEntity> mapImagensStringToEntity(List<String> imagens) {
        if (imagens == null) return null;
        return imagens.stream().map(nome -> {
            ImagemEntity imagem = new ImagemEntity();
            imagem.setNomeArquivo(nome);
            return imagem;
        }).toList();
    }

    // Imagens do Entity -> ResponseDTO (String)
    @Named("mapImagensEntityToString")
    default List<String> mapImagensEntityToString(List<ImagemEntity> imagens) {
        if (imagens == null) return null;
        return imagens.stream()
                .map(ImagemEntity::getNomeArquivo)
                .toList();
    }
}
