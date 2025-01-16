package com.example.spring_mysql_connection.controller;

import com.example.spring_mysql_connection.model.Movie;
import com.example.spring_mysql_connection.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    // Crear una nueva película (POST)
    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        System.out.println("Recibido movie: " + movie);  // Log para inspeccionar los datos recibidos
        if (movie.getDirector() == null || movie.getDirector().trim().isEmpty()) {
            return ResponseEntity.badRequest().body(null);  // Validación de 'director' vacío
        }
        Movie savedMovie = movieService.saveMovie(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMovie);
    }

    // Obtener todas las películas (GET)
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = movieService.getAllMovies();
        if (movies.isEmpty()) {
            return ResponseEntity.noContent().build();  // Si no hay películas, devolver 204 No Content
        }
        return ResponseEntity.ok(movies);  // Si hay películas, devolverlas con 200 OK
    }

    // Obtener una película por su ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        Optional<Movie> movie = movieService.getMovieById(id);
        if (movie.isEmpty()) {
            return ResponseEntity.notFound().build();  // Si no se encuentra la película, devolver 404 Not Found
        }
        return ResponseEntity.ok(movie.get());  // Si la película se encuentra, devolverla con 200 OK
    }

    // Actualizar una película por su ID (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        Optional<Movie> existingMovie = movieService.getMovieById(id);
        if (existingMovie.isEmpty()) {
            return ResponseEntity.notFound().build();  // Si no existe la película, devolver 404 Not Found
        }
        movie.setId(id);  // Asegurar que el ID se mantenga igual al actualizar
        Movie updatedMovie = movieService.saveMovie(movie);
        return ResponseEntity.ok(updatedMovie);  // Devolver la película actualizada con 200 OK
    }

    // Eliminar una película por su ID (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        Optional<Movie> existingMovie = movieService.getMovieById(id);
        if (existingMovie.isEmpty()) {
            return ResponseEntity.notFound().build();  // Si no se encuentra la película, devolver 404 Not Found
        }
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();  // Devolver 204 No Content al eliminar correctamente
    }
}
