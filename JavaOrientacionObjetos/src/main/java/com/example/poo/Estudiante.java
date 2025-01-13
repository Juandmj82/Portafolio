package com.example.poo;

public class Estudiante  extends Persona{
    //Atributos
    private String matricula, carrera;

    public Estudiante(String nombre, int edad, String matricula, String carrera){
        super(nombre, edad);
        this.matricula = matricula;
        this.carrera = carrera;
    }

    //Métodos

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
}
