package com.example.gestorTareas.service;

import com.example.gestorTareas.model.Task;
import com.example.gestorTareas.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    // Método para guardar o actualizar una tarea en la base de datos
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    // Método para obtener una tarea por su ID
    public Optional<Task> getTaskById(int id) {
        return taskRepository.findById(id); // Devuelve un Optional<Task>
    }

    // Método para obtener todas las tareas
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Método para eliminar una tarea por su ID
    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }
}