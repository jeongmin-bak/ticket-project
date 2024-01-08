package com.example.ticketproject.exception.entity.stadium;

public class StadiumNotFoundException extends RuntimeException{
    public StadiumNotFoundException(String message) {
        super(message);
    }
}
