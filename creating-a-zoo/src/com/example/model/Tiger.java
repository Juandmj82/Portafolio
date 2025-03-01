package com.example.model;
import com.example.service.Walk;
import java.io.Serializable;

// Clase que representa un tigre, hereda de Animal e implementa Walk y Serializable
public class Tiger extends Animal implements Walk, Serializable {

    // Propiedades específicas del tigre
    int numberOfStripes; // Número de rayas del tigre
    int speed; // Velocidad del tigre
    int soundLevel; // Nivel de sonido del rugido del tigre

    // Constructor que inicializa el nombre del tigre como "Tiger"
    public Tiger() {
        super("Tiger");
    }

    // Métodos getter y setter para acceder y modificar las propiedades del tigre

    // Obtiene el número de rayas del tigre
    public int getNumberOfStripes() {
        return numberOfStripes;
    }

    // Establece el número de rayas del tigre
    public void setNumberOfStripes(int numberOfStripes) {
        this.numberOfStripes = numberOfStripes;
    }

    // Obtiene la velocidad del tigre
    public int getSpeed() {
        return speed;
    }

    // Establece la velocidad del tigre
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    // Obtiene el nivel de sonido del rugido del tigre
    public int getSoundLevel() {
        return soundLevel;
    }

    // Establece el nivel de sonido del rugido del tigre
    public void setSoundLevel(int soundLevel) {
        this.soundLevel = soundLevel;
    }

    // Sobrescritura del método de la interfaz Eat

    // Método que indica que el tigre ha terminado de comer
    @Override
    public void eatingCompleted() {
        System.out.println("Tiger: I have eaten meat.");
    }

    // Implementación del método de la interfaz Walk

    // Método que indica que el tigre está caminando
    @Override
    public void walking() {
        System.out.println("Tiger: I am moving at the speed " + speed);
    }

    // Método toString para representar el tigre como una cadena de texto
    @Override
    public String toString() {
        return "Tiger{" +
                "numberOfStripes=" + numberOfStripes +
                ", speed=" + speed +
                ", soundLevel=" + soundLevel +
                '}';
    }
}