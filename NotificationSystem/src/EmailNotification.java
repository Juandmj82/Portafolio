// Clase que implementa la interfaz Notification para enviar notificaciones por email.
// Almacena los datos del email y simula su envío mostrando la información en consola.
public class EmailNotification implements Notification {
    private String email, subject, body; // Atributos privados para el email

    // Constructor que inicializa los datos del email
    public EmailNotification(String email, String subject, String body) {
        this.email = email;
        this.subject = subject;
        this.body = body;
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("Sending email notification:");
        System.out.println("To: " + email);
        System.out.println("Subject: " + subject);
        // Usa el mensaje pasado como parámetro si existe, de lo contrario usa el atributo body
        System.out.println("Body: " + (message != null ? message : this.body));
    }

    @Override
    public void getType() {
        System.out.println("Email notification"); // Identifica el tipo de notificación
    }
}