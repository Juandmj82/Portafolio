package com.example.consumoApi;

import com.example.dto.Movie;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

//Servicio que consume la API de OMDB y obtiene datos de películas.

@Service
public class ApiClient {

    //API key obtenida de la variable de entorno.

    @Value("${OMDB_API_KEY}")
    private String apiKey;

    //URL base de la API de OMDB.

    private static final String API_URL = "http://www.omdbapi.com/?apikey=%s&t=";

    //Método para obtener datos de una película desde la API de OMDB.

    public Movie getMovieData(String movieTitle) {
        // Codificar el título de la película para que sea válido en una URL.
        String encodedMovieTitle = URLEncoder.encode(movieTitle, StandardCharsets.UTF_8);

        // Crear una instancia de HttpClient para enviar solicitudes HTTP.
        HttpClient client = HttpClient.newHttpClient();

        // Crear una solicitud HTTP GET a la API de OMDB con el título de la película codificado.
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format(API_URL, apiKey) + encodedMovieTitle)) // Construir la URI con el título de la película codificado.
                .build(); // Construir la solicitud.

        try {
            // Enviar la solicitud y obtener la respuesta como una cadena de texto.
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Crear una instancia de Gson para convertir el JSON en un objeto Java.
            Gson gson = new Gson();

            // Convertir la respuesta JSON en un objeto Movie.
            return gson.fromJson(response.body(), Movie.class);
        } catch (Exception e) {
            // Manejar cualquier excepción que ocurra durante la solicitud HTTP o la conversión JSON.
            System.out.println("Error al consumir la API: " + e.getMessage());
            return null; // Devolver null si ocurre un error.
        }
    }
}
