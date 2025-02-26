// Representa una materia con su título y cantidad de créditos.
class Subject {
    String title;   // Nombre de la materia
    double credits; // Cantidad de créditos asociados a la materia

    // Constructor para inicializar la materia con título y créditos
    Subject(String title, double credits) {
        this.title = title;
        this.credits = credits;
    }

    // Método para representar la materia como una cadena de texto
    public String toString() {
        return "Title: " + this.title + " Credits: " + this.credits;
    }
}
