package com.example.spring_mysql_connection.service;

import com.example.spring_mysql_connection.model.Movie;
import com.example.spring_mysql_connection.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    // Obtener todas las películas
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // Guardar una película
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    // Verificar si existe una película por ID
    public boolean existsById(Long id) {
        return movieRepository.existsById(id);
    }

    // Eliminar una película por ID
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    // Obtener una película por ID
    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);  // Usamos findById para obtener el Optional<Movie>
    }
}
