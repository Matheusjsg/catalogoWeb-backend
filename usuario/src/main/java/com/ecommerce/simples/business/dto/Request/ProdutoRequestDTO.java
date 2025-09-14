package com.ecommerce.simples.business.dto.Request;

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
public class ProdutoRequestDTO {



    private String nome;
    private String descricaolink;
    private String descricaoCompleta;
    private BigDecimal preco;
    private List<String> imagens;
    private Long categoriaId;
}
