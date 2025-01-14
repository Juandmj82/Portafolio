package com.example.dto;

import com.google.gson.annotations.SerializedName;

/*
 Clase DTO de tipo 'record' que representa los datos de una película.
  Utiliza anotaciones de Gson para mapear los nombres de los campos JSON a los nombres de los campos Java.
 */
public record Movie(
        @SerializedName("Title") String titulo,
        @SerializedName("Year") String año,
        @SerializedName("Rated") String clasificacion,
        @SerializedName("Released") String lanzamiento,
        @SerializedName("Runtime") String duracion,
        @SerializedName("Genre") String genero,
        @SerializedName("Director") String director,
        @SerializedName("Plot") String trama
) {}
