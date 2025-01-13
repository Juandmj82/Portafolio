package com.example.calculadora;


public class Calculadora {

    //Método para sumar dos números
    public int sumar (int num1, int num2){
        return num1 + num2;
    }
    //método para restar dos números
    public int restar (int num1, int num2){
        return num1 - num2;
    }
    //método para multiplicar dos números
    public int multiplicar (int num1, int num2){
        return num1 * num2;
    }

    //método para dividir dos números
    public double dividir (int num1, int num2){
        //Validamos que el segundo número no sea cero
        if(num2 == 0){
            //Lanzamos una excepción
            throw new ArithmeticException("No se puede dividir por cero");
        }
        return (double) num1 / num2;
    }
}
