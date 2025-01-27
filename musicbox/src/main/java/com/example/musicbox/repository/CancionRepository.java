package com.example.musicbox.repository;

import com.example.musicbox.model.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CancionRepository extends JpaRepository<Cancion, Long> {
    @Query("SELECT c FROM Cancion c JOIN c.cantante ca WHERE FUNCTION('REPLACE', FUNCTION('LOWER', ca.nombre), ' ', '') = :nombreNormalizado")
    List<Cancion> findByCantanteNombreNormalizado(@Param("nombreNormalizado") String nombreNormalizado);
}