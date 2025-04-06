package com.portafolio.crudproductos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  // Indica que esta clase es un controlador de Spring MVC (maneja peticiones web)
public class HomeController {

    @GetMapping("/")  // Mapea la URL raíz ("/") a este método
    public String mostrarInicio() {
        return "inicio";  // Retorna la vista 'inicio.html' (ubicada en /templates/)
    }
}