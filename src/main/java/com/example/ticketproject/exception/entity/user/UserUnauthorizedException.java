package com.example.ticketproject.exception.entity.user;

public class UserUnauthorizedException extends RuntimeException{
    public UserUnauthorizedException(String message) {
        super(message);
    }
}
