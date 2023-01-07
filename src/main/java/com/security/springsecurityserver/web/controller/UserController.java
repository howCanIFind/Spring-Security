package com.security.springsecurityserver.web.controller;

import com.security.springsecurityserver.enums.UserRole;
import com.security.springsecurityserver.web.model.Users;
import com.security.springsecurityserver.web.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping(value = "/user")
public class UserController {

    private final UserService userService;

    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/loginView")
    public String loginView() {
        return "user/login";
    }

    @GetMapping("/init")
    public String createAdmin(@ModelAttribute Users users) {
        users.setEmail("user@naver.com");
        users.setUserPw(passwordEncoder.encode("test"));
        users.setRole(UserRole.USER);
        if (userService.createUser(users) == null) {
            log.error("Create user error");
        }

        users.setEmail("admin@naver.com");
        users.setUserPw(passwordEncoder.encode("test"));
        users.setRole(UserRole.ADMIN);
        if (userService.createUser(users) == null) {
            log.error("Create admin error");
        }
        return "redirect:/index";
    }
}
