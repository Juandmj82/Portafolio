import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Clase IdeaWriter
 * Permite escribir una idea en un archivo de texto.
 */
public class IdeaWriter {

    /**
     * Método que escribe el contenido en un archivo de texto.
     * filePath Ruta donde se creará el archivo.
     * fileContents Contenido que se escribirá en el archivo.
     */
    public void writeIdea(String filePath, String fileContents) {
        File file = new File(filePath); // Se crea un objeto File con la ruta especificada.
        byte[] fileContentsAsBytes = fileContents.getBytes(StandardCharsets.UTF_8); // Convierte el contenido en bytes.

        // Se usa FileOutputStream para escribir en el archivo.
        try (FileOutputStream outputStream = new FileOutputStream(file)) {

            // Escribe los bytes en el archivo
            outputStream.write(fileContentsAsBytes);

        } catch (FileNotFoundException fileNotFoundException) {
            // Manejo de error si el archivo no se encuentra o no se puede crear.
            System.err.println("File not found! Please check the path and try again!");
        } catch (IOException ioException) {
            // Manejo de error si ocurre un problema al escribir en el archivo.
            System.err.println(ioException.getMessage());
        }
    }
}
