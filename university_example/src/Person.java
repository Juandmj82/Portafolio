// Clase abstracta base para representar a cualquier persona
abstract class Person {
    String name;  // Nombre de la persona
    Date dob;     // Fecha de nacimiento (instancia de la clase Date)

    // Método abstracto que las subclases deben implementar para mostrar detalles
    abstract void getDetails();
}