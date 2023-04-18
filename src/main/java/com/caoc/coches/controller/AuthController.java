package com.caoc.coches.controller;

import com.caoc.coches.domain.dto.AuthenticationDto;
import com.caoc.coches.domain.dto.CustomerDto;
import com.caoc.coches.domain.dto.TokenDto;
import com.caoc.coches.domain.service.IAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final IAuthService authService;

    @PostMapping("/register")
    public ResponseEntity<TokenDto> register(@RequestBody CustomerDto customerDto){
        return ResponseEntity.ok(authService.register(customerDto));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> authenticate(@RequestBody AuthenticationDto authenticationDto){
        return ResponseEntity.ok(authService.authenticate(authenticationDto));
    }

}
