package com.vitech.Lab06_training.repositorio;

import com.vitech.Lab06_training.modelo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}