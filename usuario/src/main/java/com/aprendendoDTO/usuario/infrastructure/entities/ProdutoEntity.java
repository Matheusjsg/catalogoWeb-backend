package com.aprendendoDTO.usuario.infrastructure.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "produtos")
public class ProdutoEntity {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        @Column(name = "nome", unique = true)
        private String nome;

        @Column(name= "descricaolink")
        private String descricaolink;

        @Column(name = "descricaoCompleta", columnDefinition = "TEXT")
        private String descricaoCompleta;

        @Setter
        @Column(name = "preco", precision = 10, scale = 2)
        private BigDecimal preco;

        @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<ImagemEntity> imagens = new ArrayList<>();

        private String slug;

        @ManyToOne
        @JoinColumn(name = "categoria")
        private CategoriaEntity categoria;

        // Construtor
        public ProdutoEntity(String nome, String descricaolink, String descricaoCompleta, BigDecimal preco, CategoriaEntity categoria) {
            this.nome = nome;
            this.descricaolink = descricaolink;
            this.descricaoCompleta = descricaoCompleta;
            this.preco = preco;
            this.categoria = categoria;

        }

        public ProdutoEntity() {}


        }
