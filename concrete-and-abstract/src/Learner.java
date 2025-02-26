// Clase que representa a un estudiante que se inscribe en un curso y recibe calificaciones
public class Learner implements Assessments {
    String name;     // Nombre del estudiante
    Course course;   // Curso en el que está inscrito
    double gradeScore; // Nota final calculada del estudiante

    // Constructor para inicializar un estudiante con su nombre y curso
    Learner(String name, Course course) {
        this.name = name;
        this.course = course;
    }

    // Método para representar la información del estudiante como cadena de texto
    public String toString() {
        return "Name: " + this.name + " Course: " + this.course.subject.title;
    }

    // Método para asignar calificación de tarea
    @Override
    public void assignmentScore(int marks) {
        this.course.assignmentMarks = marks;
    }

    // Método para asignar calificación de cuestionario
    @Override
    public void quizScore(int marks) {
        this.course.quizMarks = marks;
    }

    // Calcula la calificación final basada en la nota de tarea y cuestionario
    public double calculateGrade() {
        int maxAssignmentMarks, maxQuizMarks;

        // Determina los máximos puntajes permitidos según si el curso es en línea o presencial
        if (this.course.subject.title.contains("Online")) {
            maxAssignmentMarks = 30;
            maxQuizMarks = 10;
        } else {
            maxAssignmentMarks = 100;
            maxQuizMarks = 30;
        }

        // Calcula la nota basada en un sistema de 10 puntos
        double assignmentGrade = (double) this.course.assignmentMarks * 10 / maxAssignmentMarks;
        double quizGrade = (double) this.course.quizMarks * 10 / maxQuizMarks;

        // Promedio entre la calificación de la tarea y el cuestionario
        this.gradeScore = (assignmentGrade + quizGrade) / 2;
        return this.gradeScore;
    }
}
