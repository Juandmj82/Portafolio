package com.juandidev.crudpeliculas.controller;

import com.juandidev.crudpeliculas.entity.Genero;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.juandidev.crudpeliculas.service.IGeneroService;


@RestController
public class GeneroController {

    private IGeneroService service;


    public GeneroController(IGeneroService service) {
        this.service = service;
    }

    @PostMapping("genero")
    public Long guardar(@RequestParam String nombre) {
        Genero genero = new Genero();
        genero.setNombre(nombre);

        service.save(genero);

        return genero.getId();
    }

    @GetMapping("genero/{id}")
    public String buscarPorId(@PathVariable(name = "id") Long id) {
        return service.findById(id).getNombre();
    }

}