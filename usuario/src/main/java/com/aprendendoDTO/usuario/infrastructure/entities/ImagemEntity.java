package com.aprendendoDTO.usuario.infrastructure.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ImagemProduto")
public class ImagemEntity {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        private String nomeArquivo;
        @ManyToOne
        @JoinColumn(name = "produto_id")
        private ProdutoEntity produto;


public ImagemEntity() {}



public ImagemEntity(String nomeArquivo, ProdutoEntity produto) {
            this.nomeArquivo = nomeArquivo;
            this.produto = produto;
        }


}
