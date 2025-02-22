// Clase concreta que extiende Person y representa a un estudiante
class Student extends Person {
    String subject;   // Asignatura que estudia el estudiante
    Teacher teacher;  // Referencia al profesor asignado al estudiante

    // Constructor que inicializa los atributos del estudiante
    Student(String name, Date date, Teacher teacher, String subject) {
        this.name = name;        // Nombre heredado de Person
        this.dob = date;         // Fecha de nacimiento heredada de Person
        this.teacher = teacher;  // Profesor asociado
        this.subject = subject;  // Asignatura del estudiante
    }

    // Implementa getDetails() para mostrar la información del estudiante
    @Override
    void getDetails() {
        System.out.println("Name of Student: " + this.name);
        System.out.println("Date of Birth: " + this.dob.getDate());
        System.out.println("Subject: " + this.subject);
        System.out.println("Teacher: " + this.teacher.name);
    }
}