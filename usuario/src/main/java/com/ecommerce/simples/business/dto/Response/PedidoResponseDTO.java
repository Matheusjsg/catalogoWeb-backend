package com.ecommerce.simples.business.dto.Response;

import com.ecommerce.simples.infrastructure.entities.ItemPedidoEntity;
import com.ecommerce.simples.infrastructure.entities.UsuarioEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class PedidoResponseDTO {

    private Long id;
    private LocalDateTime dataCriacao;
    private String status;
    private BigDecimal total;
    private UsuarioEntity cliente;
    private List<ItemPedidoEntity> itens;


    public PedidoResponseDTO() {
    }

    public PedidoResponseDTO(Long id, LocalDateTime dataCriacao, String status, BigDecimal total, UsuarioEntity cliente, List<ItemPedidoEntity> itens) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.status = status;
        this.total = total;
        this.cliente = cliente;
        this.itens = itens;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public UsuarioEntity getCliente() {
        return cliente;
    }

    public void setCliente(UsuarioEntity cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedidoEntity> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedidoEntity> itens) {
        this.itens = itens;
    }
}
