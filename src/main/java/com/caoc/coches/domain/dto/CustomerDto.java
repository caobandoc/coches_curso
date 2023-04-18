package com.caoc.coches.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto {

    private String cardId;
    private String fullName;
    private String email;
    private Double numberPhone;
    private Integer active;
    private String password;

}
