import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner lectura = new Scanner (System.in);
        //creamos un objeto de tipo consulta
        ConsultaPelicula consulta = new ConsultaPelicula();
        System.out.println("Ingrese el numero de la pelicula de star wars que quiere consultar: ");
        //creamos un try catch para manejar la excepcion
        try {
            var numeroDePelicula = Integer.valueOf(lectura.nextLine());
            //creamos una consulta
            Pelicula pelicula = consulta.buscaPelicula(numeroDePelicula);
            System.out.println(pelicula);
            GeneradorDeArchivo generador = new GeneradorDeArchivo();
            generador.guardarJson(pelicula);
            //creamos un catch para manejar la excepcion de entrada inválida
        }catch(NumberFormatException | IOException e){
            System.out.println("Número no encontrado" + e.getMessage());

        }catch(RuntimeException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando la aplicación");
        }

    }
}
