package com.security.springsecurityserver.web.repository;

import com.security.springsecurityserver.web.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    Users findByEmailAndUserPw(String userId, String userPw);

    Optional<Users> findByEmail(String userEmail);
}
