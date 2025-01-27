package com.example.musicbox.service;

public interface IConvierteDatos {
    // Método que convierte un objeto a un String en formato JSON
    //usamos tipos de datos genéricos, porque no sabemos el tipo de dato que vamos a recibir
    <T> T obtenerDatos(String json, Class<T> clase);

}
