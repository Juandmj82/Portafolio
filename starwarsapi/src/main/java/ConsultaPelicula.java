import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaPelicula {
    Pelicula buscaPelicula(int numeroDePelicula) {
        // creamos nuestra propia direccion
        URI direccion = URI.create("https://swapi.dev/api/films/" + numeroDePelicula);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        HttpResponse<String> response = null;
        //creamos un try catch para manejar la excepcion
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        //convertimos el json a un objeto de tipo pelicula
        return new Gson().fromJson(response.body(), Pelicula.class);

    }

}
