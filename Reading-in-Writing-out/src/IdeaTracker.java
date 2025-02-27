import java.util.Scanner;

/**
 * Clase principal IdeaTracker
 * Contiene un menú interactivo para que el usuario pueda leer o escribir ideas en archivos de texto.
 */
public class IdeaTracker {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in); // Se crea un Scanner para leer la entrada del usuario.

        while (true) { // Bucle infinito para mantener el programa en ejecución hasta que el usuario decida salir.

            // Mostrar opciones al usuario
            System.out.println("\nWelcome to the Idea Tracker!");
            System.out.println("Select an option to continue:");
            System.out.println("1. Read a file");
            System.out.println("2. Write a file");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1, 2, or 3): ");

            int choice = keyboard.nextInt(); // Leer la opción del usuario.

            switch (choice) {
                case 1:
                    keyboard.nextLine(); // Consumir salto de línea.
                    IdeaReader ideaReader = new IdeaReader(); // Crear objeto IdeaReader.

                    // Pedir al usuario la ruta del archivo a leer.
                    System.out.print("Please enter the file path to read: ");
                    String filePath = keyboard.nextLine();

                    // Llamar al método readIdea() para obtener el contenido del archivo.
                    String contentsReadFromFile = ideaReader.readIdea(filePath);

                    // Mostrar el contenido del archivo en la consola.
                    System.out.println("--------------------------------------------------");
                    System.out.println(contentsReadFromFile);
                    System.out.println("--------------------------------------------------");
                    break;

                case 2:
                    keyboard.nextLine(); // Consumir salto de línea.
                    IdeaWriter ideaWriter = new IdeaWriter(); // Crear objeto IdeaWriter.

                    // Pedir al usuario el nombre de la idea.
                    System.out.println("Please enter the name of the idea: ");
                    String ideaName = keyboard.nextLine();

                    // Construir la ruta del archivo con el nombre proporcionado.
                    String ideaFilePath = "src/" + ideaName + ".txt";

                    // Pedir al usuario una descripción para la idea.
                    System.out.println("Please enter some description for the project: ");
                    String ideaDescription = keyboard.nextLine();

                    // Escribir la idea en un archivo.
                    ideaWriter.writeIdea(ideaFilePath, ideaDescription);
                    break;

                case 3:
                    System.out.println("Thank you for using the Idea Tracker!");
                    return; // Termina la ejecución del programa.

                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3."); // Mensaje de error si la opción ingresada no es válida.
            }
        }
    }
}
