package com.example.pincipal;

import com.example.model.Tiger;
import com.example.model.Dolphin;
import com.example.model.Penguin;
import com.example.model.Animal;

import java.util.Scanner;
import java.io.*;

// Clase principal que contiene el método main y gestiona la interacción con el usuario
public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in); // Scanner para leer la entrada del usuario
        int continueOuterLoop = 1; // Variable para controlar el bucle principal
        int continueInnerLoop = 1; // Variable para controlar el bucle interno
        int menuChoice = 1; // Variable para almacenar la elección del usuario

        // Creación de objetos para cada animal
        Tiger tigerObject = new Tiger();
        Dolphin dolphinObject = new Dolphin();
        Penguin penguinObject = new Penguin();

        // Bucle principal del menú del zoológico
        do {
            switch (animalChoiceMenu(keyboard)) {
                case 1: // Opción para el tigre
                    do {
                        System.out.println("The animal which is chosen is : " + tigerObject.getNameOfAnimal());
                        menuChoice = animalDetailsManipulationMenu(keyboard, tigerObject);
                        switch (menuChoice) {
                            case 1: // Establecer propiedades del tigre
                                System.out.println("Enter the number of Stripes:");
                                tigerObject.setNumberOfStripes(keyboard.nextInt());
                                System.out.println("Enter speed:");
                                tigerObject.setSpeed(keyboard.nextInt());
                                System.out.println("Enter decibel of roar:");
                                tigerObject.setSoundLevel(keyboard.nextInt());
                                break;
                            case 2: // Mostrar propiedades del tigre
                                System.out.println("The characteristics of the " + tigerObject.getNameOfAnimal() + ":");
                                System.out.println("Age: " + tigerObject.getAge());
                                System.out.println("Height: " + tigerObject.getHeight());
                                System.out.println("Weight: " + tigerObject.getWeight());
                                System.out.println("Number of stripes: " + tigerObject.getNumberOfStripes());
                                System.out.println("Speed: " + tigerObject.getSpeed());
                                System.out.println("Sound level of roar: " + tigerObject.getSoundLevel());
                                break;
                            case 3: // Mostrar movimiento del tigre
                                tigerObject.walking();
                                break;
                            case 4: // Mostrar que el tigre está comiendo
                                tigerObject.eatingFood();
                                tigerObject.eatingCompleted();
                                break;
                            default:
                                System.out.println("Not supported");
                        }
                        System.out.println("Continue with this animal ? (Enter 1 for yes/ 2 for no):");
                        continueInnerLoop = keyboard.nextInt();
                    } while (continueInnerLoop == 1);
                    break;
                case 2: // Opción para el delfín
                    do {
                        System.out.println("The animal which is chosen is : " + dolphinObject.getNameOfAnimal());
                        menuChoice = animalDetailsManipulationMenu(keyboard, dolphinObject);
                        switch (menuChoice) {
                            case 1: // Establecer propiedades del delfín
                                keyboard.nextLine();
                                System.out.println("Enter the color of the dolphin:");
                                dolphinObject.setColor(keyboard.nextLine());
                                System.out.println("Enter the speed of the dolphin:");
                                dolphinObject.setSwimmingSpeed(keyboard.nextInt());
                                break;

                            case 2: // Mostrar propiedades del delfín
                                System.out.println("The characteristics of the " + dolphinObject.getNameOfAnimal() + ":");
                                System.out.println("Age: " + dolphinObject.getAge());
                                System.out.println("Height: " + dolphinObject.getHeight());
                                System.out.println("Weight: " + dolphinObject.getWeight());
                                System.out.println("Color:" + dolphinObject.getColor());
                                System.out.println("Speed:" + dolphinObject.getSwimmingSpeed());
                                break;
                            case 3: // Mostrar movimiento del delfín
                                dolphinObject.swimming();
                                break;
                            case 4: // Mostrar que el delfín está comiendo
                                dolphinObject.eatingFood();
                                dolphinObject.eatingCompleted();
                                break;
                            default:
                                System.out.println("Not supported");
                        }
                        System.out.println("Continue with this animal ? (Enter 1 for yes/ 2 for no):");
                        continueInnerLoop = keyboard.nextInt();
                    } while (continueInnerLoop == 1);
                    break;

                case 3: // Opción para el pingüino
                    do {
                        System.out.println("The animal which is chosen is : " + penguinObject.getNameOfAnimal());
                        menuChoice = animalDetailsManipulationMenu(keyboard, penguinObject);
                        switch (menuChoice) {
                            case 1: // Establecer propiedades del pingüino
                                System.out.println("Is the dolphin swimming (true/false):");
                                penguinObject.setSwimming(keyboard.nextBoolean());

                                System.out.println("Enter the walk speed of the penguin:");
                                penguinObject.setWalkSpeed(keyboard.nextInt());

                                System.out.println("Enter the swim speed of the penguin:");
                                penguinObject.setSwimSpeed(keyboard.nextInt());
                                break;

                            case 2: // Mostrar propiedades del pingüino
                                System.out.println("The characteristics of the " + penguinObject.getNameOfAnimal() + ":");
                                System.out.println("Age: " + penguinObject.getAge());
                                System.out.println("Height: " + penguinObject.getHeight());
                                System.out.println("Weight: " + penguinObject.getWeight());
                                System.out.println("Walking Speed:" + penguinObject.getWalkSpeed());
                                System.out.println("Swimming Speed:" + penguinObject.getSwimSpeed());
                                break;
                            case 3: // Mostrar movimiento del pingüino
                                if (penguinObject.isSwimming()) {
                                    penguinObject.swimming();
                                } else {
                                    penguinObject.walking();
                                }
                                break;
                            case 4: // Mostrar que el pingüino está comiendo
                                penguinObject.eatingFood();
                                penguinObject.eatingCompleted();
                                break;
                            default:
                                System.out.println("Not supported");

                        }
                        System.out.println("Continue with this animal ? (Enter 1 for yes/ 2 for no):");
                        continueInnerLoop = keyboard.nextInt();
                    } while (continueInnerLoop == 1);
                    break;

                case 4: // Guardar animales en archivos
                    writeObjectsToFile(tigerObject, penguinObject, dolphinObject);
                    break;

                case 5: // Cargar animales desde archivos
                    readObjectsFromFile();
                    break;

                default:
                    System.out.println("Sorry no such animal available.");
            }

            System.out.println("Continue main Zoo menu? (Enter 1 for yes/ 2 for no):");
            continueOuterLoop = keyboard.nextInt();

        } while (continueOuterLoop == 1);
    }

    // Método para mostrar el menú de selección de animales
    static int animalChoiceMenu(Scanner keyboard) {
        int choiceGivenByUser;

        System.out.println("******* ZOO ANIMAL choice menu ******");
        System.out.println("1. Tiger");
        System.out.println("2. Dolphin");
        System.out.println("3. Penguin");
        System.out.println("4. Save animals to file");
        System.out.println("5. Display saved animals from file");
        System.out.println("Enter choice of animal (1-5):");
        choiceGivenByUser = keyboard.nextInt();
        return choiceGivenByUser;
    }

    // Método para mostrar el menú de manipulación de detalles del animal
    private static int animalDetailsManipulationMenu(Scanner keyboard, Animal animal) {
        int choiceGivenByUser;

        System.out.println("******* ANIMAL details menu for: " + animal.getNameOfAnimal() + " ******");
        System.out.println("1. Set properties");
        System.out.println("2. Display properties");
        System.out.println("3. Display movement");
        System.out.println("4. Display eating");
        System.out.println("Enter choice (1-4):");
        choiceGivenByUser = keyboard.nextInt();
        return choiceGivenByUser;

    }

    // Método para guardar los objetos de los animales en archivos
    public static void writeObjectsToFile(Tiger tiger, Penguin penguin, Dolphin dolphin){
        try(ObjectOutputStream tigerOut = new ObjectOutputStream(new FileOutputStream("tiger.txt"));
            ObjectOutputStream penguinOut = new ObjectOutputStream(new FileOutputStream("penguin.txt"));
            ObjectOutputStream dolphinOut = new ObjectOutputStream(new FileOutputStream("dolphin.txt"))){

            tigerOut.writeObject(tiger);
            penguinOut.writeObject(penguin);
            dolphinOut.writeObject(dolphin);

            System.out.println("Animals successfully saved to file");
        }catch(IOException e){
            System.out.println("Error saving animals data " + e.getMessage());

            e.printStackTrace();
        }
    }

    // Método para cargar los objetos de los animales desde archivos
    public static  void readObjectsFromFile(){
        try(ObjectInputStream tigerIn = new ObjectInputStream(new FileInputStream("tiger.txt"));
            ObjectInputStream penguinIn = new ObjectInputStream(new FileInputStream("penguin.txt"));
            ObjectInputStream dolphinIn = new ObjectInputStream(new FileInputStream("dolphin.txt"))){

            Tiger tiger = (Tiger) tigerIn.readObject();
            Penguin penguin = (Penguin) penguinIn.readObject();
            Dolphin dolphin = (Dolphin) dolphinIn.readObject();

            System.out.println("\n-------------Loaded aniamls __________\n");
            System.out.println("Tiger:  " + tiger);
            System.out.println("Penguin: " + penguin);
            System.out.println("Dolphin: " + dolphin);


        }catch(IOException | ClassNotFoundException e){
            System.err.println("Error loading animal data:  " + e.getMessage());
            e.printStackTrace();

        }
    }

}