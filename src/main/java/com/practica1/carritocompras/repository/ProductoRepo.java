package com.practica1.carritocompras.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practica1.carritocompras.model.Producto;

@Repository
public interface ProductoRepo extends JpaRepository<Producto, Long> {

}
