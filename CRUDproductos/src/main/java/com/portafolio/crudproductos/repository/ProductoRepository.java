package com.portafolio.crudproductos.repository;

import com.portafolio.crudproductos.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

// Extiende JpaRepository para heredar métodos CRUD básicos
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // No necesita implementación: Spring Data JPA crea los métodos automáticamente
}
