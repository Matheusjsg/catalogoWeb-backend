package com.ecommerce.simples.infrastructure.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table (name = "tb_item_pedido")
public class ItemPedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantidade;
    private BigDecimal precoUnitario;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private ProdutoEntity produto;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private PedidoEntity pedido;


    public ItemPedidoEntity() {
    }


    public ItemPedidoEntity(Long id, int quantidade, BigDecimal precoUnitario, ProdutoEntity produto, PedidoEntity pedido) {
        this.id = id;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.produto = produto;
        this.pedido = pedido;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public BigDecimal getSubTotal() {
        return precoUnitario.multiply(BigDecimal.valueOf(quantidade));
    }

}
