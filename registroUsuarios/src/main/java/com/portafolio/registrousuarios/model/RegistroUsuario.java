package com.portafolio.registrousuarios.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
@Table(name = "usuarios")
public class RegistroUsuario {
    // Atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "El primer nombre no puede estar vacío")
    @Size(min = 3, max = 20, message = "El primer nombre debe tener entre 3 y 20 caracteres")
    private String primerNombre;

    @Size(max = 20, message = "El segundo nombre no puede tener más de 20 caracteres")
    private String segundoNombre;

    @NotBlank(message = "El apellido no puede estar vacío")
    @Size(min = 3, max = 50, message = "El apellido debe tener entre 3 y 50 caracteres")
    private String apellidos;

    @Enumerated(EnumType.STRING)//guardamos el género como String de lo contrario guarda numeros
    @NotNull(message = "El género es obligatorio")
    private  Genero genero; //usamos enum porque solo hay 3 opciones

    @NotBlank(message = "La nacionalidad no puede estar vacía")
    private String nacionalidad;

    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @Past(message = "La fecha de nacimiento debe ser una fecha pasada")
    private LocalDate fechaNacimiento;

    @NotBlank(message = "El correo no puede estar vacío")
    @Email(message = "El correo debe tener un formato válido")
    private String correo;

    @NotBlank(message = "La contraseña no puede estar vacía")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    private String contrasena;


    //Constructor

    public RegistroUsuario(String primerNombre, String segundoNombre, String apellidos, Genero genero, String nacionalidad, LocalDate fechaNacimiento, String correo, String contrasena) {
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.apellidos = apellidos;
        this.genero = genero;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    // Constructor vacío que permite crear un objeto sin inicializar los atributos
    public RegistroUsuario() {
    }


    // Getters y setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
