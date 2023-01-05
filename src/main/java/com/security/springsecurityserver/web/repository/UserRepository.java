package com.security.springsecurityserver.web.repository;

import com.security.springsecurityserver.web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserEmailAndUserPw(String userId, String userPw);

    Optional<User> findByUserEmail(String userEmail);
}
