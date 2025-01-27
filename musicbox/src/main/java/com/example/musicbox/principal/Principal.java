package com.example.musicbox.principal;

import com.example.musicbox.MusicboxApplication;
import com.example.musicbox.repository.CancionRepository;
import com.example.musicbox.repository.CantanteRepository;
import com.example.musicbox.service.LastFmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

@Component
public class Principal {

    private final CantanteRepository cantanteRepository;
    private final CancionRepository cancionRepository;
    private final LastFmService lastFmService;

    @Autowired
    public Principal(CantanteRepository cantanteRepository, CancionRepository cancionRepository, LastFmService lastFmService) {
        this.cantanteRepository = cantanteRepository;
        this.cancionRepository = cancionRepository;
        this.lastFmService = lastFmService;
    }

    public void iniciarMenu() {
        Menu menu = new Menu(cantanteRepository, cancionRepository, lastFmService);
        menu.muestraElMenu();
    }

    public static void main(String[] args) {
        SpringApplication.run(MusicboxApplication.class, args);
    }
}