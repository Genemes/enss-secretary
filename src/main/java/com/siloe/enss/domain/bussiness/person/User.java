package com.siloe.enss.domain.bussiness.person;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.UUID;

public class User implements UserDetails {

    private UUID id;
    private String username;
    private String password;
    private Set<GrantedAuthority> authorities;

    // Construtores, getters e setters

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // ou implemente a lógica conforme necessário
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // ou implemente a lógica conforme necessário
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // ou implemente a lógica conforme necessário
    }

    @Override
    public boolean isEnabled() {
        return true; // ou implemente a lógica conforme necessário
    }
}
