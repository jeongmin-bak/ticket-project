package com.example.ticketproject.exception.entity.TicketInfo;

public class OutOfStockException extends RuntimeException{
	public OutOfStockException(String message) {
		super(message);
	}
}
