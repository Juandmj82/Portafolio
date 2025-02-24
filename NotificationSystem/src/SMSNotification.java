// Clase que implementa la interfaz Notification para enviar notificaciones SMS.
// Simula el envío de un mensaje SMS mostrando el contenido en consola.
public class SMSNotification implements Notification {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending SMS notification:");
        System.out.println("Message: " + message); // Muestra el mensaje recibido como parámetro
    }

    @Override
    public void getType() {
        System.out.println("SMS notification");    // Identifica el tipo de notificación
    }
}