/**
 * Representa a un estudiante con su respectivo horario de exámenes.
 */
public class Student {
    private String name; // Nombre del estudiante
    private ExamSchedule examSchedule; // Horario de exámenes del estudiante

    public Student(String name) {
        this.name = name;
        this.examSchedule = new ExamSchedule(); // Cada estudiante tiene su propio horario
    }

    public String getName() {
        return name;
    }

    public ExamSchedule getExamSchedule() {
        return examSchedule;
    }
}
