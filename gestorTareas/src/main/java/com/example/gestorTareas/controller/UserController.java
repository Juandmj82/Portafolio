package com.example.gestorTareas.controller;

import com.example.gestorTareas.exception.ConflictException;
import com.example.gestorTareas.exception.ResourceNotFoundException;
import com.example.gestorTareas.model.User;
import com.example.gestorTareas.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users") // Mapeo de la ruta base para los usuarios
public class UserController {

    @Autowired
    private UserService userService; // Inyección del servicio de usuario

    // Método para obtener todos los usuarios
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers(); // Devuelve la lista de todos los usuarios
    }

    // Método para obtener un usuario por su ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok) // Devuelve 200 OK si se encuentra
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con ID: " + id)); // Lanza excepción si no se encuentra
    }

    // Método para crear un nuevo usuario
    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        // Verifica si el usuario ya existe
        if (userService.getUserByEmail(user.getEmail()).isPresent()) {
            throw new ConflictException("El usuario con el email " + user.getEmail() + " ya existe."); // Lanza excepción si el usuario ya existe
        }

        // Guarda el nuevo usuario
        User createdUser = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser); // Devuelve 201 Created con el usuario creado
    }

    // Método para eliminar un usuario por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        if (userService.getUserById(id).isPresent()) { // Verifica si el usuario existe
            userService.deleteUser(id);
            return ResponseEntity.noContent().build(); // Devuelve 204 No Content si se elimina con éxito
        } else {
            return ResponseEntity.notFound().build(); // Devuelve 404 si no se encuentra el usuario
        }
    }
}