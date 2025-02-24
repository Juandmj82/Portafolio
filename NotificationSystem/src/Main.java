import java.util.Scanner;

// Clase principal que ejecuta el sistema de notificaciones.
// Permite al usuario elegir entre diferentes tipos de notificaciones y valida las entradas.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Mensaje de bienvenida y opciones del sistema
        System.out.println("********** Welcome to the notification system *********");
        System.out.println("\nEnter type of notification you want to send: ");
        System.out.println("\n1. Email");
        System.out.println("2. SMS");
        System.out.println("3. Push");

        int choice;
        // Valida que la entrada sea un número entero
        try {
            choice = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid choice"); // Mensaje de error si no es un número
            scanner.close();
            return;
        }
        scanner.nextLine(); // Limpia el buffer después de leer el entero

        // Procesa la opción seleccionada por el usuario
        switch (choice) {
            case 1:
                System.out.println("Enter Email: ");
                String email = scanner.nextLine();
                // Verifica que el email contenga un "@" como validación básica
                if (!email.contains("@")) {
                    System.out.println("Invalid email");
                    scanner.close();
                    return;
                }
                System.out.println("Enter Subject: ");
                String subject = scanner.nextLine();
                System.out.println("Enter body of the email: ");
                String body = scanner.nextLine();

                EmailNotification emailNotification = new EmailNotification(email, subject, body);
                emailNotification.sendNotification(body); // Envía el email con el cuerpo proporcionado
                emailNotification.getType();
                break;

            case 2:
                System.out.println("Enter phone number: ");
                String phoneNumber = scanner.nextLine();
                System.out.println("Enter message: ");
                String message = scanner.nextLine();

                SMSNotification smsNotification = new SMSNotification();
                smsNotification.sendNotification(message); // Envía el SMS con el mensaje
                smsNotification.getType();
                break;

            case 3:
                System.out.println("Enter message: ");
                String pushMessage = scanner.nextLine();

                PushNotification pushNotification = new PushNotification();
                pushNotification.sendNotification(pushMessage); // Envía la notificación push
                pushNotification.getType();
                break;

            default:
                System.out.println("Invalid choice"); // Caso por defecto para opciones no válidas
                break;
        }

        scanner.close(); // Cierra el Scanner para liberar recursos
    }
}