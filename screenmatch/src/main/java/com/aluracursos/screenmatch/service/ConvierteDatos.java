package com.aluracursos.screenmatch.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvierteDatos implements  IConvierteDatos {
    // crear instancia de un object mapper para poder leer los valores
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {

        //va a retornar un objeto de tipo objectMapper.readValue ,
        // va a leer y a transformar el json en la clase que vamos a pasarle
        //el método exije que se maneje una excepción, por lo que se usa un try catch
        try {
            return objectMapper.readValue(json, clase );
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
