package com.ecommerce.simples.business.dto.Request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;


public class CategoriaRequestDTO {
    private String nome;

    public String getNome() {
        return nome;
    }

    public CategoriaRequestDTO(String nome) {
        this.nome = nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
