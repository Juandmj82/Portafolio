package com.example.musicbox.repository;

import com.example.musicbox.model.Cantante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CantanteRepository extends JpaRepository<Cantante, Long> {
    Cantante findByNombre(String nombre);
}