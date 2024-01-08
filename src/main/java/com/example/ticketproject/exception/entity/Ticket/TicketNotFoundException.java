package com.example.ticketproject.exception.entity.Ticket;

public class TicketNotFoundException extends RuntimeException{
	public TicketNotFoundException(String message) {
		super(message);
	}
}
