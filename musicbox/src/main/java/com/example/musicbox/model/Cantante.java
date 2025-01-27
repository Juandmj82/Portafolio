package com.example.musicbox.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cantantes")
public class Cantante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nombre;

    @Column(nullable = false)
    private String urlBiografia;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrlBiografia() {
        return urlBiografia;
    }

    public void setUrlBiografia(String urlBiografia) {
        this.urlBiografia = urlBiografia;
    }
}