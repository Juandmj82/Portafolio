# Proyecto Final del Curso 2: Programando con Java 

## 📝 Descripción del Proyecto

Este proyecto es parte del curso **Amazon Junior Software Developer**, específicamente del **Curso 2: Programando con Java**. El objetivo de este ejercicio es aplicar los conceptos aprendidos durante el curso para desarrollar un sistema de gestión de un zoológico virtual. El programa permite interactuar con diferentes tipos de animales (Tigre, Delfín y Pingüino), modificar sus propiedades, observar sus comportamientos y guardar/cargar los datos en archivos.

Este proyecto es el **proyecto final** del curso y está diseñado para consolidar los conocimientos adquiridos en programación orientada a objetos (POO), manejo de archivos, y uso de interfaces en Java.

---

## 🎯 Temas Principales Trabajados

En este proyecto se han trabajado los siguientes temas clave del curso:

1. **🧩 Programación Orientada a Objetos (POO):**
    - Uso de clases y objetos.
    - Herencia entre clases.
    - Encapsulamiento con métodos `getter` y `setter`.
    - Sobrescritura de métodos (`@Override`).
    - Clases abstractas e interfaces.

2. **🔌 Interfaces:**
    - Implementación de interfaces (`Eat`, `Swim`, `Walk`).
    - Definición de comportamientos comunes para diferentes clases.

3. **💾 Manejo de Archivos:**
    - Serialización de objetos para guardar datos en archivos.
    - Deserialización de objetos para cargar datos desde archivos.
    - Uso de `ObjectOutputStream` y `ObjectInputStream`.

4. **👤 Interacción con el Usuario:**
    - Uso de la clase `Scanner` para leer la entrada del usuario.
    - Menús interactivos para seleccionar y manipular animales.

5. **✨ Buenas Prácticas de Programación:**
    - Código modular y bien estructurado.
    - Comentarios detallados para facilitar la comprensión del código.
    - Manejo de excepciones con `try-catch`.

---

## 🏗️ Estructura del Proyecto

El proyecto está compuesto por las siguientes clases e interfaces:

### 🐾 Clases Principales

1. **`Animal.java`:**
    - Clase abstracta que representa un animal genérico.
    - Implementa la interfaz `Eat`.
    - Contiene propiedades básicas como nombre, peso, altura y edad.

2. **`Dolphin.java`:**
    - Clase que representa un delfín.
    - Hereda de `Animal` e implementa las interfaces `Swim` y `Serializable`.
    - Propiedades específicas: color y velocidad de natación.

3. **`Penguin.java`:**
    - Clase que representa un pingüino.
    - Hereda de `Animal` e implementa las interfaces `Walk`, `Swim` y `Serializable`.
    - Propiedades específicas: estado de natación, velocidad de caminata y velocidad de natación.

4. **`Tiger.java`:**
    - Clase que representa un tigre.
    - Hereda de `Animal` e implementa las interfaces `Walk` y `Serializable`.
    - Propiedades específicas: número de rayas, velocidad y nivel de sonido del rugido.

5. **`Main.java`:**
    - Clase principal que contiene el método `main`.
    - Gestiona la interacción con el usuario mediante menús.
    - Permite guardar y cargar los datos de los animales en archivos.

### 🔗 Interfaces

1. **`Eat.java`:**
    - Define los métodos `eatingFood` y `eatingCompleted` para representar el comportamiento de comer.

2. **`Swim.java`:**
    - Define el método `swimming` para representar el comportamiento de nadar.

3. **`Walk.java`:**
    - Define el método `walking` para representar el comportamiento de caminar.

---

## 🚀 Funcionalidades del Programa

El programa ofrece las siguientes funcionalidades:

1. **🦁 Selección de Animales:**
    - El usuario puede seleccionar entre un tigre, un delfín o un pingüino.

2. **⚙️ Manipulación de Propiedades:**
    - El usuario puede establecer y ver las propiedades de cada animal (edad, peso, altura, etc.).
    - Cada animal tiene propiedades específicas (por ejemplo, el número de rayas del tigre o el color del delfín).

3. **🏃‍♂️ Comportamientos:**
    - El usuario puede observar los comportamientos de los animales, como comer, caminar o nadar.

4. **💾 Guardar y Cargar Datos:**
    - Los datos de los animales se pueden guardar en archivos mediante serialización.
    - Los datos guardados se pueden cargar y mostrar en cualquier momento.

---

## 🛠️ Ejecución del Proyecto

Para ejecutar el proyecto, sigue estos pasos:

1. Clona o descarga el repositorio del proyecto.
2. Abre el proyecto en tu IDE favorito (por ejemplo, IntelliJ IDEA o Eclipse).
3. Ejecuta la clase `Main.java`.
4. Sigue las instrucciones en la consola para interactuar con el programa.

---

## 📋 Requisitos

- **Java Development Kit (JDK):** Asegúrate de tener instalado JDK 8 o superior.
- **IDE:** Se recomienda usar un IDE como IntelliJ IDEA, Eclipse o Visual Studio Code.

---

## 🤝 Contribuciones

Este proyecto es parte de un curso, pero si deseas contribuir o mejorar el código, ¡no dudes en hacerlo! Puedes abrir un *pull request* con tus cambios.

---

## 👨‍💻 Autor

Este proyecto fue desarrollado como parte del curso **Amazon Junior Software Developer**.

---

## 📜 Licencia

Este proyecto está bajo la licencia MIT. Para más detalles, consulta el archivo `LICENSE`.

---

¡Gracias por revisar este proyecto! Esperamos que te haya ayudado a consolidar tus conocimientos en Java y programación orientada a objetos. 😊

---

### 🌟 ¡Diviértete programando! 🌟