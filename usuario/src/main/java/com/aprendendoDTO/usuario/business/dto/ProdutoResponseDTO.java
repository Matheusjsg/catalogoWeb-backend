package com.aprendendoDTO.usuario.business.dto;

import com.aprendendoDTO.usuario.infrastructure.entities.CategoriaEntity;
import com.aprendendoDTO.usuario.infrastructure.entities.ImagemEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProdutoResponseDTO {


        private String nome;
        private String descricaolink;
        private String descricaoCompleta;
        private BigDecimal preco;
        private List<ImagemEntity> imagens = new ArrayList<>();
        private String slug;
        private CategoriaEntity categoria;
    }

