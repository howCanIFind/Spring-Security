package com.security.springsecurityserver.web.service;

import com.security.springsecurityserver.web.model.Users;

public interface UserService {

    Users login(Users users);

    Users createUser(Users users);

    Users findUserByUserEmail(String userEmail);
}
