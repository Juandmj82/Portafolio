# DockerBooksAPI

API REST para gestionar libros usando Spring Boot y PostgreSQL con base de datos ejecutándose en Docker.

---

## Tecnologías utilizadas

* Java 21
* Spring Boot 3
* PostgreSQL
* Docker
* Maven
* Postman (para pruebas)

---

## Descripción del proyecto

Este proyecto es una API REST simple para crear, leer, actualizar y eliminar libros en una base de datos PostgreSQL. La base de datos corre dentro de un contenedor Docker para facilitar la configuración y portabilidad del entorno.

---

## Configuración del entorno

1. Clonar el repositorio
2. Configurar las variables de entorno en `.env`:

   ```env
   POSTGRES_USER=
   POSTGRES_PASSWORD=
   POSTGRES_DB=

   SPRING_DATASOURCE_URL=
   SPRING_DATASOURCE_USERNAME=
   SPRING_DATASOURCE_PASSWORD=
   ```
3. Levantar el contenedor de Docker:

   ```bash
   docker-compose up -d
   ```
4. Ejecutar la aplicación Spring Boot.

---

## Endpoints principales

| Método | Ruta               | Descripción             |
| ------ | ------------------ | ----------------------- |
| GET    | `/api/libros`      | Listar todos los libros |
| GET    | `/api/libros/{id}` | Obtener libro por ID    |
| POST   | `/api/libros`      | Crear un nuevo libro    |
| PUT    | `/api/libros/{id}` | Actualizar un libro     |
| DELETE | `/api/libros/{id}` | Eliminar un libro       |

---

## Nuevos aprendizajes

### Uso de Docker para PostgreSQL

* **Contenedorización de la base de datos:** Aprendí a ejecutar PostgreSQL dentro de un contenedor Docker usando `docker-compose`. Esto elimina la necesidad de instalar y configurar PostgreSQL localmente, facilitando la portabilidad y replicación del entorno de desarrollo.

* **Persistencia de datos:** Configuré un volumen para que los datos se mantengan aunque el contenedor se reinicie o elimine, usando:

  ```yaml
  volumes:
    - ./postgres-data:/var/lib/postgresql/data
  ```

  Así, los datos no se pierden entre ejecuciones.

* **Variables de entorno:** Usé un archivo `.env` para gestionar de forma segura el usuario, contraseña y base de datos, y configuré el `docker-compose.yml` para leer esas variables y crear el contenedor con esas credenciales.

* **Depuración de errores comunes:** Entendí que la base de datos debe existir previamente o debe ser creada al iniciar el contenedor, porque Spring Boot no la crea automáticamente. Aprendí a conectar a la base de datos dentro del contenedor para verificar y crear la base de datos manualmente.


* **Conexión desde Spring Boot:** Configuré correctamente el datasource para que apunte al contenedor PostgreSQL, usando la URL con el puerto local (`localhost:5432`) mapeado al contenedor.

---

## Cómo evitar errores comunes

* Siempre verifica que la base de datos exista y que el usuario tenga permisos.
* Asegúrate de que el contenedor de PostgreSQL está levantado y escuchando en el puerto esperado.
* Usa comandos `docker exec` para acceder al contenedor y revisar logs o hacer operaciones directas en la base de datos.
* Mantén las variables de entorno actualizadas y bien sincronizadas entre Docker y Spring Boot.

---

## Próximos pasos

* Implementar autenticación y autorización.
* Añadir pruebas unitarias y de integración.
* Desplegar la aplicación en un entorno de producción con Docker Compose o Kubernetes.


## 📄 Licencia

Este proyecto está licenciado bajo la **MIT License**.

## ✂️ Autor

Desarrollado por [Juan Diego Merchán](https://github.com/Juandmj82) - 2025 🚀
