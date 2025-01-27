package com.example.musicbox;

import com.example.musicbox.principal.Principal;
import com.example.musicbox.repository.CancionRepository;
import com.example.musicbox.repository.CantanteRepository;
import com.example.musicbox.service.LastFmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.example.musicbox.model")
@EnableJpaRepositories(basePackages = "com.example.musicbox.repository")
public class MusicboxApplication implements CommandLineRunner {

	@Autowired
	private CantanteRepository cantanteRepository;

	@Autowired
	private CancionRepository cancionRepository;

	@Autowired
	private LastFmService lastFmService;

	public static void main(String[] args) {
		SpringApplication.run(MusicboxApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(cantanteRepository, cancionRepository, lastFmService);
		principal.iniciarMenu();
	}
}