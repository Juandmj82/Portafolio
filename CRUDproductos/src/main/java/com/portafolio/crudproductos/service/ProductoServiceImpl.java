package com.portafolio.crudproductos.service;

import com.portafolio.crudproductos.model.Producto;
import com.portafolio.crudproductos.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  // Marca esta clase como un servicio de Spring (capa de lógica de negocio)
public class ProductoServiceImpl implements ProductoService {

    @Autowired  // Inyección automática del repositorio que accede a la base de datos
    private ProductoRepository productoRepository;

    // =========================================
    // OBTENER TODOS LOS PRODUCTOS
    // =========================================
    @Override
    @Transactional(readOnly = true) //solo lectura
    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();  // Devuelve todos los productos de la base de datos
    }

    // =========================================
    // GUARDAR UN PRODUCTO (nuevo o editado)
    // =========================================
    @Override
    @Transactional //Aplica transacciones automáticas
    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);  // Guarda el producto y lo retorna
    }

    // =========================================
    // OBTENER UN PRODUCTO POR SU ID
    // =========================================
    @Override
    @Transactional(readOnly = true) //solo lectura
    public Producto obtenerPorId(Long id) {
        // Busca el producto por ID, si no lo encuentra lanza una excepción
        return productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));
    }

    // =========================================
    // ELIMINAR UN PRODUCTO POR SU ID
    // =========================================
    @Override
    @Transactional //Aplica transacciones automáticas
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);  // Elimina el producto con el ID dado
    }

    // =========================================
    // VERIFICAR SI UN PRODUCTO EXISTE POR SU ID
    // =========================================
    @Override
    @Transactional(readOnly = true)
    public boolean existeProducto(Long id) {
        return productoRepository.existsById(id);  // Devuelve true si el producto existe
    }
}