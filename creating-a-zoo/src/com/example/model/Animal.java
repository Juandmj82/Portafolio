package com.example.model;
import com.example.service.Eat;

// Clase abstracta que representa un animal genérico
public abstract class Animal implements Eat {

    // Propiedades básicas de un animal
    private String nameOfAnimal; // Nombre del animal
    private int weight; // Peso del animal
    private int height; // Altura del animal
    private int age; // Edad del animal

    // Constructor por defecto que inicializa el nombre del animal como "Unknown Animal"
    public Animal() {
        nameOfAnimal = "Unknown Animal";
    }

    // Constructor que permite establecer el nombre del animal
    public Animal(String nameOfAnimal) {
        this.nameOfAnimal = nameOfAnimal;
    }

    // Métodos getter y setter para acceder y modificar las propiedades del animal

    // Obtiene el nombre del animal
    public String getNameOfAnimal() {
        return nameOfAnimal;
    }

    // Establece el nombre del animal
    public void setNameOfAnimal(String nameOfAnimal) {
        this.nameOfAnimal = nameOfAnimal;
    }

    // Obtiene el peso del animal
    public int getWeight() {
        return weight;
    }

    // Establece el peso del animal
    public void setWeight(int weight) {
        this.weight = weight;
    }

    // Obtiene la altura del animal
    public int getHeight() {
        return height;
    }

    // Establece la altura del animal
    public void setHeight(int height) {
        this.height = height;
    }

    // Obtiene la edad del animal
    public int getAge() {
        return age;
    }

    // Establece la edad del animal
    public void setAge(int age) {
        this.age = age;
    }

    // Implementación de los métodos de la interfaz Eat

    // Método que indica que el animal está comiendo
    @Override
    public void eatingFood() {
        System.out.println("The animal: " + nameOfAnimal + " is eating.");
    }

    // Método que indica que el animal ha terminado de comer
    @Override
    public void eatingCompleted() {
        System.out.println("The animal: " + nameOfAnimal + " has finished eating.");
    }
}