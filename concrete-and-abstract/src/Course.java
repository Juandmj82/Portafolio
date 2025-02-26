// Clase abstracta que representa un curso genérico con información básica
abstract class Course {
    Subject subject;     // Materia asociada al curso
    String instructor;   // Nombre del instructor
    int fee;            // Costo del curso
    int assignmentMarks; // Calificación de la tarea
    int quizMarks;       // Calificación del cuestionario

    // Constructor para inicializar un curso con su materia, instructor y costo
    Course(Subject subject, String instructor, int fee) {
        this.subject = subject;
        this.instructor = instructor;
        this.fee = fee;
    }
}
