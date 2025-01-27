# MusicBox

MusicBox es una aplicación que permite buscar información sobre cantantes y canciones utilizando la API de Last.fm. La aplicación guarda los datos en una base de datos y proporciona un menú interactivo para que los usuarios puedan buscar cantantes y canciones por nombre y artista.

## Características

- Búsqueda de cantantes por nombre.
- Búsqueda de canciones por nombre y artista.
- Almacenamiento de datos en una base de datos.
- Menú interactivo para la interacción del usuario.

## Requisitos Previos

- Java 17 o superior.
- Maven o Gradle para la gestión de dependencias.
- MySQL para la base de datos.
- Una API key de Last.fm.

## Configuración del Entorno

### Variables de Entorno

La API key de Last.fm debe ser configurada como una variable de entorno para evitar exponerla en el código fuente.

#### En Linux/macOS

Agrega la siguiente línea a tu archivo de configuración del shell (`.bashrc`, `.zshrc`, etc.):

```sh
export LASTFM_API_KEY=tu_api_key_aqui
```

Luego, recarga la configuración de tu shell:

```sh
source ~/.bashrc  # o ~/.zshrc dependiendo de tu shell
```

#### En Windows

Configura la variable de entorno en el Sistema de Propiedades Avanzadas:

1. Abre el Panel de Control.
2. Ve a Sistema y Seguridad > Sistema > Configuración avanzada del sistema.
3. Haz clic en el botón Variables de entorno.
4. En la sección Variables del sistema, haz clic en Nuevo y agrega:
    - Nombre de la variable: `LASTFM_API_KEY`
    - Valor de la variable: `tu_api_key_aqui`

### Base de Datos

Configura tu base de datos MySQL y crea las tablas necesarias. Puedes usar el siguiente script SQL para crear las tablas:

```sql
CREATE DATABASE musicbox;

USE musicbox;

CREATE TABLE cantantes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL UNIQUE,
    urlBiografia VARCHAR(255) NOT NULL
);

CREATE TABLE canciones (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    url VARCHAR(255) NOT NULL,
    oyentes INT NOT NULL,
    artista VARCHAR(255) NOT NULL,
    cantante_id BIGINT NOT NULL,
    FOREIGN KEY (cantante_id) REFERENCES cantantes(id)
);
```

### Configuración de la Aplicación

Configura tu archivo `application.properties` para conectar a la base de datos:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/musicbox
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
```

## Ejecutar la Aplicación

Para ejecutar la aplicación, sigue estos pasos:

1. Clona el repositorio:

    ```sh
    git clone https://github.com/tu_usuario/musicbox.git
    cd musicbox
    ```

2. Compila y ejecuta la aplicación:

    ```sh
    ./mvnw spring-boot:run
    ```

3. Usa el menú interactivo para buscar cantantes y canciones.

## Estructura del Proyecto

- `src/main/java/com/example/musicbox`: Contiene el código fuente de la aplicación.
- `src/main/resources`: Contiene los archivos de configuración y recursos.
- `src/test/java/com/example/musicbox`: Contiene las pruebas unitarias y de integración.

## Contribuir

Las contribuciones son bienvenidas. Por favor, abre un issue o envía un pull request si encuentras algún problema o deseas agregar nuevas características.

## Licencia

Este proyecto está licenciado bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.


## Información de Contacto:
- **Nombre:** Juan Diego Merchán
- **Correo Electrónico:** juandiegosdb@gmail.com
- **LinkedIn:** [https://www.linkedin.com/in/jdmj/]


Si tienes alguna pregunta o sugerencia, puedes contactarme a través de [mi correo electrónico](mailto:tu_correo@example.com).

---

¡Gracias por usar MusicBox!