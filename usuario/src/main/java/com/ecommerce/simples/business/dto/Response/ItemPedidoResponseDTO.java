package com.ecommerce.simples.business.dto.Response;

import com.ecommerce.simples.infrastructure.entities.PedidoEntity;
import com.ecommerce.simples.infrastructure.entities.ProdutoEntity;

import java.math.BigDecimal;

public class ItemPedidoResponseDTO {


    private Long id;
    private Integer quantidade;
    private BigDecimal precoUnitario;
    private ProdutoResponseDTO produto;

    public ItemPedidoResponseDTO() {
    }

    public ItemPedidoResponseDTO(Long id, Integer quantidade, BigDecimal precoUnitario, ProdutoResponseDTO produto) {
        this.id = id;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.produto = produto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public ProdutoResponseDTO getProduto() {
        return produto;
    }

    public void setProduto(ProdutoResponseDTO produto) {
        this.produto = produto;
    }
}