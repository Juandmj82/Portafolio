// Clase abstracta que extiende Person y representa a empleados
abstract class Employee extends Person {
    Date dateOfAppointment;  // Fecha de contratación del empleado
    int salary;              // Salario del empleado

    // Método abstracto para establecer el salario, implementado por subclases
    abstract void setSalary();

    // Método abstracto para obtener el salario, implementado por subclases
    abstract int getSalary();
}