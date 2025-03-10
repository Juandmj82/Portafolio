import java.util.ArrayList;

/**
 * Sistema de gestión de estudiantes con una lista de estudiantes registrados.
 */
public class StudentInfoSystem {
    private static ArrayList<Student> students = new ArrayList<>();

    /**
     * Agrega un estudiante al sistema.
     * @param student Estudiante a agregar.
     * @return true si se agregó correctamente, false si no.
     */
    static boolean addStudent(Student student) {
        if (student == null) {
            return false; // No se puede agregar un estudiante nulo
        }
        students.add(student); // Agregar el estudiante a la lista
        System.out.println("Student added: " + student.getName());
        return true;
    }

    /**
     * Busca un estudiante por su nombre.
     * @param name Nombre del estudiante a buscar.
     * @return El estudiante si se encuentra, o null si no existe.
     */
    static Student findStudentByName(String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
    }
}
