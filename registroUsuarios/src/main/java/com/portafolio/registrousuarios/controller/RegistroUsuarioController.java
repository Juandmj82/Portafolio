package com.portafolio.registrousuarios.controller;

import com.portafolio.registrousuarios.repository.RegistroUsuarioRepository;
import com.portafolio.registrousuarios.model.Genero;
import com.portafolio.registrousuarios.model.RegistroUsuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegistroUsuarioController {

    @Autowired
    private RegistroUsuarioRepository usuarioRepository;

    @PostMapping("/registro")
    public String procesarFormulario(@Valid @ModelAttribute("usuario") RegistroUsuario usuario,
                                     BindingResult bindingResult,
                                     @RequestParam("confirmarContrasena") String confirmarContrasena,
                                     RedirectAttributes redirectAttributes,
                                     Model model) {
        if (bindingResult.hasErrors()) {
            System.out.println("Errores de validación encontrados.");
            return "registro";
        }

        // Validar que las contraseñas coincidan
        if (!usuario.getContrasena().equals(confirmarContrasena)) {
            model.addAttribute("errorContrasena", "Las contraseñas no coinciden");
            return "registro";
        }

        // Guardar el usuario en la base de datos
        usuarioRepository.save(usuario);

        // ✅ Se añade correctamente el atributo flash para la alerta de éxito
        redirectAttributes.addFlashAttribute("registroExitoso", true);
        System.out.println("Atributo flash 'registroExitoso' añadido: true");

        return "redirect:/registro"; // Redirige para evitar reenvío del formulario
    }


    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model){
        // Verificar si el atributo flash 'registroExitoso' está presente
        Boolean registroExitoso = (Boolean) model.asMap().get("registroExitoso");
        if (registroExitoso != null) {
            model.addAttribute("registroExitoso", registroExitoso);
            System.out.println("Valor de 'registroExitoso' en /registro: " + registroExitoso);
        } else {
            System.out.println("No se encontró el atributo flash 'registroExitoso'.");
        }

        model.addAttribute("usuario", new RegistroUsuario());
        model.addAttribute("generos", Genero.values());
        return "registro";
    }

    @GetMapping("/usuarios")
    public String listarUsuarios(Model model) {
        // Recuperar el atributo flash 'actualizacionExitosa'
        Boolean actualizacionExitosa = (Boolean) model.asMap().get("actualizacionExitosa");
        if (actualizacionExitosa != null) {
            model.addAttribute("actualizacionExitosa", actualizacionExitosa);
            System.out.println("Valor de 'actualizacionExitosa' en /usuarios: " + actualizacionExitosa);
        }

        // Agregar la lista de usuarios al modelo
        model.addAttribute("usuarios", usuarioRepository.findAll());
        return "listar-usuarios";
    }

    //método para editar usuario
    @GetMapping("/editar-usuario/{id}")
    public String editarUsuario(@PathVariable Long id, Model model) {
        RegistroUsuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado con id: " + id));
        model.addAttribute("usuario", usuario);
        return "editar-usuario";  // La vista de edición
    }

    @PostMapping("/editar-usuario/{id}")
    public String actualizarusuario(@PathVariable Long id,
                                    @Valid @ModelAttribute("usuario") RegistroUsuario usuario,
                                    BindingResult bindingResult,
                                    @RequestParam("confirmarContrasena") String confirmarContrasena,
                                    RedirectAttributes redirectAttributes,
                                    Model model) { // ✅ Agregado

        if (bindingResult.hasErrors()) {
            return "editar-usuario"; // Regresa a la vista de edición si hay errores
        }

        // ✅ Validar que las contraseñas coincidan antes de actualizar
        if (!usuario.getContrasena().equals(confirmarContrasena)) {
            model.addAttribute("errorContrasena", "Las contraseñas no coinciden");
            return "editar-usuario"; // Regresa al formulario con el mensaje de error
        }

        usuario.setId(id); // Asegura que el ID no se pierda
        usuarioRepository.save(usuario); // Guarda los cambios

        // ✅ Añadir el atributo flash para indicar que la actualización fue exitosa
        redirectAttributes.addFlashAttribute("actualizacionExitosa", true);
        System.out.println("Atributo flash 'actualizacionExitosa' añadido: true");

        return "redirect:/usuarios"; // Redirige a la lista de usuarios
    }


    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        // Buscar el usuario por ID
        RegistroUsuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado con id: " + id));

        // Eliminar el usuario
        usuarioRepository.delete(usuario);

        // Añadir un atributo flash para indicar que la eliminación fue exitosa
        redirectAttributes.addFlashAttribute("eliminacionExitosa", true);
        System.out.println("Atributo flash 'eliminacionExitosa' añadido: true");

        return "redirect:/usuarios"; // Redirigir a la lista de usuarios
    }
}
