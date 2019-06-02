package com.example.springdemo.exceptions;

public class ProducerNotFoundException extends RuntimeException {
    public ProducerNotFoundException() {
        super("Producer not found!");
    }
}
