package com.portafolio.crudproductos.controller;

import com.portafolio.crudproductos.model.Producto;
import com.portafolio.crudproductos.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/productos")  // Todas las rutas en esta clase empiezan con "/productos"
public class ProductoController {

    @Autowired  // Inyecta automáticamente el servicio (Spring se encarga de la instancia)
    private ProductoService productoService;

    // Listar todos los productos
    @GetMapping  // Equivalente a @GetMapping("/productos")
    public String listarProductos(Model model) {
        model.addAttribute("productos", productoService.obtenerTodos());  // Envía la lista de productos a la vista
        return "producto/lista";  // Retorna la vista 'lista.html'
    }

    // Mostrar formulario de registro (solo para ADMIN)
    @PreAuthorize("hasRole('ADMIN')")  // Solo usuarios con rol ADMIN pueden acceder
    @GetMapping("/formulario")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("producto", new Producto());  // Envía un producto vacío al formulario
        return "producto/formulario";
    }

    // Guardar o actualizar un producto
    @PostMapping("/guardar")
    public String guardarProducto(
            @Valid @ModelAttribute Producto producto,  // Valida el objeto Producto según las anotaciones en el modelo
            BindingResult result,  // Contiene los errores de validación
            RedirectAttributes redirectAttributes  // Envía mensajes entre redirecciones
    ) {
        if (result.hasErrors()) {
            // Si hay errores, reenvía los datos al formulario
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.producto", result);
            redirectAttributes.addFlashAttribute("producto", producto);
            redirectAttributes.addFlashAttribute("errorMessage", "Corrige los errores en el formulario.");
            return "redirect:/productos/formulario";
        }

        // Guarda el producto y define si es nuevo o una actualización
        productoService.guardarProducto(producto);
        redirectAttributes.addFlashAttribute("successMessage",
                producto.getId() == null ? "Producto registrado con éxito!" : "Producto actualizado con éxito!");

        return "redirect:/productos";  // Redirige a la lista de productos
    }

    // Editar producto (solo ADMIN)
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/editar/{id}")
    public String editarProducto(@PathVariable Long id, Model model) {
        Producto producto = productoService.obtenerPorId(id);  // Busca el producto por ID
        model.addAttribute("producto", producto);  // Envía el producto a editar al formulario
        return "producto/formulario";
    }

    // Eliminar producto (solo ADMIN)
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        if (productoService.existeProducto(id)) {
            productoService.eliminarProducto(id);
            redirectAttributes.addFlashAttribute("successMessage", "Producto eliminado correctamente.");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "El producto no existe.");
        }
        return "redirect:/productos";
    }
}