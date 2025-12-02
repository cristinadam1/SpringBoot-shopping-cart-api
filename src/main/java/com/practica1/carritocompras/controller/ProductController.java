package com.practica1.carritocompras.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.practica1.carritocompras.model.Producto;
import com.practica1.carritocompras.service.ProductoService;

@Controller
@RequestMapping("/products")
public class ProductController {
	@Autowired
    private ProductoService productService;
	@GetMapping
    public String getProductsPage(Model model) {
		model.addAttribute("products", productService.getAllProducts());
        return "products"; // Devuelve products.html desde las plantillas
    }
	@GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("product", new Producto());
        return "product_form"; // templates/product_form.html
    }
	@PostMapping("/add")
	   public String addProduct(@RequestParam String name, @RequestParam double price) {
	        Producto product = new Producto();
	        product.setName(name);
	        product.setPrice(price);
	        productService.saveProduct(product);
	        return "redirect:/admin";  // Redirigir correctamente a /admin
	    }
	
	@PostMapping("/edit/{id}")
    public String editProduct(@PathVariable Long id, @RequestParam String name, @RequestParam double price) {
        Producto product = productService.getProductById(id);
        if (product != null) {
            product.setName(name);
            product.setPrice(price);
            productService.saveProduct(product);
        }
        return "redirect:/admin";  // Redirigir correctamente a /admin
    }
	
	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable Long id, Model model) {
	    Producto product = productService.getProductById(id);
	    if (product != null) {
	        model.addAttribute("product", product);
	        return "product_edit_form"; 
	    }
	    return "redirect:/admin";
	}

	
	@PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/admin";  // Redirigir correctamente a /admin
    }
}