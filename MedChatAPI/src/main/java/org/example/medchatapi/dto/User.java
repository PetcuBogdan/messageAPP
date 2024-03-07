package org.example.medchatapi.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    public User(){}

    public User(String email, String password) {
        email = email;
        password = password;
    }
}
