package com.security.springsecurityserver.web.service;

import com.security.springsecurityserver.web.model.User;

public interface UserService {

    User login(User user);

    User createUser(User user);

    User findUserByUserEmail(String userEmail);
}
