# Coffee Machine - Manejo de Excepciones en Java

## Descripción del Ejercicio
Este proyecto simula una máquina de café en Java que permite a los usuarios seleccionar entre diferentes tipos de café, como Espresso y Latte. Se implementa un sólido **manejo de excepciones** para garantizar que el programa pueda manejar entradas no válidas y errores inesperados sin fallar.

## Objetivo del Proyecto
El objetivo de este ejercicio es demostrar cómo proteger el código utilizando bloques `try-catch-finally` y lanzar excepciones personalizadas para garantizar la integridad de los datos y evitar fallos en la ejecución.

## Funcionalidades Clave
- Permite a los usuarios seleccionar y personalizar su café.
- Manejo de errores para evitar entradas inválidas.
- Uso de excepciones personalizadas (`InvalidTypeException`, `ArithmeticException`, `IllegalArgumentException`).

## Manejo de Excepciones
1. **`InvalidTypeException` en `Coffee`**
    - Si el usuario ingresa un tipo de tostado inválido, se lanza una excepción con un mensaje adecuado.

2. **`ArithmeticException` en `Espresso`**
    - Si el usuario intenta pedir 0 o menos shots de Espresso, se genera una excepción para evitar cálculos inválidos.

3. **`IllegalArgumentException` en `Latte`**
    - Si el usuario ingresa un tipo de leche inválido, el programa lanza una excepción y solicita una nueva entrada.

## Estructura del Proyecto
El código está organizado en las siguientes clases:

- **`Coffee`**: Clase base para representar un café genérico con atributos como nombre, tipo de tostado, nivel de cafeína y precio.
- **`Espresso`**: Clase derivada de `Coffee` que maneja el número de shots de Espresso y su validación.
- **`Latte`**: Clase derivada de `Coffee` que maneja el tipo de leche y la opción de jarabe con validaciones.
- **`CoffeeMachine`**: Clase principal que maneja la interacción con el usuario y contiene un menú para seleccionar y preparar café.

## Instalación y Ejecución
1. Clona este repositorio o descarga los archivos.
2. Abre una terminal en la carpeta del proyecto.
3. Compila los archivos Java:
   ```sh
   javac *.java
   ```
4. Ejecuta el programa:
   ```sh
   java CoffeeMachine
   ```

## Ejemplo de Uso
El usuario puede interactuar con la máquina de café de la siguiente manera:
```
Welcome to the Coffee Machine!
Select an option to continue:
1. Espresso
2. Latte
3. Exit
Enter your choice (1, 2, or 3): 1
What Roast would you like? (light, medium, dark): dark
How many servings would you like? (a number please): 2
Grinding beans for Espresso...
Brewing your favorite Espresso...
You ordered a Espresso with a dark roast.
The caffeine level in your coffee is 150 mg.
You asked for 2 servings!
Every serving of Espresso costs 2.5$. Your total bill is 5.0$.
```

## Conclusión
Este ejercicio demuestra cómo un buen manejo de excepciones en Java puede hacer que un programa sea más robusto, evitando entradas inválidas y manteniendo la ejecución estable.

---

📌 **Desarrollado como parte del curso Amazon Junior Software Developer, enfocándose en el manejo de excepciones en Java.**

