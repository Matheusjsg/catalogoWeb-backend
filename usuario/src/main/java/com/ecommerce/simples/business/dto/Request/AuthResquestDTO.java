package com.ecommerce.simples.business.dto.Request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthResquestDTO {

    @Data
    public class AuthRequestDTO {
        private String email;
        private String password;

    }
}
