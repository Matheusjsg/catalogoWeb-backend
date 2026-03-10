package com.ecommerce.simples.business.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;



public class ProdutoResponseDTO {

        private Long id;
        private String nome;
        private String descricaolink;
        private String descricaoCompleta;
        private BigDecimal preco;
        private List<String> imagens;
        private String slug;
        private CategoriaResponseDTO categoria;

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

    public List<String> getImagens() {
        return imagens;
    }

    public void setImagens(List<String> imagens) {
        this.imagens = imagens;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public CategoriaResponseDTO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaResponseDTO categoria) {
        this.categoria = categoria;
    }

    public ProdutoResponseDTO(Long id, String nome, String descricaolink, String descricaoCompleta, BigDecimal preco, List<String> imagens, String slug, CategoriaResponseDTO categoria) {
        this.id = id;
        this.nome = nome;
        this.descricaolink = descricaolink;
        this.descricaoCompleta = descricaoCompleta;
        this.preco = preco;
        this.imagens = imagens;
        this.slug = slug;
        this.categoria = categoria;
    }
}

