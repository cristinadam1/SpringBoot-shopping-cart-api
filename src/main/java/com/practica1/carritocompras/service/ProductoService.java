package com.practica1.carritocompras.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica1.carritocompras.repository.ProductoRepo;
import com.practica1.carritocompras.model.Producto;
import java.util.List;

@Service
public class ProductoService {
	@Autowired
    private ProductoRepo productRepo;

    public List<Producto> getAllProducts() {
        return productRepo.findAll();
    }

    public Producto getProductById(Long id) {
        return productRepo.findById(id).orElse(null);
    }

    public void saveProduct(Producto product) {
        productRepo.save(product);
    }

    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }
    public List<Producto> findByCategory(String category) {
        return productRepo.findByCategory(category);
    }
    
    public Producto updateProduct(Long id, Producto productDetails) {
        Producto product = productRepo.findById(id).orElse(null);
        if (product != null) {
            product.setName(productDetails.getName());
            product.setPrice(productDetails.getPrice());
            product.setDescription(productDetails.getDescription());
            product.setCategory(productDetails.getCategory());
            return productRepo.save(product);
        }
        return null;
    }

}


