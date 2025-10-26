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
    private UsuarioResponseDTO cliente;
    private List<ItemPedidoResponseDTO> itens;


    public PedidoResponseDTO() {
    }

    public PedidoResponseDTO(Long id, LocalDateTime dataCriacao, String status, BigDecimal total, UsuarioResponseDTO cliente, List<ItemPedidoResponseDTO> itens) {
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

    public UsuarioResponseDTO getCliente() {
        return cliente;
    }

    public void setCliente(UsuarioResponseDTO cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedidoResponseDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedidoResponseDTO> itens) {
        this.itens = itens;
    }
}
