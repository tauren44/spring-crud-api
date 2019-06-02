package com.example.springdemo.exceptions;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException() {
        super("Product not found!");
    }
}
