package com.portafolio.crudproductos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity // Indica que esta clase es una entidad JPA y se mapeará a una tabla en la base de datos
public class Producto {
    @Id // Define el campo como clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Genera el valor automáticamente (autoincremental en BD)
    private Long id;

    @NotBlank(message = "El nombre del producto no puede estar vacío") // No permite valores vacíos ni solo espacios
    @Size(min = 3, max = 20, message = "Mínimo 3 caracteres, máximo 20") // Define la longitud permitida
    @Column(nullable = false) // No permite valores nulos en la base de datos
    private String name;

    @Size(max = 255, message = "Máximo 255 caracteres") // Restringe la longitud máxima de la descripción
    private String descripcion;

    @NotNull(message = "Debe ingresar el precio") // No permite valores nulos
    @Positive(message = "El precio debe ser mayor a 0") // Asegura que el precio sea positivo
    @Column(nullable = false) // No permite valores nulos en la BD
    private double precio;

    @NotNull(message = "El stock no puede ser nulo") // No permite valores nulos
    @Min(value = 0, message = "El stock no puede ser negativo") // Asegura que el stock no sea negativo
    @Column(nullable = false) // No permite valores nulos en la BD
    private int stock;

    // Constructor con parámetros para inicializar un producto con valores específicos
    public Producto(Long id, String name, String descripcion, double precio, int stock) {
        this.id = id;
        this.name = name;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

    // Constructor sin parámetros requerido por JPA
    public Producto() {}

    // Getters y Setters para acceder y modificar los atributos de la clase
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}