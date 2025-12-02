package com.practica1.carritocompras.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "producto")

public class Producto {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("productoId") 
    private Long id;

	@JsonProperty("productoNombre") 
	@Column(name = "nombre")
    private String name;
	@Column(name = "precio")
    private Double price;

    public Producto(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    
    public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public Producto() {
		super();
	}


	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto product = (Producto) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}