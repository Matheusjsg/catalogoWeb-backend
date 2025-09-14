package com.aprendendoDTO.usuario.infrastructure.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
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



}
