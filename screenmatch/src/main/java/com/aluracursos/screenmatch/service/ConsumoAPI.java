package com.aluracursos.screenmatch.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CnsumoApi {

    // creamos un método del tipo String que se llame obtenerDatos

    public String ObtenerDatos(String url) {
        // creamos un objeto de tipo HttpClient para hacer la petición a la API
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        // creamos un objeto de tipo HttpResponse para recibir la respuesta de la API
        HttpResponse<String> response = null;
        //usamos un try catch para manejar las excepciones
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // Creamos una variable de tipo String para guardar la respuesta de la API
        String json = response.body();
        // Devolvemos la respuesta de la API
        return json;
    }
}
