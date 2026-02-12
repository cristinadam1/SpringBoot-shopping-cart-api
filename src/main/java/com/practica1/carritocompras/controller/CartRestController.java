package com.practica1.carritocompras.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;import java.util.Map;

@RestController
@RequestMapping("/api/carts")
public class CartRestController {

    @PostMapping
    public ResponseEntity<Map<String, Object>> createOrder(@RequestBody Object orderRequest) {

        System.out.println("Pedido recibido desde Android: " + orderRequest);

        Map<String, Object> response = new HashMap<>();
        response.put("id", 12345); 
        response.put("status", "success");

        return ResponseEntity.ok(response);
    }
}