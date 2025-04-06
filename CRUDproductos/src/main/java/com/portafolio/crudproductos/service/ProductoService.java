package com.portafolio.crudproductos.service;

import com.portafolio.crudproductos.model.Producto;
import java.util.List;

public interface ProductoService {
    List<Producto> obtenerTodos();  // Retorna todos los productos
    Producto guardarProducto(Producto producto);  // Guarda o actualiza un producto
    Producto obtenerPorId(Long id);  // Busca un producto por ID
    void eliminarProducto(Long id);  // Elimina un producto por ID
    boolean existeProducto(Long id);  // Verifica si un producto existe
}