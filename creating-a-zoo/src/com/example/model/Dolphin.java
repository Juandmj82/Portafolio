package com.example.model;
import com.example.service.Swim;
import java.io.Serializable;

// Clase que representa un delfín, hereda de Animal e implementa Swim y Serializable
public class Dolphin extends Animal implements Swim, Serializable {

    // Propiedades específicas del delfín
    String color; // Color del delfín
    int swimmingSpeed; // Velocidad de natación del delfín

    // Constructor que inicializa el nombre del delfín como "Dolphin"
    public Dolphin() {
        super("Dolphin");
    }

    // Métodos getter y setter para acceder y modificar las propiedades del delfín

    // Obtiene el color del delfín
    public String getColor() {
        return color;
    }

    // Establece el color del delfín
    public void setColor(String color) {
        this.color = color;
    }

    // Obtiene la velocidad de natación del delfín
    public int getSwimmingSpeed() {
        return swimmingSpeed;
    }

    // Establece la velocidad de natación del delfín
    public void setSwimmingSpeed(int swimmingSpeed) {
        this.swimmingSpeed = swimmingSpeed;
    }

    // Sobrescritura de los métodos de la interfaz Eat

    // Método que indica que el delfín está comiendo
    @Override
    public void eatingFood() {
        System.out.println("Dolphin: I am eating delicious fish.");
    }

    // Método que indica que el delfín ha terminado de comer
    @Override
    public void eatingCompleted() {
        System.out.println("Dolphin: I have eaten fish.");
    }

    // Implementación del método de la interfaz Swim

    // Método que indica que el delfín está nadando
    @Override
    public void swimming() {
        System.out.println("Dolphin: I am swimming at the speed " + swimmingSpeed);
    }

    // Método toString para representar el delfín como una cadena de texto
    @Override
    public String toString() {
        return "Dolphin{" +
                "color='" + color + '\'' +
                ", swimmingSpeed=" + swimmingSpeed +
                '}';
    }
}