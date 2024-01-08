package com.example.ticketproject.exception.entity.user;

public class UserDuplicatedException extends RuntimeException{
    public UserDuplicatedException(String message) {
        super(message);
    }
}
