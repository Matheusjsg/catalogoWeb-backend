package com.ecommerce.simples.infrastructure.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "tb_imagens")
public class ImagemEntity {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        private String nomeArquivo;

        @ManyToOne
        @JoinColumn(name = "produto_id")
        private ProdutoEntity produto;


public ImagemEntity() {}


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public ProdutoEntity getProduto() {
        return produto;
    }

    public void setProduto(ProdutoEntity produto) {
        this.produto = produto;
    }

    public ImagemEntity(String nomeArquivo, ProdutoEntity produto) {
            this.nomeArquivo = nomeArquivo;
            this.produto = produto;
        }


}
