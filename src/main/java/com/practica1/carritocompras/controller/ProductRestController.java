package com.practica1.carritocompras.controller;

import com.practica1.carritocompras.model.Producto;
import com.practica1.carritocompras.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController 
@RequestMapping("/api/products") 
public class ProductRestController {

    @Autowired
    private ProductoService productService;

    @GetMapping
    public List<Producto> getAllProducts(@RequestParam(name = "category", required = false) String category) {
        if (category != null && !category.isEmpty()) {
            return productService.findByCategory(category);
        }
        return productService.getAllProducts();
    }

    @PostMapping
    public void addProduct(@RequestBody Producto product) {
        productService.saveProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Producto> editProduct(@PathVariable Long id, @RequestBody Producto productDetails) {
        Producto updatedProduct = productService.updateProduct(id, productDetails);
        if (updatedProduct == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedProduct);
    }
}