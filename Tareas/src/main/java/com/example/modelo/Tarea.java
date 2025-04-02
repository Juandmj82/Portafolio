package com.example.modelo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //Indica que la clase es una entidad
@Data //Genera los getters y setters
@NoArgsConstructor //Genera un constructor vacio
@AllArgsConstructor // Genera un constructor con todos los atributos de la clase

public class Tarea {
    @Id //Indica que el atributo es una llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Genera un valor automatico
    private Integer idTarea;
    private String nombreTarea;
    private String responsable;
    private String estado;



}
