package com.example.gestorTareas.repository;

import com.example.gestorTareas.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByNombre(String nombre);
}
