package com.examples.listas;

import com.examples.listas.Producto;
import com.examples.listas.Tienda;

public class Main {
    public static void main(String[] args) {
        //Instanciamos la clase Tienda
        Tienda tienda = new Tienda();

        //instanciamos la clase Producto creando nuevos productos

        Producto producto1 = new Producto("Camiseta", 20.000, 10);
        Producto producto2 = new Producto("Laptop", 2345.000, 30);
        Producto producto3 = new Producto ("Tablet", 1000.000, 10);

        //agregar productos a la tienda

        tienda.agregarProducto(producto1);
        tienda.agregarProducto(producto2);
        tienda.agregarProducto(producto3);

        // Mostrar todos los productos

        System.out.println("Lista de productos en la tienda: ");
        tienda.mostrarProductos();

        // Buscar productos
        Producto productoBuscado  = tienda.buscarProducto("camiseta");
        if(productoBuscado != null){
            System.out.println("Nombre producto: " + productoBuscado.getNombre());
            System.out.println("Precio: " + productoBuscado.getPrecio());
            System.out.println("Cantidad: " + productoBuscado.getCantidad());
            System.out.println("--------------------------------");
        }else{
            System.out.println("Producto no encontrado.");
        }

        // Eliminar productos
        tienda.eliminarProducto("Tablet");
        System.out.println("Lista de productos depués de eliminar la Tablet");
        tienda.mostrarProductos();




    }
}
