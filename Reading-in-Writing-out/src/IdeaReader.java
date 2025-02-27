import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Clase IdeaReader
 * Se encarga de leer el contenido de un archivo de texto y devolverlo como una cadena de texto.
 */
public class IdeaReader {

    /**
     * Método que lee el contenido de un archivo y lo devuelve como String.
     * filePath Ruta del archivo a leer.
     *  returna el contenido del archivo en formato String.
     */
    public String readIdea(String filePath) {
        String fileContents = ""; // Variable para almacenar el contenido del archivo.
        File file = new File(filePath); // Se crea un objeto File con la ruta del archivo.

        // Se usa FileInputStream para leer los datos del archivo.
        try (FileInputStream inputStream = new FileInputStream(file)) {

            // Lee todos los bytes del archivo y los almacena en un array de bytes
            byte[] fileContentsAsBytes = inputStream.readAllBytes();

            // Convierte los bytes leídos en una cadena de texto
            fileContents = new String(fileContentsAsBytes);

        } catch (FileNotFoundException fileNotFoundException) {
            // Manejo de error si el archivo no se encuentra en la ruta especificada.
            System.err.println("File Not Found! Please check the file path and try again!");

        } catch (IOException ioException) {
            // Manejo de errores de entrada/salida en la lectura del archivo.
            System.err.println(ioException.getMessage());
        }

        return fileContents; // Retorna el contenido leído del archivo.
    }
}
