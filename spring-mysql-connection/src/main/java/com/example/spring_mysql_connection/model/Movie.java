package com.example.spring_mysql_connection.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "movies")
@Getter  // Genera automáticamente los getters
@Setter  // Genera automáticamente los setters
@NoArgsConstructor  // Constructor vacío
@AllArgsConstructor // Constructor con todos los parámetros
@EqualsAndHashCode  // Genera automáticamente equals y hashCode
@ToString  // Genera automáticamente el método toString
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String director;

    @Column(nullable = false)
    private int releaseYear;
}
