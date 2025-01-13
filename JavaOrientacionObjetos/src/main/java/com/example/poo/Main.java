package com.example.poo;

public class Main {
    public static void main(String[] args) {
        //Instanciamos un objeto de la clase Estudiante
        Estudiante  estudiante = new Estudiante("Juan Diego", 19,"12345", "Ingeniería de Sistemas");
        //Instanciamos un objeto de la clase Profesor
        Profesor profesor = new Profesor("María", 35, "Ingeniería de Sistemas", 2000.0);

        //Mostramos los datos del estudiante
       mostrarInformacion(estudiante);
        //Mostramos los datos del profesor
        mostrarInformacion(profesor);


    }
    //Método para mostrar la información de una persona
    public static void mostrarInformacion(Persona persona){
        System.out.println("Nombre: " + persona.getNombre());
        System.out.println("Edad: " + persona.getEdad());

        //Verificamos si la persona es un estudiante o un profesor
        if(persona instanceof Estudiante){
            Estudiante estudiante = (Estudiante)persona;
            System.out.println("Matrícula : " + estudiante.getMatricula());
            System.out.println("Carrera : " + estudiante.getCarrera());
        }else if(persona instanceof Profesor){
            Profesor profesor = (Profesor)persona;
            System.out.println("Departamento : " + profesor.getDepartamento());
            System.out.println("Salario : " + profesor.getSalario());

        }

        System.out.println("____________________________________________");

    }
}
