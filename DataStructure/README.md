# Sistema de Gestión de Exámenes y Estudiantes

## Descripción

Este proyecto es el ejercicio final del **Módulo 1 del curso Data Structure** perteneciente a la certificación **Amazon Junior Software Developer**.

El programa implementa un sistema de gestión de estudiantes y sus horarios de exámenes, permitiendo la administración de información a través de una lista doblemente enlazada.

## Funcionalidades

- **Agregar estudiantes** al sistema.
- **Asignar exámenes** a un estudiante específico.
- **Navegar entre exámenes** usando una lista doblemente enlazada.
- **Ver el siguiente o anterior examen** en la lista de exámenes de un estudiante.
- **Mostrar todos los exámenes programados** de un estudiante.
- **Interfaz de consola** para gestionar estudiantes y exámenes.

## Temas de Estructuras de Datos Aplicados

Este proyecto cubre los siguientes temas de **estructuras de datos**:

- **Listas doblemente enlazadas** (para gestionar los exámenes de los estudiantes).
- **ArrayLists** (para almacenar la lista de estudiantes).
- **Recorrido de listas** con bucles (`for` y `while`).

## Estructura del Proyecto

El proyecto se compone de las siguientes clases:

- **`ExamNode.java`**: Representa un nodo de la lista doblemente enlazada para los exámenes.
- **`ExamSchedule.java`**: Implementa la lista doblemente enlazada y maneja los exámenes de un estudiante.
- **`Student.java`**: Representa un estudiante y asocia un horario de exámenes.
- **`StudentInfoSystem.java`**: Gestiona la lista de estudiantes y permite su búsqueda.
- **`Main.java`**: Contiene el menú de la aplicación para interactuar con el sistema.

## Cómo Ejecutar el Proyecto

1. **Compilar los archivos**:
   ```sh
   javac *.java
   ```
2. **Ejecutar el programa**:
   ```sh
   java Main
   ```

## Uso del Programa

Al ejecutar `Main.java`, el sistema mostrará un menú con las siguientes opciones:

1. Agregar estudiante.
2. Agregar examen a un estudiante.
3. Ver el siguiente examen.
4. Ver el examen anterior.
5. Ver todos los exámenes de un estudiante.
6. Salir del programa.

## Contribuciones

Este proyecto fue desarrollado como parte del **Módulo 1 del curso Data Structure** en la certificación **Amazon Junior Software Developer**.&#x20;
