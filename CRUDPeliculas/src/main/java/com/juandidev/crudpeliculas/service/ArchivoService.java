package com.juandidev.crudpeliculas.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ArchivoService implements IArchivoService {

    public void guardar(String archivo, InputStream bytes) {
        try {
            eliminar(archivo);
            Files.copy(bytes, resolvePath(archivo));
        } catch (IOException e) {
            // Manejo de excepciones más robusto
            throw new RuntimeException("Error al guardar el archivo: " + archivo, e);
        }
    }

    public ResponseEntity<Resource> get(String archivo) {
        Resource resource;
        try {
            resource = new UrlResource(resolvePath(archivo).toUri());
            if (!resource.exists() || !resource.isReadable()) {
                return ResponseEntity.notFound().build();
            }
        } catch (MalformedURLException e) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    public void eliminar(String archivo) {
        try {
            Files.deleteIfExists(resolvePath(archivo));
        } catch (IOException e) {
            throw new RuntimeException("Error al eliminar el archivo: " + archivo, e);
        }
    }

    private Path resolvePath(String archivo) {
        return Paths.get("archivos").resolve(archivo).toAbsolutePath();
    }
}
