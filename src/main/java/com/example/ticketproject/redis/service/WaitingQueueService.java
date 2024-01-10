package com.example.ticketproject.redis.service;

import com.example.ticketproject.dto.ticket.TicketRequestDto;

public interface WaitingQueueService {
	public Long registerQueue(TicketRequestDto ticketRequestDto);
}
