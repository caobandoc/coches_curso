package com.caoc.coches.domain.useCase;

import com.caoc.coches.domain.dto.AuthCustomerDto;
import com.caoc.coches.domain.dto.JwtResponseDto;

public interface IAuthUseCase {

    JwtResponseDto signIn(AuthCustomerDto authCustomerDto);

    JwtResponseDto signOut(String jwt);
}
