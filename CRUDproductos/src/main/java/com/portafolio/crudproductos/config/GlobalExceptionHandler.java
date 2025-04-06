package com.portafolio.crudproductos.config;

// Importación de la excepción específica que lanza Spring Security cuando se deniega el acceso
import org.springframework.security.access.AccessDeniedException;

// Permite manejar excepciones de forma global para todos los controladores
import org.springframework.web.bind.annotation.ControllerAdvice;

// Indica que este método manejará excepciones específicas
import org.springframework.web.bind.annotation.ExceptionHandler;

// Permite agregar atributos flash a los redireccionamientos (datos que viven por una sola petición)
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice // Anotación que permite manejar excepciones de forma centralizada para todos los controladores
public class GlobalExceptionHandler {

    // Método que se ejecutará automáticamente si se lanza una AccessDeniedException
    @ExceptionHandler(AccessDeniedException.class)
    public String handleAccessDeniedException(AccessDeniedException ex, RedirectAttributes redirectAttributes) {

        // Agrega un mensaje de error temporal (flash) que puede ser mostrado después del redireccionamiento
        redirectAttributes.addFlashAttribute("errorMessage",
                "Acceso denegado: No tienes permisos de administrador para realizar esta acción.");

        // Redirecciona al listado de productos
        return "redirect:/productos";
    }
}