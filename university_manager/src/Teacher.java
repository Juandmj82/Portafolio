// Clase concreta que extiende Employee y representa a un profesor
class Teacher extends Employee {
    String qualification;  // Cualificación académica del profesor (e.g., "M.Tech")
    String subject;        // Asignatura que enseña el profesor (e.g., "Electronics")

    // Constructor que inicializa los atributos del profesor
    Teacher(String name, Date dob, Date dateOfAppointment, String qual, String subject) {
        this.name = name;                    // Nombre heredado de Person
        this.dob = dob;                      // Fecha de nacimiento heredada de Person
        this.dateOfAppointment = dateOfAppointment; // Fecha de contratación de Employee
        this.subject = subject;              // Asignatura específica del profesor
        this.qualification = qual;           // Cualificación del profesor
    }

    // Implementa setSalary() para establecer un salario fijo de 50,000
    @Override
    void setSalary() {
        this.salary = 50000;
    }

    // Implementa getSalary() para devolver el salario actual
    @Override
    int getSalary() {
        return this.salary;
    }

    // Implementa getDetails() para mostrar la información del profesor
    @Override
    void getDetails() {
        System.out.println("Name of Teacher: " + this.name);
        System.out.println("Date of Birth: " + this.dob.getDate());
        System.out.println("Date of Appointment: " + this.dateOfAppointment.getDate());
        System.out.println("Qualification: " + this.qualification);
        System.out.println("Subject: " + this.subject);
        System.out.println("Salary: " + this.salary);
    }
}