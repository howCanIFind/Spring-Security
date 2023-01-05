package com.security.springsecurityserver.web.service;

import com.security.springsecurityserver.web.model.User;
import com.security.springsecurityserver.web.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public User login(User user) {
        return userRepository.findByUserEmailAndUserPw(user.getUserEmail(), user.getUserPw());
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserByUserEmail(String userEmail) {
        return userRepository.findByUserEmail(userEmail).get();
    }
}
