package com.caoc.coches.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationDto {
        private String email;
        private String password;
}
