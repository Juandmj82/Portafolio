package com.example.musicbox.principal;

import com.example.musicbox.model.Cancion;
import com.example.musicbox.model.Cantante;
import com.example.musicbox.model.DatosCantante;
import com.example.musicbox.repository.CancionRepository;
import com.example.musicbox.repository.CantanteRepository;
import com.example.musicbox.service.LastFmService;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Menu {

    private Scanner teclado = new Scanner(System.in);
    private LastFmService lastFmService;
    private CantanteRepository cantanteRepository;
    private CancionRepository cancionRepository;

    public Menu(CantanteRepository cantanteRepository, CancionRepository cancionRepository, LastFmService lastFmService) {
        this.cantanteRepository = cantanteRepository;
        this.cancionRepository = cancionRepository;
        this.lastFmService = lastFmService;
    }

    public void muestraElMenu() {
        var opcion = -1;
        System.out.println("***************************");
        System.out.println("Bienvenido a MusicBox");
        System.out.println("***************************");

        while (opcion != 0) {
            var menu = """
                    1 - Buscar cantante
                    2 - Buscar canción por nombre y artista
                    3 - Mostrar todos los cantantes
                    4 - Mostrar todas las canciones
                    0 - Salir
                    """;
            System.out.println(menu);

            // Leer la opción como cadena y convertirla a entero
            String input = teclado.nextLine();
            try {
                opcion = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingresa un número válido.");
                continue;
            }

            switch (opcion) {
                case 1:
                    buscarCantante();
                    break;
                case 2:
                    buscarCancionPorNombreYArtista();
                    break;
                case 3:
                    mostrarTodosLosCantantes();
                    break;
                case 4:
                    mostrarTodasLasCanciones();
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private void buscarCantante() {
        System.out.println("Escribe el nombre del cantante que deseas buscar");
        var nombreCantante = teclado.nextLine();
        DatosCantante datosCantante = lastFmService.obtenerInformacionCantante(nombreCantante);
        Cantante cantante = lastFmService.convertirAEntidadCantante(datosCantante);
        cantanteRepository.save(cantante);
        System.out.println("Cantante guardado: " + cantante.getNombre());
    }

    private void buscarCancionPorNombreYArtista() {
        System.out.println("Escribe el nombre de la canción: ");
        String nombreCancion = teclado.nextLine();
        System.out.println("Escribe el nombre del artista: ");
        String nombreArtista = teclado.nextLine();

        // Normalizar el nombre del artista
        String nombreArtistaNormalizado = nombreArtista.replaceAll("\\s+", "").toLowerCase(Locale.ROOT);

        // Buscar el cantante en la base de datos
        Cantante cantante = cantanteRepository.findByNombre(nombreArtistaNormalizado);
        if (cantante == null) {
            // Si el cantante no existe, crear uno nuevo
            cantante = new Cantante();
            cantante.setNombre(nombreArtistaNormalizado);
            cantante.setUrlBiografia(""); // Establecer una URL vacía si no se encuentra
            cantante = cantanteRepository.save(cantante);
        }

        Cancion cancion = lastFmService.buscarCancionPorNombreYArtista(nombreCancion, nombreArtista);
        if (cancion != null) {
            cancion.setCantante(cantante); // Asociar la canción con el cantante
            cancionRepository.save(cancion); // Guardar la canción en la base de datos
            System.out.println("Canción encontrada: " + cancion.getTitulo());
            System.out.println("Artista: " + cancion.getCantante().getNombre());
            System.out.println("URL: " + cancion.getUrl());
            System.out.println("Oyentes: " + cancion.getOyentes());
        } else {
            System.out.println("Canción no encontrada");
        }
    }

    private void mostrarTodosLosCantantes() {
        List<Cantante> cantantes = cantanteRepository.findAll();
        cantantes.forEach(c -> System.out.println(c.getNombre()));
    }

    private void mostrarTodasLasCanciones() {
        List<Cancion> canciones = cancionRepository.findAll();
        canciones.forEach(c -> System.out.println(c.getTitulo()));
    }
}