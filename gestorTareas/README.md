markdown

Verify

Open In Editor
Run
Copy code
# Gestor de Tareas

## Descripción
Gestor de Tareas es una aplicación que permite a los usuarios crear, gestionar y eliminar tareas. La aplicación está construida utilizando Spring Boot y JPA para la gestión de datos, y utiliza una base de datos MySQL para almacenar la información.

## Características
- Crear, leer, actualizar y eliminar tareas.
- Asociar tareas a usuarios.
- Priorizar tareas (ALTA, MEDIA, BAJA).
- Visualizar todas las tareas y detalles de tareas individuales.
- **Manejo de Excepciones**:
    - **ResourceNotFoundException**: Lanza esta excepción cuando se intenta acceder a un recurso que no existe (por ejemplo, un usuario o tarea por ID).
    - **ConflictException**: Lanza esta excepción cuando se intenta crear un recurso que ya existe (por ejemplo, un usuario con un correo electrónico ya registrado).

## Tecnologías Utilizadas
- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Hibernate
- Lombok (opcional, si lo usas)

## Requisitos Previos
- JDK 17 o superior
- MySQL Server
- Maven

## Configuración del Proyecto

1. **Clonar el Repositorio**
   ```bash
   git clone https://github.com/tu_usuario/gestorTareas.git
   cd gestorTareas
Configurar la Base de Datos

Crea una base de datos en MySQL llamada gestor_tareas.
Asegúrate de que el usuario y la contraseña de la base de datos estén configurados en el archivo application.properties:
properties

Verify

Open In Editor
Run
Copy code
spring.datasource.url=jdbc:mysql://localhost:3307/gestor_tareas
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
Construir el Proyecto

bash

Verify

Open In Editor
Run
Copy code
mvn clean install
Ejecutar la Aplicación

bash

Verify

Open In Editor
Run
Copy code
mvn spring-boot:run
Uso
La API está disponible en http://localhost:8080/api/tasks.
Puedes usar herramientas como Postman o Insomnia para interactuar con la API.
Endpoints
GET /api/tasks: Obtener todas las tareas.
GET /api/tasks/{id}: Obtener una tarea por ID.
POST /api/tasks: Crear una nueva tarea.
DELETE /api/tasks/{id}: Eliminar una tarea por ID.
Lo mismo puedes hacer para usuarios:
GET /api/users: Obtener todos los usuarios.
GET /api/users/{id}: Obtener un usuario por ID.
POST /api/users: Crear un nuevo usuario.
DELETE /api/users/{id}: Eliminar un usuario por ID.
Contribuciones
Las contribuciones son bienvenidas. Si deseas contribuir, por favor abre un issue o envía un pull request.

Licencia
Este proyecto está bajo la Licencia MIT. Para más detalles, consulta el archivo LICENSE.


