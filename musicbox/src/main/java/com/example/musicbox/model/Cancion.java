package com.example.musicbox.model;

import jakarta.persistence.*;

@Entity
@Table(name = "canciones")
public class Cancion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private Integer oyentes;

    @Column(nullable = false)
    private String artista;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cantante_id", nullable = false)
    private Cantante cantante;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getOyentes() {
        return oyentes;
    }

    public void setOyentes(Integer oyentes) {
        this.oyentes = oyentes;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public Cantante getCantante() {
        return cantante;
    }

    public void setCantante(Cantante cantante) {
        this.cantante = cantante;
        this.artista = cantante.getNombre(); // Establecer el nombre del artista
    }
}