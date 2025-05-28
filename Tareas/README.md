# Tareas - Sistema de Gestión de Tareas

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![JavaFX](https://img.shields.io/badge/JavaFX-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white)

## Descripción

Tareas es una aplicación de escritorio desarrollada en Java con JavaFX y Spring Boot para la gestión de tareas personales o de equipo. La aplicación permite crear, organizar y realizar un seguimiento de tareas de manera eficiente.

## Características

- Interfaz gráfica intuitiva con JavaFX
- Gestión de tareas (crear, editar, eliminar, marcar como completadas)
- Almacenamiento persistente con MySQL
- Arquitectura MVC (Modelo-Vista-Controlador)
- Desarrollado con Spring Boot para una configuración sencilla

# Captura de Pantalla

![Captura de Pantalla](/screenshots/consola.png)




## Requisitos Previos

- Java 21 o superior
- Maven 3.6.3 o superior
- MySQL Server 8.0 o superior
- Un IDE compatible con Java (IntelliJ IDEA, Eclipse, VS Code, etc.)

## Configuración del Proyecto

1. Clona el repositorio:
   ```bash
   git clone [URL_DEL_REPOSITORIO]
   cd Tareas
   ```

2. Configura la base de datos MySQL:
   - Crea una base de datos llamada `tareas_db`
   - Ajusta las credenciales en `src/main/resources/application.properties` si es necesario

3. Compila el proyecto:
   ```bash
   ./mvnw clean install
   ```

## Ejecución

1. Inicia la aplicación con Maven:
   ```bash
   ./mvnw spring-boot:run
   ```

2. O ejecuta directamente el archivo JAR generado en `target/`:
   ```bash
   java -jar target/Tareas-0.0.1-SNAPSHOT.jar
   ```

## Estructura del Proyecto

```
src/
├── main/
│   ├── java/com/example/
│   │   ├── config/          # Configuraciones de Spring
│   │   ├── controladores/   # Controladores JavaFX
│   │   ├── modelo/         # Entidades y modelos de datos
│   │   ├── repositorios/    # Repositorios de Spring Data JPA
│   │   ├── servicios/      # Lógica de negocio
│   │   └── TareasApplication.java  # Clase principal
│   └── resources/          # Recursos estáticos y configuración
└── test/                   # Pruebas unitarias y de integración
```

## Tecnologías Utilizadas

- **Backend**: Java 21, Spring Boot 3.4.3, Spring Data JPA
- **Base de Datos**: MySQL
- **Interfaz de Usuario**: JavaFX
- **Herramientas de Construcción**: Maven

## Contribución

Las contribuciones son bienvenidas. Por favor, lee las pautas de contribución antes de enviar pull requests.

## Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo [LICENSE](LICENSE) para más información.


## ✂️ Autor

Desarrollado por [Juan Diego Merchán](https://github.com/Juandmj82) - 2025 🚀
