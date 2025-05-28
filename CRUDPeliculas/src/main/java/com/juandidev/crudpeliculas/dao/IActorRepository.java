package com.juandidev.crudpeliculas.dao;

import com.juandidev.crudpeliculas.entity.Actor;
import org.springframework.data.repository.CrudRepository;

public interface IActorRepository extends CrudRepository<Actor, Long> {
}
