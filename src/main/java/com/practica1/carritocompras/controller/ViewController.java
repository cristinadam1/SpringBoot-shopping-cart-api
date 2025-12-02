package com.practica1.carritocompras.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.practica1.carritocompras.model.Producto;
import com.practica1.carritocompras.service.ProductoService;
@Controller
public class ViewController {
	
	@Autowired
    private ProductoService productService;
	
	
	@GetMapping({"/", "/index"})
	  public String index(Model model) {
	    return "index";     // templates/index.html
	  }

	  @GetMapping("/admin")
	  public String admin(Model model) {
		List<Producto> productos = productService.getAllProducts();
		System.out.println("Productos encontrados: " + productos.size());
		model.addAttribute("products", productService.getAllProducts());
	    return "admin";     // templates/admin.html
	  }

	//  @GetMapping("/login")
	//  public String login() {
	 //   return "login";     // templates/login.html
	//  }
}
