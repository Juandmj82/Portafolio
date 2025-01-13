package com.example.calculadora;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Creamos un objeto de la clase Scanner para leer los datos
        Scanner entrada = new Scanner(System.in);

        //Instanciamos la clase Calculadora
        Calculadora calculadora = new Calculadora();

        //Variables
        int num1, num2;
        boolean continuar = true;

        //Menú

        System.out.println("--------------------------------");
        System.out.println(" *Bienvenido a la calculadora* ");
        System.out.println("--------------------------------");

        //bucle para realizar varias operaciones
        while (continuar) {
            //Solicitamos los números al usuario
            System.out.println("Ingrese el primer número: ");
            num1 = entrada.nextInt();

            System.out.println("Ingrese el segundo número: ");
            num2 = entrada.nextInt();

            //Menú de operaciones

            System.out.println("--------------------------------");
            System.out.println("Selecciona una operación: ");
            System.out.println("--------------------------------");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicación");
            System.out.println("4. División");

            //Leemos la opción del usuario

            int opcion = entrada.nextInt();

            //Switch para realizar la operación seleccionada

            switch (opcion) {

                case 1:
                    System.out.println("El resultado de la suma es: " + calculadora.sumar(num1, num2));
                    break;

                case 2:
                    System.out.println("El resultado de la resta es: " + calculadora.restar(num1, num2));
                    break;

                case 3:
                    System.out.println("El resultado de la multiplicación es: " + calculadora.multiplicar(num1, num2));
                    break;

                case 4: //Manejo de excepciones
                    try {
                        System.out.println("El resultado de la división es: " + calculadora.dividir(num1, num2));
                    } catch (ArithmeticException e) {
                        System.out.println("Error:" + e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
            //Preguntamos al usuario si desea realizar otra operación

            System.out.println("\n Desear realizar otra operación? SI (1) NO (2)");
            int respuesta = entrada.nextInt();

            if (respuesta == 2) {
                continuar = false;
                System.out.println("--------------------------------");
                System.out.println("Gracias por usar la calculadora");
                System.out.println("--------------------------------");
            }
        }
        //Cerramos el objeto Scanner
        entrada.close();
    }
}
