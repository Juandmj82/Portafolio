# Vehicle Management System

## Descripción

Este es un programa de gestión de vehículos que permite a los usuarios crear instancias de diferentes tipos de vehículos (Coches y Motocicletas), calcular su eficiencia de combustible y realizar acciones como iniciar y detener el vehículo. El programa utiliza conceptos de programación orientada a objetos, incluyendo herencia y polimorfismo.

## Características

- Permite al usuario seleccionar entre un coche y una motocicleta.
- Calcula la eficiencia de combustible en kilómetros por litro (km/L).
- Permite iniciar y detener el vehículo.
- Interfaz de usuario simple en la consola.

## Estructura del Proyecto

El proyecto está compuesto por las siguientes clases:

- **Vehicle**: Clase abstracta que define la estructura básica para los vehículos.
- **Car**: Clase que extiende `Vehicle` y representa un coche.
- **Motorcycle**: Clase que extiende `Vehicle` y representa una motocicleta.
- **Main**: Clase principal que contiene el método `main` y gestiona la interacción con el usuario.

## Instalación

1. Clona este repositorio en tu máquina local:
   ```bash
   git clone <URL_DEL_REPOSITORIO>
   ```
2. Abre el proyecto en tu IDE favorito (por ejemplo, IntelliJ IDEA).
3. Asegúrate de tener Java instalado en tu máquina. Puedes descargarlo desde [aquí](https://www.oracle.com/java/technologies/javase-downloads.html).

## Uso

1. Ejecuta la clase `Main`.
2. Selecciona un tipo de vehículo ingresando el número correspondiente:
    - `1` para un coche
    - `2` para una motocicleta
    - `0` para salir del programa
3. Ingresa la capacidad de combustible (en litros) y el consumo de combustible (en litros por 100 km).
4. El programa calculará y mostrará la eficiencia de combustible y permitirá iniciar y detener el vehículo.

## Ejemplo de Salida

```
*********** Welcome to the vehicle program ********

Choose a vehicle: 1. Car 2. Motorcycle 0. Exit
1
Enter fuel capacity (liters):
14
Enter fuel consumption (liters/100km):
6
Car is starting...
Fuel Efficiency: 233.33 km
Car is stopping...

Choose a vehicle: 1. Car 2. Motorcycle 0. Exit
```

## Contribuciones

Las contribuciones son bienvenidas. Si deseas contribuir, por favor sigue estos pasos:

1. Haz un fork del repositorio.
2. Crea una nueva rama (`git checkout -b feature/nueva-caracteristica`).
3. Realiza tus cambios y haz commit (`git commit -m 'Añadir nueva característica'`).
4. Haz push a la rama (`git push origin feature/nueva-caracteristica`).
5. Abre un Pull Request.

## Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo LICENSE para más detalles.