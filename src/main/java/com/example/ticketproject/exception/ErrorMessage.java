package com.example.ticketproject.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class ErrorMessage {
    private String message;
    private HttpStatus error;
    private int status;
}