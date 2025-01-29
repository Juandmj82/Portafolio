package com.example.gestorTareas.repository;

import com.example.gestorTareas.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByNombre(String nombre);

    Optional<User> findByEmail(String email);
}
