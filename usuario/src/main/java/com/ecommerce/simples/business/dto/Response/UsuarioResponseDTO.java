package com.ecommerce.simples.business.dto.Response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UsuarioResponseDTO {

    private long id;
    private String nome;
    private String email;
    private String Role;



}
