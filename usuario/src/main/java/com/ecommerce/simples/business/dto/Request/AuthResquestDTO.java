package com.ecommerce.simples.business.dto.Request;

import lombok.Data;

public class AuthResquestDTO {

    @Data
    public class AuthRequestDTO {
        private String nome;
        private String password;

    }
}
