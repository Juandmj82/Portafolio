package com.aluracursos.screenmatch.service;

public interface IConvierteDatos {
    // creamos un método usando tipos de datos genéricos, porque
    // no sabemos el tipo de dato que vamos a recibir
    <T> T obtenerDatos(String json, Class<T> clase);

}
