package com.juandidev.crudpeliculas.service;

import com.juandidev.crudpeliculas.entity.Actor;

import java.util.List;

public interface IActorService  {
    public List<Actor> findAll();
    public List<Actor> findAllById(List<Long>ids);
}
