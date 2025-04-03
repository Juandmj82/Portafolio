package com.portafolio.crudproductos.repository;

import com.portafolio.crudproductos.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
}
