
// Excepción personalizada
//Se extienda de la clase Exception que es la clase base para todas las excepciones en Java.
public class SaldoInsuficienteException extends Exception {
    // Constructor que recibe un mensaje
    public SaldoInsuficienteException(String mensaje) {
        // Se llama al constructor de la clase base y se le pasa el mensaje recibido
        super(mensaje);

    }
}