package com.aprendendoDTO.usuario.business.dto;

import com.aprendendoDTO.usuario.infrastructure.entities.CategoriaEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoResponseDTO {


        private String nome;
        private String descricaolink;
        private String descricaoCompleta;
        private BigDecimal preco;
        private List<String> imagens;
        private String slug;
        private CategoriaResponseDTO categoria;
    }

