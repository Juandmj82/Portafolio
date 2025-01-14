package com.example.consumoApi;

import com.example.dto.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;

//Clase principal que inicia la aplicación Spring Boot.

@SpringBootApplication
public class ConsumoApiApplication implements CommandLineRunner {

	//Instancia de ApiClient inyectada automáticamente por Spring.

	@Autowired
	private ApiClient apiClient;

	//Método principal que inicia la aplicación Spring Boot.

	public static void main(String[] args) {
		SpringApplication.run(ConsumoApiApplication.class, args);
	}

	//Método que se ejecuta después de que la aplicación se ha iniciado.

	@Override
	public void run(String... args) throws Exception {
		// Crear una instancia de Scanner para leer la entrada del usuario.
		Scanner scanner = new Scanner(System.in);
		String movieTitle;
		boolean exit = false;

		// Mensaje de bienvenida.
		System.out.println("Bienvenido a la aplicación de búsqueda de películas!");
		System.out.println("===================================================");
		System.out.println("Puedes buscar información sobre cualquier película ingresando su título.");
		System.out.println("Para salir, escribe 'salir'.");
		System.out.println(); // Espacio adicional para mejorar la legibilidad.

		// Bucle para permitir múltiples consultas.
		while (!exit) {
			// Solicitar el título de la película al usuario.
			System.out.print("Ingrese el título de la película que desea buscar (o escriba 'salir' para terminar): ");
			movieTitle = scanner.nextLine();

			// Verificar si el usuario desea salir.
			if (movieTitle.equalsIgnoreCase("salir")) {
				exit = true;
				// Mensaje de despedida.
				System.out.println("Gracias por usar la aplicación. ¡Hasta luego!");
			} else {
				// Obtener los datos de la película desde la API.
				Movie movie = apiClient.getMovieData(movieTitle);
				if (movie != null) {
					// Mostrar los datos de la película por consola.
					System.out.println("\nDatos de la película:");
					System.out.println("======================");
					System.out.println("Título: " + movie.titulo());
					System.out.println("Año: " + movie.año());
					System.out.println("Clasificación: " + movie.clasificacion());
					System.out.println("Lanzamiento: " + movie.lanzamiento());
					System.out.println("Duración: " + movie.duracion());
					System.out.println("Género: " + movie.genero());
					System.out.println("Director: " + movie.director());
					System.out.println("Trama: " + movie.trama());
					System.out.println(); // Espacio adicional para mejorar la legibilidad.
				} else {
					// Mostrar un mensaje de error si no se pueden obtener datos de la API.
					System.out.println("No se pudieron obtener datos de la API.");
					System.out.println(); // Espacio adicional para mejorar la legibilidad.
				}
			}
		}

		// Cerrar el Scanner.
		scanner.close();
	}
}
