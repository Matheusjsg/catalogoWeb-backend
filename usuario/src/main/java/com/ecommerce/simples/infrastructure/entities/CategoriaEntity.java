package com.ecommerce.simples.infrastructure.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name = "categorias")
public class CategoriaEntity {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nome;

        @OneToMany(mappedBy = "categoria")
        private List<ProdutoEntity> produtos;

        public CategoriaEntity() {
        }

    public CategoriaEntity(Long id, String nome, List<ProdutoEntity> produtos) {
        this.id = id;
        this.nome = nome;
        this.produtos = produtos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<ProdutoEntity> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoEntity> produtos) {
        this.produtos = produtos;
    }
}
