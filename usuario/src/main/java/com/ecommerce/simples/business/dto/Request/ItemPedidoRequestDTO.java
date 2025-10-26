package com.ecommerce.simples.business.dto.Request;

import com.ecommerce.simples.infrastructure.entities.PedidoEntity;
import com.ecommerce.simples.infrastructure.entities.ProdutoEntity;


import java.math.BigDecimal;

    public class ItemPedidoRequestDTO {



        private Long produtoId;
        private BigDecimal precoUnitario;
        private int quantidade;



        public ItemPedidoRequestDTO() {
        }

        public ItemPedidoRequestDTO(Long produtoId, BigDecimal precoUnitario, int quantidade) {
            this.produtoId = produtoId;
            this.precoUnitario = precoUnitario;
            this.quantidade = quantidade;
        }

        public Long getProdutoId() {
            return produtoId;
        }

        public void setProdutoId(Long produtoId) {
            this.produtoId = produtoId;
        }

        public BigDecimal getPrecoUnitario() {
            return precoUnitario;
        }

        public void setPrecoUnitario(BigDecimal precoUnitario) {
            this.precoUnitario = precoUnitario;
        }

        public int getQuantidade() {
            return quantidade;
        }

        public void setQuantidade(int quantidade) {
            this.quantidade = quantidade;
        }
    }

