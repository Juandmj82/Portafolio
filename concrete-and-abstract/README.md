# Sistema de Gestión de Cursos en Java

Este proyecto es parte del curso **Amazon Junior Software Developer** y consiste en un sistema de gestión de cursos en Java. Permite a los estudiantes inscribirse en cursos en línea o presenciales, recibir calificaciones y calcular su nota final.

## Estructura del Proyecto
El proyecto está diseñado utilizando una jerarquía de clases con composición:

- **`Subject`**: Representa una materia con su título y cantidad de créditos.
- **`Course`**: Clase abstracta que define los atributos comunes de todos los cursos.
    - **`ClassroomCourse`**: Curso presencial con información adicional sobre la escuela y sesión.
    - **`OnlineCourse`**: Curso en línea sin atributos adicionales.
- **`Assessments`**: Interfaz que define los métodos para asignar calificaciones.
- **`Learner`**: Representa un estudiante que toma un curso y puede recibir notas.
- **`Main`**: Punto de entrada del programa donde el usuario selecciona un curso y recibe su calificación.

## Instalación y Ejecución
Para ejecutar el proyecto, sigue estos pasos:

1. Clona este repositorio o descarga los archivos.
2. Abre una terminal en la carpeta del proyecto.
3. Compila los archivos Java:
   ```sh
   javac *.java
   ```
4. Ejecuta el programa:
   ```sh
   java Main
   ```

## Uso del Programa
1. Ingresa el nombre del estudiante.
2. Selecciona un curso de la lista disponible.
3. Ingresa las notas de la tarea y el cuestionario.
4. El sistema calculará la calificación final y mostrará si el estudiante ha aprobado.

## Autor
Desarrollado como parte del curso **Amazon Junior Software Developer**.

