package com.caoc.coches.domain.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Getter
@Setter
// implementamos el userDetails eliminamos el codigo que se genera por defecto
// lo implemente aqui ya que tenemos un servicio que se encarga de obtener los usuarios
public class CustomerDto implements UserDetails{

    private String cardId;
    private String fullName;
    private String email;
    private Double numberPhone;
    private Integer active;
    private String password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // si se manejan roles se puede implementar aqui
        return null;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
