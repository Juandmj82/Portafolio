package com.aluracursos.screenmatch.principal;

import java.util.Arrays;
import java.util.List;

public class EjemploStreams {
    //creamos un método para mostrar el ejemplo
    public void muestraEjemplo(){
        //creamos una lista de nombres
        List<String> nombres = Arrays.asList("Brenda", "Erick", "Génesys", "Luis", "María Fernanda");
        //nos permite hacer operaciones encadenadas
        nombres.stream()
                //ordenar alfabéticamente
                .sorted()
                //filtrar los nombres que empiecen con la letra B
                .limit(4)
                //filtrar los nombres que empiecen con la letra L
                .filter(nombre -> nombre.startsWith("L"))
                //mapear (convertir)los nombres a mayúsculas
                .map(n -> n.toUpperCase())
                //pedimos que se impriman los elementos
                .forEach(System.out::println);

    }
}
