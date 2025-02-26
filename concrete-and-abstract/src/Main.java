import java.util.Scanner;

// Clase principal que gestiona la interacción con el usuario
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Solicita el nombre del estudiante
        System.out.println("Enter name: ");
        String name = in.nextLine();

        // Creación de materias disponibles
        Subject subject1 = new Subject("Java", 4);
        Subject subject2 = new Subject("Java Online", 4);
        Subject subject3 = new Subject("JavaScript", 6);
        Subject subject4 = new Subject("JavaScript Online", 6);

        Course course1 = null;

        // Muestra las opciones de cursos disponibles
        System.out.println("Available courses");
        System.out.println("1. Java");
        System.out.println("2. Java Online");
        System.out.println("3. JavaScript");
        System.out.println("4. JavaScript Online");
        System.out.println("Enter course code :");

        // Captura la selección del usuario
        int ch = in.nextInt();

        // Asigna el curso según la elección del usuario
        if (ch == 1 || ch == 3)
            course1 = new ClassroomCourse(subject1, "Mark", 1000, "Cambridge", "Winter");
        if (ch == 2 || ch == 4)
            course1 = new OnlineCourse(subject2, "Mark", 1000);

        // Crea un nuevo estudiante con el curso seleccionado
        Learner learner = new Learner(name, course1);

        // Solicita las notas del estudiante
        System.out.println("Enter assignment marks (max 100 for classroom course, 30 for online course)");
        int mark1 = in.nextInt();
        System.out.println("Enter quiz marks (max 30 for classroom course, 10 for online course)");
        int mark2 = in.nextInt();

        // Asigna las notas ingresadas
        learner.assignmentScore(mark1);
        learner.quizScore(mark2);

        // Calcula la calificación y muestra el resultado
        String title = learner.course.subject.title;
        System.out.println("Grade score: " + learner.calculateGrade());

        // Determina si el estudiante ha aprobado o solo ha completado el curso
        if (learner.gradeScore >= 5)
            System.out.println("Congratulations " + learner.name + " you have successfully passed the " + title + " course");
        else
            System.out.println("Congratulations " + learner.name + " you have successfully completed the " + title + " course");

        in.close(); // Cierra el scanner
    }
}
