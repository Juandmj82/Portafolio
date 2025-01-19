import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeneradorDeArchivo {

    //creamos un metodo para guardar el archivo
    public void guardarJson(Pelicula pelicula) throws IOException {
        //creamos un objeto de tipo gson
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        //creamos el FileWriter que es el encargado de guardar el archivo
        FileWriter escritura= new FileWriter(pelicula.title()+".json");
        //escribimos el archivo
        escritura.write(gson.toJson(pelicula));
        //cerramos el archivo
        escritura.close();

    }
}
