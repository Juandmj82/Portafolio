// Clase que implementa la interfaz Notification para enviar notificaciones push.
// Simula el envío de una notificación push mostrando el mensaje en consola.
public class PushNotification implements Notification {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending push notification:");
        System.out.println("Message: " + message); // Muestra el mensaje recibido
    }

    @Override
    public void getType() {
        System.out.println("Push notification");  // Identifica el tipo de notificación
    }
}