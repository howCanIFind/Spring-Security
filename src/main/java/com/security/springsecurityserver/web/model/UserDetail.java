package com.security.springsecurityserver.web.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@RequiredArgsConstructor
@Getter
public class UserDetail implements UserDetails {

    @Delegate
    private final Users users;
    private final Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return users.getUserPw();
    }

    @Override
    public String getUsername() {
        return users.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return users.getIsEnable();
    }

    @Override
    public boolean isAccountNonLocked() {
        return users.getIsEnable();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return users.getIsEnable();
    }

    @Override
    public boolean isEnabled() {
        return users.getIsEnable();
    }
}
