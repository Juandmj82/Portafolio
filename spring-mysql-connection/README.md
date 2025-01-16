# Conexión Spring y MySQL

## Descripción:
Este proyecto es una aplicación Spring Boot que se conecta a una base de datos MySQL para gestionar una lista de películas. La aplicación permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en una tabla de películas.

## Tecnologías Utilizadas:
- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Lombok

## Instrucciones para Configurar y Ejecutar el Proyecto:

1. **Instalación del JDK:**
    - Descarga e instala la última versión del JDK desde el sitio oficial de Oracle o adopta OpenJDK.
    - Configura las variables de entorno `JAVA_HOME` y `PATH` para que apunten a la instalación del JDK.

2. **Instalación de un IDE:**
    - Descarga e instala un entorno de desarrollo integrado (IDE) como IntelliJ IDEA, Eclipse o NetBeans.
    - Configura el IDE para que utilice el JDK instalado.

3. **Configuración de MySQL:**
    - Asegúrate de tener MySQL instalado y en funcionamiento.
    - Crea una base de datos llamada `moviedb`.
    - Configura un usuario y una contraseña para acceder a la base de datos.

4. **Crear el Proyecto:**
    - Abre tu IDE y crea un nuevo proyecto Spring Boot.
    - Nombra el proyecto `spring_mysql_connection`.

5. **Estructura del Proyecto:**
    - Crea los siguientes paquetes y clases dentro del paquete principal `com.example.spring_mysql_connection`:
        - `model`: Contiene la clase `Movie`.
        - `repository`: Contiene la interfaz `MovieRepository`.
        - `service`: Contiene la clase `MovieService`.
        - `controller`: Contiene la clase `MovieController`.
    - Configura las propiedades de conexión a la base de datos en el archivo `application.properties`.

6. **Archivo `application.properties`:**
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3307/moviedb
   spring.datasource.username=root
   spring.datasource.password=
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

7. **Ejecutar la Aplicación:**
    - Ejecuta la clase `SpringMysqlConnectionApplication` para iniciar la aplicación.
    - La aplicación estará disponible en `http://localhost:8080`.


## Información de Contacto:
- **Nombre:** Juan Diego Merchán
- **Correo Electrónico:** juandiegosdb@gmail.com
- **LinkedIn:** [https://www.linkedin.com/in/jdmj/]


## Licencia:
Este proyecto está bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.
