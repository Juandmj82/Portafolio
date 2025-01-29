package com.example.gestorTareas.controller;

import com.example.gestorTareas.model.User;
import com.example.gestorTareas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Método para obtener todos los usuarios
    @GetMapping
    public List<User> getAllUsers() { // Cambiado a getAllUsers
        return userService.getAllUsers();
    }

    // Método para obtener un usuario por su ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok) // Devuelve 200 OK si se encuentra
                .orElse(ResponseEntity.notFound().build()); // Devuelve 404 si no se encuentra
    }

    // Método para crear un usuario
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
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