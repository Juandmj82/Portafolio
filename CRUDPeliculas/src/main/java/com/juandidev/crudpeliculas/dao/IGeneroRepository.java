package com.juandidev.crudpeliculas.dao;

import com.juandidev.crudpeliculas.entity.Genero;
import org.springframework.data.repository.CrudRepository;


//Al extender de CrudRepository no necesitamos implementar los metodos CRUD
public interface IGeneroRepository extends CrudRepository<Genero, Long> {
}

