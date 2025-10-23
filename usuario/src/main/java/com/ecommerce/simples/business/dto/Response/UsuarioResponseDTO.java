package com.ecommerce.simples.business.dto.Response;




public class UsuarioResponseDTO {

    private long id;
    private String nome;
    private String email;
    private String Role;

    public UsuarioResponseDTO() {
    }

    public UsuarioResponseDTO(long id, String nome, String email, String role) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        Role = role;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }
}
