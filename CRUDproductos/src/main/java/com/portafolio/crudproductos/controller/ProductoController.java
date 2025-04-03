package com.portafolio.crudproductos.controller;

import com.portafolio.crudproductos.model.Producto;
import com.portafolio.crudproductos.repository.ProductoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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

    /**
     * Muestra la lista de productos en la vista.
     */
    @GetMapping
    public String listarProductos(Model model) {
        model.addAttribute("productos", productoRepository.findAll());
        return "producto/lista";
    }

    /**
     * Muestra el formulario de registro de productos.
     */
    @GetMapping("/formulario")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("producto", new Producto());
        return "producto/formulario";
    }

    /**
     * Guarda o actualiza un producto en la base de datos.
     * Valida el formulario y maneja los errores antes de persistir la información.
     */
    @PostMapping("/guardar")
    public String guardarProducto(@Valid @ModelAttribute Producto producto, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("errorMessage", "Corrige los errores en el formulario.");

            // Capturar los campos con errores para resaltarlos en la vista
            List<String> errorFields = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getField)
                    .collect(Collectors.toList());

            redirectAttributes.addFlashAttribute("errorFields", errorFields);
            return "redirect:/productos/formulario";
        }

        // Determinar si el producto es nuevo o una actualización
        boolean esNuevo = producto.getId() == null || !productoRepository.existsById(producto.getId());

        productoRepository.save(producto);

        // Mensaje de éxito según la acción realizada
        redirectAttributes.addFlashAttribute("successMessage", esNuevo ? "Producto registrado con éxito!" : "Producto actualizado con éxito!");

        return "redirect:/productos";
    }

    /**
     * Carga un producto existente en el formulario para su edición.
     */
    @GetMapping("/editar/{id}")
    public String editarProducto(@PathVariable Long id, Model model) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con ID: " + id));

        model.addAttribute("producto", producto);
        return "producto/formulario";
    }

    /**
     * Elimina un producto por su ID y redirige a la lista de productos.
     */
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
