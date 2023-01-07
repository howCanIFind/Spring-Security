package com.security.springsecurityserver.web.model;

import com.security.springsecurityserver.enums.UserRole;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Getter
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Setter
    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @Setter
    @Column(nullable = false)
    private String userPw;

    @Setter
    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Setter
    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
    private Boolean isEnable = true;

    @Builder
    public Users(String email, String userPw){
        this.email = email;
        this.userPw = userPw;
    }
}
