package com.caoc.coches.domain.service;

import com.caoc.coches.domain.dto.AuthenticationDto;
import com.caoc.coches.domain.dto.CustomerDto;
import com.caoc.coches.domain.dto.TokenDto;

public interface IAuthService {
    TokenDto register(CustomerDto customerDto);
    TokenDto authenticate(AuthenticationDto authenticationDto);
}
