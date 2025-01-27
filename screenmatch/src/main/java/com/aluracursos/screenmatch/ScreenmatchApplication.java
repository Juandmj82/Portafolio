package com.aluracursos.screenmatch;


import com.aluracursos.screenmatch.principal.EjemploStreams;
import com.aluracursos.screenmatch.principal.Principal;
import com.aluracursos.screenmatch.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//Implementamos commandLineRunner para que Spring Boot ejecute el metodo run
public class ScreenmatchApplication implements CommandLineRunner {
	//A continuación usamos la inyección de dependencias para instanciar SerieRepository ya que de la forma común no se puede
      @Autowired //Inyección de dependencias
	  private SerieRepository repository; //Instancia de SerieRepository

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	//Método run
	@Override // sobreescribimos el método run
	public void run(String... args) throws Exception {
		 //Instancia de Principal
		Principal principal = new Principal(repository);
		principal.muestraElMenu();
		// Instancia de EjemploStreams
		//EjemploStreams ejemploStreams = new EjemploStreams();
		//ejemploStreams.muestraEjemplo();




	}
}
