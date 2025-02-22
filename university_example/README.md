# Ejercicio: Sistema de Gestión de Personas Educativas

## Curso: Amazon Junior Software Developer

### Descripción
Este proyecto es un ejercicio práctico del curso **Amazon Junior Software Developer**, diseñado para enseñar conceptos fundamentales de programación orientada a objetos (OOP) en Java, incluyendo herencia, abstracción y polimorfismo. El objetivo es modelar un sistema que gestione información de profesores (`Teacher`) y estudiantes (`Student`) en un contexto educativo, utilizando una jerarquía de clases con clases abstractas y concretas.

El sistema permite:
- Crear instancias de profesores y estudiantes con datos como nombre, fecha de nacimiento, y atributos específicos (e.g., asignatura, salario, cualificaciones).
- Mostrar detalles personalizados de cada entidad mediante el método `getDetails()`.
- Establecer y consultar el salario de los profesores.

### Estructura del Proyecto
El proyecto consta de seis clases organizadas en una jerarquía:

1. **`Date.java`**
    - Clase auxiliar para manejar fechas (día, mes, año).
    - Proporciona un método `getDate()` para formatear la fecha como "día-mes-año".

2. **`Person.java`**
    - Clase abstracta base que define atributos comunes a todas las personas: `name` (nombre) y `dob` (fecha de nacimiento).
    - Declara el método abstracto `getDetails()` que las subclases deben implementar.

3. **`Employee.java`**
    - Clase abstracta que extiende `Person`, añadiendo `dateOfAppointment` (fecha de contratación) y `salary` (salario).
    - Define dos métodos abstractos: `setSalary()` y `getSalary()`.

4. **`Teacher.java`**
    - Clase concreta que extiende `Employee`. Representa a un profesor con `qualification` (cualificación) y `subject` (asignatura).
    - Implementa `getDetails()`, `setSalary()` (fija el salario en 50,000), y `getSalary()`.

5. **`Student.java`**
    - Clase concreta que extiende `Person`. Representa a un estudiante con `subject` (asignatura) y una referencia a su `teacher` (profesor).
    - Implementa `getDetails()` para mostrar información del estudiante y su profesor.

6. **`Main.java`**
    - Clase principal que demuestra el uso del sistema creando un profesor y un estudiante, estableciendo el salario del profesor y mostrando sus detalles.

### Propósito Educativo
Este ejercicio refuerza los siguientes conceptos del curso:
- **Herencia**: `Employee` hereda de `Person`, y `Teacher` de `Employee`.
- **Abstracción**: Uso de clases abstractas (`Person`, `Employee`) con métodos abstractos que las subclases concretas deben implementar.
- **Polimorfismo**: El método `getDetails()` tiene comportamientos distintos en `Teacher` y `Student`.
- **Encapsulamiento**: Los atributos están protegidos y se acceden mediante métodos.

### Requisitos
- **Java**: Versión 8 o superior.
- **Entorno**: Cualquier IDE (e.g., IntelliJ, Eclipse) o compilador de línea de comandos (javac).

### Instrucciones de Ejecución
1. **Clonar o Descargar**: Guarda los seis archivos `.java` en un directorio.
2. **Compilar**:
   ```bash
   javac *.java
3. **Ejecutar**
java Main

 4. **Salida Esperada**:
Name of Teacher: Madhavan
Date of Birth: 10-10-1995
Date of Appointment: 1-4-2024
Qualification: M.Tech
Subject: Electronics
Salary: 50000
Name of Student: Belinda
Date of Birth: 1-1-2005
Subject: Electronics
Teacher: Madhavan
5. **Autor**
   Este ejercicio fue desarrollado como parte del curso Amazon Junior Software Developer, siguiendo las instrucciones del material del curso y adaptado para cumplir con los requisitos de aprendizaje.

---

### **Cómo Usarlo**
1. Copia este texto en un archivo llamado `README.md`.
2. Guárdalo en el mismo directorio que tus archivos `.java`.
3. Si lo subes a GitHub o lo ves en un visor de Markdown, se formateará automáticamente con títulos, listas y bloques de código.

### **Vista Previa**
- `#` crea un título principal.
- `##` crea un subtítulo.
- `-` genera listas con viñetas.
- Bloques de código entre ``` se muestran con formato de programación.

¿Está todo bien así o quieres que modifique algo (e.g., más detalles, otro formato)? ¡Dime si necesitas ajustes!