package com.portafolio.crudproductos.controller;

import com.portafolio.crudproductos.model.Producto;
import com.portafolio.crudproductos.repository.ProductoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping
    public String listarProductos(Model model) {
        model.addAttribute("productos", productoRepository.findAll());
        return "producto/lista";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/formulario")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("producto", new Producto());
        return "producto/formulario";
    }

    @PostMapping("/guardar")
    public String guardarProducto(@Valid @ModelAttribute Producto producto,
                                  BindingResult result,
                                  RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            // Mantén los datos del formulario al recargar
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.producto", result);
            redirectAttributes.addFlashAttribute("producto", producto);

            // Mensaje de error general
            redirectAttributes.addFlashAttribute("errorMessage", "Corrige los errores en el formulario.");

            return "redirect:/productos/formulario";
        }

        boolean esNuevo = producto.getId() == null;
        productoRepository.save(producto);

        redirectAttributes.addFlashAttribute("successMessage",
                esNuevo ? "Producto registrado con éxito!" : "Producto actualizado con éxito!");

        return "redirect:/productos";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/editar/{id}")
    public String editarProducto(@PathVariable Long id, Model model) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con ID: " + id));
        model.addAttribute("producto", producto);
        return "producto/formulario";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("successMessage", "Producto eliminado correctamente.");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "El producto no existe.");
        }
        return "redirect:/productos";
    }
}
