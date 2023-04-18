package com.caoc.coches.domain.service.impl;

import com.caoc.coches.config.JwtToken;
import com.caoc.coches.domain.dto.AuthenticationDto;
import com.caoc.coches.domain.dto.CustomerDto;
import com.caoc.coches.domain.dto.TokenDto;
import com.caoc.coches.domain.service.IAuthService;
import com.caoc.coches.domain.service.ICustomerService;
import com.caoc.coches.exception.UserExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService implements IAuthService {
    private final ICustomerService customerService;
    private final JwtToken jwtToken;
    private final AuthenticationManager authenticationManager;
    @Override
    public TokenDto register(CustomerDto customerDto) {
        if (customerService.getCustomerByEmail(customerDto.getEmail()).isPresent() ||
                customerService.getCustomerByCardId(customerDto.getCardId()).isPresent()) {
            throw new UserExistException("User already exists");
        }
        customerService.save(customerDto);

        return new TokenDto(jwtToken.generateToken(customerDto));
    }

    @Override
    public TokenDto authenticate(AuthenticationDto authenticationDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationDto.getEmail(), authenticationDto.getPassword()));
        UserDetails userDetails = customerService.getCustomerByEmail(authenticationDto.getEmail()).orElseThrow();

        return new TokenDto(jwtToken.generateToken(userDetails));
    }
}
