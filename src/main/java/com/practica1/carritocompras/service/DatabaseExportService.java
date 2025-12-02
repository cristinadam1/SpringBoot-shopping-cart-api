package com.practica1.carritocompras.service;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica1.carritocompras.model.Producto;
import com.practica1.carritocompras.repository.ProductoRepo;

@Service
public class DatabaseExportService {

    @Autowired
    private ProductoRepo productRepo;

    public byte[] exportDatabaseToSql() {
        List<Producto> productos = productRepo.findAll();
        StringBuilder sql = new StringBuilder();

        for (Producto p : productos) {
            sql.append("INSERT INTO producto (nombre, precio) VALUES ('")
               .append(p.getName().replace("'", "''"))
               .append("', ")
               .append(p.getPrice())
               .append(");\n");
        }
        return sql.toString().getBytes(StandardCharsets.UTF_8);
    }
}