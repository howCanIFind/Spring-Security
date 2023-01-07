package com.security.springsecurityserver.web.service;

import com.security.springsecurityserver.web.model.Users;
import com.security.springsecurityserver.web.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public Users login(Users users) {
        return userRepository.findByEmailAndUserPw(users.getEmail(), users.getUserPw());
    }

    @Override
    public Users createUser(Users users) {
        return userRepository.save(users);
    }

    @Override
    public Users findUserByUserEmail(String userEmail) {
        return userRepository.findByEmail(userEmail).get();
    }
}
