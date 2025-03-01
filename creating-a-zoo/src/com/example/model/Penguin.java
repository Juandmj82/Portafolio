package com.example.model;
import com.example.service.Swim;
import com.example.service.Walk;
import java.io.Serializable;

// Clase que representa un pingüino, hereda de Animal e implementa Walk, Swim y Serializable
public class Penguin extends Animal implements Walk, Swim, Serializable {

    // Propiedades específicas del pingüino
    boolean isSwimming; // Indica si el pingüino está nadando
    int walkSpeed; // Velocidad de caminata del pingüino
    int swimSpeed; // Velocidad de natación del pingüino

    // Métodos getter y setter para acceder y modificar las propiedades del pingüino

    // Obtiene si el pingüino está nadando
    public boolean isSwimming() {
        return isSwimming;
    }

    // Establece si el pingüino está nadando
    public void setSwimming(boolean swimming) {
        isSwimming = swimming;
    }

    // Obtiene la velocidad de caminata del pingüino
    public int getWalkSpeed() {
        return walkSpeed;
    }

    // Establece la velocidad de caminata del pingüino
    public void setWalkSpeed(int walkSpeed) {
        this.walkSpeed = walkSpeed;
    }

    // Obtiene la velocidad de natación del pingüino
    public int getSwimSpeed() {
        return swimSpeed;
    }

    // Establece la velocidad de natación del pingüino
    public void setSwimSpeed(int swimSpeed) {
        this.swimSpeed = swimSpeed;
    }

    // Constructor que inicializa el nombre del pingüino como "Penguin"
    public Penguin() {
        super("Penguin");
    }

    // Sobrescritura de los métodos de la interfaz Eat

    // Método que indica que el pingüino está comiendo
    @Override
    public void eatingFood() {
        System.out.println("Penguin: I am eating delicious fish.");
    }

    // Método que indica que el pingüino ha terminado de comer
    @Override
    public void eatingCompleted() {
        System.out.println("Penguin: I have eaten fish.");
    }

    // Implementación del método de la interfaz Swim

    // Método que indica que el pingüino está nadando
    @Override
    public void swimming() {
        System.out.println("Penguin: I am swimming at the speed " + swimSpeed + " nautical miles per hour");
    }

    // Implementación del método de la interfaz Walk

    // Método que indica que el pingüino está caminando
    @Override
    public void walking() {
        System.out.println("Penguin: I am walking at the speed " + walkSpeed + " mph");
    }

    // Método toString para representar el pingüino como una cadena de texto
    @Override
    public String toString() {
        return "Penguin{" +
                "isSwimming=" + isSwimming +
                ", walkSpeed=" + walkSpeed +
                ", swimSpeed=" + swimSpeed +
                '}';
    }
}