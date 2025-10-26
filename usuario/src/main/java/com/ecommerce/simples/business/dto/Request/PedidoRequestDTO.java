package com.ecommerce.simples.business.dto.Request;


import java.math.BigDecimal;
import java.util.List;

public class PedidoRequestDTO {


    private String status;
    private BigDecimal total;
    private Long clienteId;
    private List<ItemPedidoRequestDTO> itens;

    public PedidoRequestDTO() {
    }

    public PedidoRequestDTO(String status, BigDecimal total, Long clienteId, List<ItemPedidoRequestDTO> itens) {
        this.status = status;
        this.total = total;
        this.clienteId = clienteId;
        this.itens = itens;
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

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public List<ItemPedidoRequestDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedidoRequestDTO> itens) {
        this.itens = itens;
    }
}
