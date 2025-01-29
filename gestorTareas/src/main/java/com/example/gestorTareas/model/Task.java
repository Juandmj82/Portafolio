package com.example.gestorTareas.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tareas")
public class Task {
    // Atributos de la clase Task
    @Id // Clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generación automática de la clave primaria
    private int id;

    private String titulo;
    private String descripcion;
    private LocalDate fechaDeVencimiento;

    @Enumerated(EnumType.STRING) // Almacena el enum como cadena para que sea más legible
    private Prioridad prioridad;

    private boolean estado;

    @ManyToOne // Relación muchos a uno con User
    @JoinColumn(name = "user_id", nullable = false) // Relación con User a través de user_id
    @JsonBackReference // Evita la recursión infinita en la serialización JSON
    private User user; // Relación con User

    // Usamos un enum para definir la prioridad de la tarea
    public enum Prioridad {
        ALTA, MEDIA, BAJA
    }

    // Constructor por defecto necesario en JPA
    public Task() {}

    // Constructor con parámetros
    public Task(String titulo, String descripcion, LocalDate fechaDeVencimiento, Prioridad prioridad, boolean estado, User user) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaDeVencimiento = fechaDeVencimiento;
        this.prioridad = prioridad;
        this.estado = estado;
        this.user = user; // Establece el usuario asociado
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaDeVencimiento() {
        return fechaDeVencimiento;
    }

    public void setFechaDeVencimiento(LocalDate fechaDeVencimiento) {
        this.fechaDeVencimiento = fechaDeVencimiento;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public User getUser() {
        return user; // Devuelve el usuario asociado
    }

    public void setUser(User user) {
        this.user = user; // Establece el usuario asociado
    }

    // Método toString
    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaDeVencimiento=" + fechaDeVencimiento +
                ", prioridad=" + prioridad +
                ", estado=" + estado +
                ", user=" + (user != null ? user.getNombre() : "N/A") + // Muestra el nombre del usuario si está presente
                '}';
    }
}