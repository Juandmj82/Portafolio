package com.example.musicbox.service;

import com.example.musicbox.model.Cancion;
import com.example.musicbox.model.Cantante;
import com.example.musicbox.model.DatosCancion;
import com.example.musicbox.model.DatosCantante;
import com.example.musicbox.repository.CancionRepository;
import com.example.musicbox.repository.CantanteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class LastFmService extends ConsumoApi {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final CancionRepository cancionRepository;
    private final CantanteRepository cantanteRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Value("${LASTFM_API_KEY}")
    private String apiKey;

    public LastFmService(CancionRepository cancionRepository, CantanteRepository cantanteRepository) {
        this.cancionRepository = cancionRepository;
        this.cantanteRepository = cantanteRepository;
    }

    public DatosCantante obtenerInformacionCantante(String nombreArtista) {
        // Normalizar el nombre del artista: eliminar espacios y convertir a minúsculas
        String nombreNormalizado = nombreArtista.replaceAll("\\s+", "").toLowerCase(Locale.ROOT);

        String url;
        try {
            url = "https://ws.audioscrobbler.com/2.0/?method=artist.getinfo&artist=" +
                    URLEncoder.encode(nombreNormalizado, StandardCharsets.UTF_8.toString()) +
                    "&api_key=" + apiKey + "&format=json";
        } catch (Exception e) {
            throw new RuntimeException("Error al codificar el nombre del artista: " + e.getMessage());
        }

        String json = obtenerDatos(url);

        System.out.println("JSON recibido: " + json);

        try {
            DatosCantante datosCantante = objectMapper.readValue(json, DatosCantante.class);
            System.out.println("Datos recibidos: " + datosCantante);
            return datosCantante;
        } catch (IOException e) {
            throw new RuntimeException("Error al convertir JSON: " + e.getMessage());
        }
    }

    public Cantante convertirAEntidadCantante(DatosCantante datosCantante) {
        Cantante cantante = new Cantante();
        cantante.setNombre(datosCantante.artist().nombre());
        cantante.setUrlBiografia(datosCantante.artist().url());
        System.out.println("Entidad Cantante creada: " + cantante);
        return cantante;
    }

    @Transactional
    public List<Cancion> buscarCancionesPorCantante(String nombreCantante) {
        // Normalizar el nombre del cantante: eliminar espacios y convertir a minúsculas
        String nombreNormalizado = nombreCantante.replaceAll("\\s+", "").toLowerCase(Locale.ROOT);

        String url;
        try {
            url = "http://ws.audioscrobbler.com/2.0/?method=track.search&track=" +
                    URLEncoder.encode(nombreNormalizado, StandardCharsets.UTF_8.toString()) +
                    "&api_key=" + apiKey + "&format=json";
        } catch (Exception e) {
            throw new RuntimeException("Error al codificar el nombre del artista: " + e.getMessage());
        }

        String json = obtenerDatos(url);

        System.out.println("JSON recibido: " + json);

        try {
            DatosCancion datosCancion = objectMapper.readValue(json, DatosCancion.class);
            List<Cancion> canciones = datosCancion.results().trackmatches().track().stream()
                    .map(track -> {
                        Cancion cancion = new Cancion();
                        cancion.setTitulo(track.name().replaceAll("[^a-zA-Z0-9\\s]", "")); // Limpiar el título
                        cancion.setUrl(track.url());
                        cancion.setOyentes(Integer.parseInt(track.listeners())); // Convertir a entero

                        // Buscar el cantante en la base de datos
                        Cantante cantante = cantanteRepository.findByNombre(track.artist().replaceAll("[^a-zA-Z0-9\\s]", "")); // Limpiar el nombre del artista
                        if (cantante == null) {
                            cantante = new Cantante();
                            cantante.setNombre(track.artist().replaceAll("[^a-zA-Z0-9\\s]", "")); // Limpiar el nombre del artista
                            cantante.setUrlBiografia(""); // Establecer una URL vacía si no se encuentra
                            cantante = cantanteRepository.save(cantante);
                        }
                        cancion.setCantante(cantante);
                        cancion.setArtista(cantante.getNombre()); // Establecer el nombre del artista

                        return cancion;
                    })
                    .collect(Collectors.toList());

            // Guardar las canciones en la base de datos
            cancionRepository.saveAll(canciones);

            return canciones;
        } catch (IOException e) {
            throw new RuntimeException("Error al convertir JSON: " + e.getMessage());
        }
    }

    @Transactional
    public Cancion buscarCancionPorNombreYArtista(String nombreCancion, String nombreArtista) {
        // Normalizar el nombre del cantante y la canción: eliminar espacios y convertir a minúsculas
        String nombreCancionNormalizado = nombreCancion.replaceAll("\\s+", "").toLowerCase(Locale.ROOT);
        String nombreArtistaNormalizado = nombreArtista.replaceAll("\\s+", "").toLowerCase(Locale.ROOT);

        String url;
        try {
            url = "http://ws.audioscrobbler.com/2.0/?method=track.search&track=" +
                    URLEncoder.encode(nombreCancionNormalizado, StandardCharsets.UTF_8.toString()) +
                    "&artist=" + URLEncoder.encode(nombreArtistaNormalizado, StandardCharsets.UTF_8.toString()) +
                    "&api_key=" + apiKey + "&format=json";
        } catch (Exception e) {
            throw new RuntimeException("Error al codificar el nombre del artista o la canción: " + e.getMessage());
        }

        String json = obtenerDatos(url);

        System.out.println("JSON recibido: " + json);

        try {
            DatosCancion datosCancion = objectMapper.readValue(json, DatosCancion.class);
            List<Cancion> canciones = datosCancion.results().trackmatches().track().stream()
                    .limit(1) // Limitar a la primera canción encontrada
                    .map(track -> {
                        Cancion cancion = new Cancion();
                        cancion.setTitulo(track.name().replaceAll("[^a-zA-Z0-9\\s]", "")); // Limpiar el título
                        cancion.setUrl(track.url());
                        cancion.setOyentes(Integer.parseInt(track.listeners())); // Convertir a entero

                        // Buscar el cantante en la base de datos
                        Cantante cantante = cantanteRepository.findByNombre(nombreArtistaNormalizado); // Usar el nombre del artista normalizado
                        if (cantante == null) {
                            cantante = new Cantante();
                            cantante.setNombre(nombreArtistaNormalizado); // Usar el nombre del artista normalizado
                            cantante.setUrlBiografia(""); // Establecer una URL vacía si no se encuentra
                            cantante = cantanteRepository.save(cantante);
                        }
                        cancion.setCantante(cantante);
                        cancion.setArtista(cantante.getNombre()); // Establecer el nombre del artista

                        return cancion;
                    })
                    .collect(Collectors.toList());

            // Guardar la primera canción en la base de datos
            if (!canciones.isEmpty()) {
                cancionRepository.save(canciones.get(0));
            }

            // Devolver la primera canción encontrada
            return canciones.isEmpty() ? null : canciones.get(0);
        } catch (IOException e) {
            throw new RuntimeException("Error al convertir JSON: " + e.getMessage());
        }
    }
}