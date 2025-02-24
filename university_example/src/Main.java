// Clase principal para probar el sistema
public class Main {
    public static void main(String[] args) {
        // Crear instancias de Date para fechas relevantes
        Date date1 = new Date(1, 1, 2005);  // Fecha de nacimiento del estudiante
        Date date2 = new Date(10, 10, 1995); // Fecha de nacimiento del profesor
        Date date3 = new Date(1, 4, 2024);  // Fecha de contratación del profesor

        // Crear un profesor con sus datos
        Teacher teacher = new Teacher("Madhavan", date2, date3, "M.Tech", "Electronics");
        teacher.setSalary();  // Establecer el salario del profesor

        // Crear un estudiante asociado al profesor
        Student student = new Student("Belinda", date1, teacher, "Electronics");

        // Mostrar detalles del profesor y del estudiante
        teacher.getDetails();
        student.getDetails();
    }
}