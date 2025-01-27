# Screenmatch

Screenmatch es una aplicación desarrollada en Java utilizando el framework Spring Boot. Su objetivo es permitir a los usuarios buscar y gestionar series de televisión, proporcionando información detallada sobre cada serie y sus episodios. La aplicación se conecta a una API externa para obtener datos sobre las series y utiliza una base de datos MySQL para almacenar la información.

## Características

- Búsqueda de series por título.
- Visualización de episodios de una serie.
- Filtrado de series por género y evaluación.
- Almacenamiento de series y episodios en una base de datos.
- Interfaz de línea de comandos para la interacción del usuario.

## Tecnologías Utilizadas

- **Java 17**: Lenguaje de programación utilizado para el desarrollo.
- **Spring Boot**: Framework para la creación de aplicaciones Java.
- **Spring Data JPA**: Para la gestión de la base de datos.
- **MySQL**: Base de datos utilizada para almacenar la información de las series.
- **Jackson**: Para la conversión de JSON a objetos Java.
- **Maven**: Herramienta de gestión de proyectos y dependencias.

## Requisitos Previos

- JDK 17 o superior.
- MySQL Server.
- Maven.

## Instalación

### Clonar el repositorio

```bash
git clone https://github.com/Juandmj82/Portafolio.git
cd screenmatch
```

### Configurar la base de datos

Crear una base de datos en MySQL llamada `alura_series`.
Configurar el archivo `application.properties` con las credenciales de la base de datos.

### Construir el proyecto

```bash
mvn clean install
```

### Ejecutar la aplicación

```bash
mvn spring-boot:run
```

## Uso

Al iniciar la aplicación, se presentará un menú en la línea de comandos donde el usuario podrá seleccionar diferentes opciones para buscar series, ver episodios, y más.

## Contribuciones

Las contribuciones son bienvenidas. Si deseas contribuir, por favor sigue estos pasos:

1. Haz un fork del proyecto.
2. Crea una nueva rama (`git checkout -b feature/nueva-caracteristica`).
3. Realiza tus cambios y haz un commit (`git commit -m 'Añadir nueva característica'`).
4. Envía un pull request.

## Licencia

Este proyecto está licenciado bajo la Apache License 2.0.

## Contacto

Para más información, puedes contactar a [Juandmj82](https://github.com/Juandmj82).

¡Gracias por tu interés en el proyecto Screenmatch!