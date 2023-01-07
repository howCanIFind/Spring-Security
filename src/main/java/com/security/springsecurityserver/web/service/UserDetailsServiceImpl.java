package com.security.springsecurityserver.web.service;

import com.security.springsecurityserver.exception.UserNotFoundException;
import com.security.springsecurityserver.web.model.UserDetail;
import com.security.springsecurityserver.web.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        return userRepository.findByEmail(userEmail).map(u -> new UserDetail(u,
                Collections.singleton(new SimpleGrantedAuthority(u.getRole().getValue())))).orElseThrow(() -> new UserNotFoundException(userEmail));
    }
}
