package com.juandidev.crudpeliculas.service;

import org.springframework.core.io.Resource; // Asegúrate de que esta línea esté presente
import org.springframework.http.ResponseEntity;

import java.io.InputStream;

public interface IArchivoService {

    void guardar(String archivo, InputStream bytes);
    void eliminar(String archivo);
    ResponseEntity<Resource> get(String archivo);
}
