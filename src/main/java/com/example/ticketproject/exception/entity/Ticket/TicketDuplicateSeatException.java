package com.example.ticketproject.exception.entity.Ticket;

public class TicketDuplicateSeatException extends RuntimeException{
    public TicketDuplicateSeatException(String message){
        super(message);
    }
}
