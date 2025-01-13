package com.example.poo;

public class Profesor extends Persona {

    private String departamento;
    private Double salario;

    public Profesor(String nombre, int edad, String departamento, Double salario){
        super(nombre, edad);
        this.departamento = departamento;
        this.salario = salario;
    }

    //Métodos


    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}
