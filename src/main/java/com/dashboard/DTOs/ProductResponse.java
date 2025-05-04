package com.dashboard.DTOs;

import com.dashboard.Entities.Product;

public class ProductResponse {
    private Long id;
    private String name;
    private double price;
    //private int cantidad;

    public ProductResponse(Product product) {
        //this.id = (long) product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        //this.cantidad = product.get;
    }


    
}
