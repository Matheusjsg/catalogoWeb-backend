package com.ecommerce.simples.business.services;

import com.ecommerce.simples.business.dto.Request.CategoriaRequestDTO;
import com.ecommerce.simples.business.dto.Response.CategoriaResponseDTO;
import com.ecommerce.simples.business.mapstruct.CategoriaMapper;
import com.ecommerce.simples.infrastructure.entities.CategoriaEntity;
import com.ecommerce.simples.infrastructure.repositories.CategoriaRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    public CategoriaService(CategoriaRepository categoriaRepository, CategoriaMapper categoriaMapper) {
        this.categoriaRepository = categoriaRepository;
        this.categoriaMapper = categoriaMapper;
    }

    public CategoriaResponseDTO CriarCategoria (CategoriaRequestDTO categoriaDto){
        // Transformar DTO em Entity
        CategoriaEntity categoria = categoriaMapper.toEntity(categoriaDto);

        // Salvar no banco
        CategoriaEntity salvo = categoriaRepository.save(categoria);

        // Retornar DTO de resposta
        return categoriaMapper.toResponse(salvo);
    }

}
