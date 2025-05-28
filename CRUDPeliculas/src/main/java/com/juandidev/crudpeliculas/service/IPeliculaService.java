package com.juandidev.crudpeliculas.service;

import com.juandidev.crudpeliculas.entity.Pelicula;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPeliculaService {

    public void save(Pelicula pelicula);
    public Pelicula findById(Long id);
    public List<Pelicula> findAll();
    public void delete(Long id);
    // Nuevo método para paginación
    Page<Pelicula> findAll(Pageable pageable);
}
