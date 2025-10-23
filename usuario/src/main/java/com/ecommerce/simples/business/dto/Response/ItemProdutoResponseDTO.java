package com.ecommerce.simples.business.dto.Response;

import com.ecommerce.simples.infrastructure.entities.PedidoEntity;
import com.ecommerce.simples.infrastructure.entities.ProdutoEntity;

import java.math.BigDecimal;

public class ItemProdutoResponseDTO {



    private int quantidade;
    private BigDecimal precoUnitario;
    private ProdutoEntity produto;
    private PedidoEntity pedido;

    public ItemProdutoResponseDTO() {
    }

    public ItemProdutoResponseDTO(ProdutoEntity produto, int quantidade, BigDecimal precoUnitario, PedidoEntity pedido) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.pedido = pedido;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public ProdutoEntity getProduto() {
        return produto;
    }

    public void setProduto(ProdutoEntity produto) {
        this.produto = produto;
    }

    public PedidoEntity getPedido() {
        return pedido;
    }

    public void setPedido(PedidoEntity pedido) {
        this.pedido = pedido;
    }
}
