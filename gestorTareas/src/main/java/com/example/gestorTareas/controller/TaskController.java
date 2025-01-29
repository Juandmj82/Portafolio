package com.example.gestorTareas.controller;

import com.example.gestorTareas.exception.ResourceNotFoundException;
import com.example.gestorTareas.model.Task;
import com.example.gestorTareas.model.User;
import com.example.gestorTareas.service.TaskService;
import com.example.gestorTareas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks") // Cambiado a plural
public class TaskController {
    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService; // Inyectar UserService para obtener el usuario

    // Método para obtener todas las tareas
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    // Método para obtener una tarea por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable int id) {
        return taskService.getTaskById(id)
                .map(ResponseEntity::ok) // Devuelve 200 OK si se encuentra
                // Lanza excepción si no se encuentra
                .orElseThrow(() -> new ResourceNotFoundException("Tarea no encontrada con ID: " + id)); // Lanza excepción si no se encuentra
    }

    // Método para crear una tarea
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        // Verifica que el usuario esté establecido
        if (task.getUser() == null || task.getUser().getId() == 0) {
            return ResponseEntity.badRequest().body(null); // Devuelve 400 Bad Request si el usuario no está presente
        }

        // Obtiene el usuario por ID
        User user = userService.getUserById(task.getUser().getId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado")); // Lanza excepción si el usuario no existe
        task.setUser(user); // Establece el usuario en la tarea

        // Guarda la tarea
        Task createdTask = taskService.saveTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }

    // Método para eliminar una tarea por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable int id) {
        if (taskService.getTaskById(id).isPresent()) { // Verifica si la tarea existe
            taskService.deleteTask(id);
            return ResponseEntity.noContent().build(); // Devuelve 204 No Content si se elimina con éxito
        } else {
            return ResponseEntity.notFound().build(); // Devuelve 404 si no se encuentra la tarea
        }
    }
}