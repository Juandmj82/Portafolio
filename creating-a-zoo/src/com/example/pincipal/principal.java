import com.example.model.Animal;
import com.example.model.Penguin;
import com.example.model.Tiger;
import com.example.model.Dolphin;
import java.util.Scanner;

public class principal {
    public static class Main {
        public static void main(String[] args) {
            Tiger tigerObject = new Tiger();
            Dolphin dolphinObject = new Dolphin();
            Penguin penguinObject = new Penguin();


            // for getting input
            Scanner keyboard = new Scanner(System.in);

            // for loop continuation - 1 represents true
            int continueOuterLoop = 1  ;
            int continueInnerLoop = 1;

            // for menu choice
            int menuChoice = 1;

            /** TODO 1: extend the class com.example.model.Animal to create a new
             *          land based animal named "com.example.model.Tiger" which extends
             *          com.example.model.Animal.
             *          Extra properties of class "com.example.model.Tiger" are:
             *          1. number of stripes
             *          2. speed
             *          3. sound level of roar
             *
             **/



            /** TODO 2: extend the class com.example.model.Animal to create a new
             *          water based animal named "Dolphin" which
             *          extends com.example.model.Animal
             *          Extra properties of class "Dolphin" include:
             *          1. color of dolphin
             *          2. swimming speed
             *
             **/


            /** TODO 3: implemement the "com.example.service.Eat" interface in the
             *          "com.example.model.Tiger" class created in the TODO 1
             *          and also in the
             *          "Dolphin" class created in TODO 2.
             **/



            /** TODO 5: implement the "com.example.service.Walk" interface in
             *          "com.example.model.Tiger" class created in the TODO 1
             *          and in the  implementation of the
             *          "walking" method of the interface
             *          display -
             *          " I am walking at the speed "
             *          and join the value of the variable "speed"
             *
             **/

            /** TODO 6: create a new interface named "com.example.service.Swim"
             *          and declaring a method inside it
             *          named "swimming" with the return type
             *          "void"
             **/

            /** TODO 7: implement the "com.example.service.Swim" interface
             *          in the "Dolphin" class and the
             *          "swimming" method in its implementation
             *          should display the swimming speed as
             *          "Dolphin: I am swimming at the speed ...."
             *          where .... is the value of the variable
             *          "swimmingSpeed"
             **/


            /** TODO 8: create a menu system to work with the com.example.model.Animal selected
             *          use the switch provided below
             **/



            do {
                switch (animalChoiceMenu(keyboard)) {
                    case 1:
                        do {
                            System.out.println("The animal which is chosen is : " + tigerObject.getNameOfAnimal());

                            // get menu choice
                            menuChoice = animalDetailsManipulationMenu(keyboard, tigerObject); // Call the method and assign its value


                            switch (menuChoice ) {
                                case 1:
                                    System.out.println("Enter Age: ");
                                    tigerObject.setAge(keyboard.nextInt());

                                    System.out.println("Enter weight: ");
                                    tigerObject.setWeight(keyboard.nextInt());

                                    System.out.println("Enter height: ");
                                    tigerObject.setHeight(keyboard.nextInt());

                                    System.out.println("Enter Speed: ");
                                    tigerObject.setSpeed(keyboard.nextInt());

                                    System.out.println("Enter number of stripes: ");
                                    tigerObject.setNumberOfStripes(keyboard.nextInt());

                                    System.out.println("Enter level of roar: ");
                                    tigerObject.setSoundLevel(keyboard.nextInt());

                                    break;

                                case 2:
                                    System.out.println("Name: " + tigerObject.getNameOfAnimal());
                                    System.out.println("Age: "+ tigerObject.getAge());
                                    System.out.println("Weight: "+ tigerObject.getWeight());
                                    System.out.println("Height: "+ tigerObject.getHeight());
                                    System.out.println("com.example.model.Tiger speed : " + tigerObject.getSpeed());
                                    System.out.println("com.example.model.Tiger number of stripes : " + tigerObject.getNumberOfStripes());
                                    System.out.println("com.example.model.Tiger level of roar : " + tigerObject.getSoundLevel());

                                    break;
                                case 3:
                                    tigerObject.walking();

                                    break;
                                case 4:
                                    tigerObject.eatingCompleted();
                                    break;
                                default:
                                    System.out.println("Not supported");

                            }
                            System.out.println("Continue with this animal ? (Enter 1 for yes/ 2 for no):");
                            continueInnerLoop = keyboard.nextInt();
                        } while(continueInnerLoop == 1);

                        break;
                    case 2:
                        do {
                            System.out.println("The animal which is chosen is : " + dolphinObject.getNameOfAnimal());
                            // get menu choice
                            menuChoice = animalDetailsManipulationMenu(keyboard, dolphinObject); // Call the method and assign its value

                            switch (menuChoice) {
                                case 1:
                                    System.out.println("Enter Age: ");
                                    dolphinObject.setAge(keyboard.nextInt());

                                    System.out.println("Enter weight: ");
                                    dolphinObject.setWeight(keyboard.nextInt());

                                    System.out.println("Enter height: ");
                                    dolphinObject.setHeight(keyboard.nextInt());

                                    System.out.println("Enter Speed: ");
                                    dolphinObject.setSwimmingSpeed(keyboard.nextInt());

                                    keyboard.nextLine();
                                    System.out.println("Enter color: ");
                                    dolphinObject.setColor(keyboard.nextLine());

                                    break;

                                case 2:
                                    System.out.println("Name: " + dolphinObject.getNameOfAnimal());
                                    System.out.println("Age: "+ dolphinObject.getAge());
                                    System.out.println("Weight: "+ dolphinObject.getWeight());
                                    System.out.println("Height: "+ dolphinObject.getHeight());
                                    System.out.println("Dolphin speed : " + dolphinObject.getSwimmingSpeed());
                                    System.out.println("Dolphin color : " + dolphinObject.getColor());

                                    break;
                                case 3:
                                    dolphinObject.swimming();
                                    break;
                                case 4:
                                    dolphinObject.eatingCompleted();
                                    dolphinObject.eatingFood();
                                    break;
                                default:
                                    System.out.println("Not supported");

                            }
                            System.out.println("Continue with this animal ? (Enter 1 for yes/ 2 for no):");
                            continueInnerLoop = keyboard.nextInt();
                        } while(continueInnerLoop == 1);
                        break;
                    case 3:
                        do {
                            System.out.println("The animal which is chosen is : " + penguinObject.getNameOfAnimal());
                            // get menu choice
                            menuChoice = animalDetailsManipulationMenu(keyboard, penguinObject); // Call the method and assign its value

                            switch (menuChoice) {
                                case 1:
                                    System.out.println("Enter Age: ");
                                    penguinObject.setAge(keyboard.nextInt());

                                    System.out.println("Enter weight: ");
                                    penguinObject.setWeight(keyboard.nextInt());

                                    System.out.println("Enter height: ");
                                    penguinObject.setHeight(keyboard.nextInt());

                                    System.out.println("Enter Speed: ");
                                    penguinObject.setSwimSpeed(keyboard.nextInt());

                                    keyboard.nextLine();
                                    System.out.println("Enter walkSpeed: ");
                                    penguinObject.setWalkSpeed(keyboard.nextInt());

                                    break;

                                case 2:
                                    System.out.println("Name: " + penguinObject.getNameOfAnimal());
                                    System.out.println("Age: "+ penguinObject.getAge());
                                    System.out.println("Weight: "+ penguinObject.getWeight());
                                    System.out.println("Height: "+ penguinObject.getHeight());
                                    System.out.println("com.example.model.Penguin speed : " + penguinObject.getSwimSpeed());
                                    System.out.println("com.example.model.Penguin walkSpeed : " + penguinObject.getWalkSpeed());

                                    break;
                                case 3:
                                    // Ask if the penguin is walking or swimming
                                    System.out.println("Do you want to see the penguin walking or swimming? (Enter 1 for walking, 2 for swimming):");
                                    int actionChoice = keyboard.nextInt();

                                    if (actionChoice == 1) {
                                        penguinObject.walking(); // Call the walking method
                                    } else if (actionChoice == 2) {
                                        penguinObject.swimming(); // Call the swimming method
                                    } else {
                                        System.out.println("Invalid choice. Please enter 1 or 2.");
                                    }
                                    break;
                                case 4:
                                    penguinObject.eatingCompleted();
                                    penguinObject.eatingFood();
                                    break;
                                default:
                                    System.out.println("Not supported");

                            }
                            System.out.println("Continue with this animal ? (Enter 1 for yes/ 2 for no):");
                            continueInnerLoop = keyboard.nextInt();
                        } while(continueInnerLoop == 1);
                        break;


                    default:
                        System.out.println("Sorry no such animal available.");
                }

                System.out.println("Continue main Zoo menu? (Enter 1 for yes/ 2 for no):");
                continueOuterLoop = keyboard.nextInt();

            } while(continueOuterLoop == 1);


            /** TODO 9: create a class "com.example.model.Penguin" from the "com.example.model.Animal" class **/

            /** TODO 10: integrate the choice to pick a "penguin" in the menu system **/

        }

        private static int animalChoiceMenu(Scanner keyboard) {
            int choiceGivenByUser;

            System.out.println("******* ZOO ANIMAL choice menu ******");
            System.out.println("1. com.example.model.Tiger");
            System.out.println("2. Dolphin");
            System.out.println("3. com.example.model.Penguin");

            System.out.println("Enter choice of animal:");
            choiceGivenByUser = keyboard.nextInt();
            return choiceGivenByUser;
        }

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
    }
}
