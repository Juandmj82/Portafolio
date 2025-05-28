package com.juandidev.crudpeliculas.dao;

import com.juandidev.crudpeliculas.entity.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPeliculaRepository extends JpaRepository<Pelicula, Long> {
}
