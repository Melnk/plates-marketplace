package com.plates.app.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name="users")
@Getter
@Setter
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true, nullable=false) private String username;
    @Column(unique=true, nullable=false) private String email;
    @Column(name="password_hash", nullable=false) private String passwordHash;
    @Column(name="role", nullable=false) private String role; // ROLE_USER or ROLE_ADMIN
    @Column(name="created_at") private LocalDateTime createdAt = LocalDateTime.now();
}
