package com.example.gestorTareas.service;

import com.example.gestorTareas.model.User;
import com.example.gestorTareas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Método para guardar o actualizar un usuario en la base de datos
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Método para obtener un usuario por su ID
    public Optional<User> getUserById(int id) {
        return userRepository.findById(id); // Devuelve un Optional
    }

    // Método para obtener un usuario por su nombre
    //usamos optional para evitar nullpointerexception
    public Optional<User> getUserByName(String name) {
        return Optional.ofNullable(userRepository.findByNombre(name));
    }

    // Método para obtener todos los usuarios
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Método para eliminar un usuario por su ID
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}