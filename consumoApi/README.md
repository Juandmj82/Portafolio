# Consumir API de OMDB y Mostrar Datos por Consola en Java con Spring Boot

## Descripción:
Este proyecto demuestra cómo consumir la API de OMDB, convertir datos JSON en objetos DTO utilizando clases de tipo `record`, y mostrar los datos por consola en una aplicación Spring Boot. La aplicación es interactiva y permite al usuario realizar múltiples consultas. Incluye un mensaje de bienvenida y mejoras estéticas para una mejor experiencia de usuario.

## Tecnologías Utilizadas:
- Spring Boot
- API REST (OMDB)
- Manejo de Excepciones
- Gson para conversión de JSON
- Variables de entorno para manejar API keys de manera segura

## Configuración:

### Configuración de la Variable de Entorno en IntelliJ IDEA

Para asegurarte de que la variable de entorno esté configurada correctamente en IntelliJ IDEA, sigue estos pasos:

1. **Abre tu proyecto en IntelliJ IDEA.**
2. **Ve a la configuración de ejecución:**
    - En la parte superior derecha de la ventana de IntelliJ, verás un menú desplegable donde puedes seleccionar la configuración de ejecución. Haz clic en el ícono de configuración (un pequeño engranaje) al lado de este menú.
    - Selecciona "Edit Configurations...". Esto abrirá una ventana donde puedes ver y editar las configuraciones de ejecución.
3. **Selecciona tu configuración de aplicación:**
    - En la lista de configuraciones, selecciona la que corresponde a tu aplicación Spring Boot (debería tener el nombre de tu clase principal, `ConsumoApiApplication`).
4. **Configura las variables de entorno:**
    - Busca el campo llamado "Environment variables" (Variables de entorno).
    - Haz clic en el ícono de tres puntos ... al lado de este campo.
    - En la ventana que se abre, puedes agregar una nueva variable de entorno. Haz clic en el botón `+` y agrega `OMDB_API_KEY` como nombre y tu clave de API como valor.
    - Haz clic en "OK" para cerrar la ventana de variables de entorno y luego en "OK" nuevamente para cerrar la ventana de configuraciones.

### Configuración Alternativa (Opcional)

Si prefieres configurar la variable de entorno a nivel de sistema, puedes hacerlo de la siguiente manera:

- **En Windows:**
  ```sh
  setx OMDB_API_KEY "tu_api_key"
  ```
- **En macOS/Linux:**
  ```sh
  export OMDB_API_KEY="tu_api_key"
  ```

## Estructura del Proyecto:
- `com.example.consumoApi.ConsumoApiApplication.java`: Clase principal que inicia la aplicación Spring Boot.
- `com.example.consumoApi.ApiClient.java`: Clase que consume la API de OMDB y obtiene datos.
- `com.example.dto.Movie.java`: Clase DTO de tipo `record` que representa los datos de una película.
- `src/main/resources/application.properties`: Archivo de propiedades para configurar la aplicación.

## Uso:
1. Ejecuta la clase `ConsumoApiApplication` para iniciar la aplicación.
2. Ingresa el título de la película que deseas buscar cuando se te solicite.
3. La aplicación consumirá la API de OMDB, obtendrá los datos de la película y los mostrará por consola.
4. Puedes realizar múltiples consultas. Escribe "salir" para terminar la aplicación.

## Información de Contacto:
- **Nombre:** Juan Diego Merchán
- **Correo Electrónico:** juandiegosdb@gmail.com
- **LinkedIn:** [https://www.linkedin.com/in/juan-diego-merch%C3%A1n-321200b4/]

## Licencia:
Este proyecto está bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.