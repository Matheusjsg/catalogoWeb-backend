package com.ecommerce.simples.infrastructure.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "tb_produtos")
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

        @Column(name = "preco", precision = 10, scale = 2)
        private BigDecimal preco;

        @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<ImagemEntity> imagens = new ArrayList<>();

        private String slug;

        @ManyToOne
        @JoinColumn(name = "categoria_id")
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricaolink() {
        return descricaolink;
    }

    public void setDescricaolink(String descricaolink) {
        this.descricaolink = descricaolink;
    }

    public String getDescricaoCompleta() {
        return descricaoCompleta;
    }

    public void setDescricaoCompleta(String descricaoCompleta) {
        this.descricaoCompleta = descricaoCompleta;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public List<ImagemEntity> getImagens() {
        return imagens;
    }

    public void setImagens(List<ImagemEntity> imagens) {
        this.imagens = imagens;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public CategoriaEntity getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEntity categoria) {
        this.categoria = categoria;
    }
}
