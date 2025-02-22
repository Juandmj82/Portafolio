import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("*********** Welcome to the vehicle program ********");
        // Loop to keep the program running until the user chooses to exit
        do {
            System.out.println("\nChoose a vehicle: 1.Car 2. Motorcycle 0. Exit");
            choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("Enter fuel capacity (liters): ");
                float fuelCapacity = scanner.nextFloat();

                System.out.println("Enter fuel consumption (liters/100km): ");
                float fuelConsumption = scanner.nextFloat();

                // Create a new car object
                Car car = new Car(fuelCapacity, fuelConsumption);
                // Start the car
                car.start();
                // Calculate the fuel efficiency
                System.out.printf("fuel Efficiency: %.2f km\n", car.calculateFuelEfficiency());
                // Stop the car
                car.stop();

            } else if (choice == 2) {
                System.out.println("Enter fuel capacity (liters): ");
                float fuelCapacity = scanner.nextFloat();

                System.out.println("Enter fuel consumption (liters/100km): ");
                float fuelConsumption = scanner.nextFloat();
                // Create a new motorcycle object
                Motorcycle motorcycle = new Motorcycle(fuelCapacity, fuelConsumption);
                // Start the motorcycle
                motorcycle.start();
                System.out.printf("fuel Efficiency: %.2f km\n", motorcycle.calculateFuelEfficiency());
                // Stop the motorcycle
                motorcycle.stop();

            } else if (choice != 0) {
                System.out.println("Invalid choice try again");
            }
            // Loop until the user chooses to exit
        } while (choice != 0);

        System.out.println("Exiting the program... Thank you for using the vehicle program");
        // Close the scanner
        scanner.close();

    }
}
