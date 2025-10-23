package com.ecommerce.simples.business.dto.Request;

import com.ecommerce.simples.infrastructure.entities.ItemPedidoEntity;
import com.ecommerce.simples.infrastructure.entities.UsuarioEntity;
import java.math.BigDecimal;
import java.util.List;

public class PedidoRequestDTO {


    private String status;
    private BigDecimal total;
    private UsuarioEntity cliente;
    private List<ItemPedidoEntity> itens;

    public PedidoRequestDTO() {
    }

    public PedidoRequestDTO(BigDecimal total, UsuarioEntity cliente, List<ItemPedidoEntity> itens) {

        this.total = total;
        this.cliente = cliente;
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
