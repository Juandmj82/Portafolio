package com.juandidev.crudpeliculas.service;

import com.juandidev.crudpeliculas.entity.Genero;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IGeneroService {

    public void save(Genero genero);
    public Genero findById(Long id);
    public void delete(Long id);
    public List<Genero> findAll();
}
