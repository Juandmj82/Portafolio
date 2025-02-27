# Idea Tracker - Gestión de Ideas en Archivos de Texto

## Descripción
Este proyecto es una aplicación de seguimiento de ideas desarrollada en **Java**. Permite a los usuarios guardar y leer ideas en archivos de texto mediante un menú interactivo. Forma parte del programa **Amazon Junior Software Developer**.

## Funcionalidades
✅ Leer contenido de archivos de texto.  
✅ Guardar ideas en archivos de texto con nombre personalizado.  
✅ Manejo de excepciones para evitar errores al leer o escribir archivos.  
✅ Uso eficiente de `FileInputStream` y `FileOutputStream`.

## Estructura del Proyecto
- **`IdeaTracker`**: Menú interactivo para elegir leer o escribir archivos.
- **`IdeaReader`**: Clase para leer el contenido de un archivo.
- **`IdeaWriter`**: Clase para escribir ideas en archivos de texto.
- **`sample-project-idea.txt`**: Archivo de ejemplo con una idea precargada.

## Instalación y Ejecución
1. Clona este repositorio o descarga los archivos.
2. Abre una terminal en la carpeta del proyecto.
3. Compila los archivos Java:
   ```sh
   javac *.java
   ```
4. Ejecuta el programa:
   ```sh
   java IdeaTracker
   ```

## Uso del Programa
### 📖 Leer un archivo existente
1. Elige la opción `1` en el menú.
2. Ingresa la ruta del archivo a leer.
3. Se mostrará el contenido del archivo en la consola.

### 📝 Escribir una nueva idea en un archivo
1. Elige la opción `2` en el menú.
2. Ingresa el nombre de la idea (se creará un archivo con ese nombre).
3. Escribe la descripción de la idea.
4. El archivo se guardará en la carpeta `src/`.

### 🚪 Salir del programa
Selecciona la opción `3` en el menú.

## Explicación del Código
### 📖 Clase `IdeaReader`
Lee el contenido de un archivo de texto utilizando `FileInputStream`. Maneja excepciones en caso de que el archivo no exista o haya un error al leerlo.

### 📝 Clase `IdeaWriter`
Escribe una idea en un archivo de texto utilizando `FileOutputStream`. Convierte la información en bytes antes de guardarla.

### 🏗️ Clase `IdeaTracker`
Es el punto de entrada del programa. Presenta un menú interactivo al usuario, permitiéndole leer o escribir archivos.

## Conclusión
Este ejercicio demuestra cómo gestionar archivos en Java de manera eficiente, garantizando un **manejo seguro de errores** y una **experiencia interactiva para el usuario**.

📌 **Desarrollado como parte del programa Amazon Junior Software Developer.**

