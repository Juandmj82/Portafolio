# Consulta de Películas de Star Wars

## Descripción:
Este proyecto es una aplicación de consola en Java que permite consultar información sobre películas de Star Wars utilizando la API de SWAPI (Star Wars API). La aplicación permite al usuario ingresar el número de la película y obtener detalles como el título, el episodio, el texto de apertura, el director, el productor y la fecha de lanzamiento. Además, guarda la información de la película en un archivo JSON.

## Tecnologías Utilizadas:
- Java
- Gson (para la serialización y deserialización de JSON)
- HTTP Client (para realizar solicitudes HTTP)

## Instrucciones para Configurar y Ejecutar el Proyecto:

1. **Instalación del JDK:**
    - Descarga e instala la última versión del JDK desde el sitio oficial de Oracle o adopta OpenJDK.
    - Configura las variables de entorno `JAVA_HOME` y `PATH` para que apunten a la instalación del JDK.

2. **Instalación de un IDE:**
    - Descarga e instala un entorno de desarrollo integrado (IDE) como IntelliJ IDEA, Eclipse o NetBeans.
    - Configura el IDE para que utilice el JDK instalado.

3. **Configuración del Proyecto:**
    - Abre tu IDE y crea un nuevo proyecto Java.
    - Nombra el proyecto `ConsultaPeliculasStarWars`.

4. **Añadir Dependencias:**
    - Añade las dependencias de Gson y HTTP Client a tu proyecto. Si estás utilizando Maven, añade las siguientes dependencias en tu archivo `pom.xml`:
      ```xml
      <dependency>
          <groupId>com.google.code.gson</groupId>
          <artifactId>gson</artifactId>
          <version>2.8.8</version>
      </dependency>
      ```

5. **Estructura del Proyecto:**
    - Crea las siguientes clases dentro del paquete principal `com.example.consultapeliculas`:
        - `Principal`: Contiene el método `main` que es el punto de entrada de la aplicación.
        - `Pelicula`: Un record que representa una película.
        - `ConsultaPelicula`: Contiene el método para consultar la API de SWAPI y obtener la información de la película.
        - `GeneradorDeArchivo`: Contiene el método para guardar la información de la película en un archivo JSON.

6. **Ejecutar la Aplicación:**
    - Ejecuta la clase `Principal` para iniciar la aplicación.
    - Sigue las instrucciones en la consola para consultar la información de una película y guardarla en un archivo JSON.

## Ejemplo de Uso:
Al consultar la película con el número 4, el archivo `A New Hope.json` se registraría con el siguiente contenido:
```json
{
  "title": "The Phantom Menace",
  "episode_id": 1,
  "opening_crawl": "Turmoil has engulfed the\r\nGalactic Republic. The taxation\r\nof trade routes to outlying star\r\nsystems is in dispute.\r\n\r\nHoping to resolve the matter\r\nwith a blockade of deadly\r\nbattleships, the greedy Trade\r\nFederation has stopped all\r\nshipping to the small planet\r\nof Naboo.\r\n\r\nWhile the Congress of the\r\nRepublic endlessly debates\r\nthis alarming chain of events,\r\nthe Supreme Chancellor has\r\nsecretly dispatched two Jedi\r\nKnights, the guardians of\r\npeace and justice in the\r\ngalaxy, to settle the conflict....",
  "director": "George Lucas",
  "producer": "Rick McCallum",
  "release_date": "1999-05-19"
}
```

## Información de Contacto:
- **Nombre:** Juan Diego Merchán
- **Correo Electrónico:** juandiegosdb@gmail.com
- **LinkedIn:** [https://www.linkedin.com/in/jdmj/]

## Licencia:
Este proyecto está bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.