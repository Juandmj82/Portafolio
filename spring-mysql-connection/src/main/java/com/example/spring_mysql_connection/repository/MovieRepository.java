package com.example.spring_mysql_connection.repository;
import com.example.spring_mysql_connection.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository; // Importa la interfaz JpaRepository de Spring Data JPA
import org.springframework.stereotype.Repository; // Importa la anotación @Repository de Spring

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
