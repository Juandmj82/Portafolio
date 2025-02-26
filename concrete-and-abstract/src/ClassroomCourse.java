// Representa un curso presencial con atributos adicionales
class ClassroomCourse extends Course {
    String school;  // Nombre de la escuela donde se imparte el curso
    String session; // Sesión (ej. Primavera, Invierno)

    // Constructor para un curso presencial
    ClassroomCourse(Subject subject, String instructor, int fee, String school, String session) {
        super(subject, instructor, fee);
        this.school = school;
        this.session = session;
    }
}
