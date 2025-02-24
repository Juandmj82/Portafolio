// Interfaz que define el contrato para diferentes tipos de notificaciones.
// Proporciona métodos para enviar una notificación y obtener su tipo.
public interface Notification {
    void sendNotification(String message); // Envía una notificación con un mensaje específico
    void getType();                       // Devuelve el tipo de notificación
}