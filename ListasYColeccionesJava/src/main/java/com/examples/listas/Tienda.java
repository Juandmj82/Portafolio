package com.examples.listas;

import java.util.ArrayList;
import java.util.List;


public class Tienda{
    //Atributos
    private List<Producto> listaProductos;

    // Constructor

    public Tienda(){
        this.listaProductos = new ArrayList<>();
    }

    // Métodos

    //Método para agregar un producto a la lista

    public void agregarProducto(Producto producto){
        listaProductos.add(producto);
    }

    //Método para eliminar producto, se usa lambda para filtrar la lista y reducir uso de código

    public void eliminarProducto(String nombre){
        listaProductos.removeIf(producto -> producto.getNombre().equalsIgnoreCase(nombre));
    }
    // Método para buscar producto por nombre

    public Producto buscarProducto(String nombre){
        for(Producto producto : listaProductos){
            if(producto.getNombre().equalsIgnoreCase(nombre)){
                return producto;
            }

        }
        return null;
    }

    // Método para mostrar todos los productos

    public void mostrarProductos(){
        for(Producto producto : listaProductos){
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Precio: " + producto.getPrecio());
            System.out.println("Cantidad: " + producto.getCantidad());
            System.out.println("--------------------------------");
        }
    }


}