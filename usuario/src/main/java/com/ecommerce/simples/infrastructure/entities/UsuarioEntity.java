package com.ecommerce.simples.infrastructure.entities;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "tb_users")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "senha")
    private String password;


    public UsuarioEntity(String nome, String email, String password) {
        this.nome = nome;
        this.email = email;
        this.password = password;
    }



}


