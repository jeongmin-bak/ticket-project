package com.example.ticketproject.redis.facade;

import org.springframework.stereotype.Component;

import com.example.ticketproject.dto.ticket.TicketRequestDto;
import com.example.ticketproject.dto.ticket.TicketResponseDto;
import com.example.ticketproject.service.TicketService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OptimisticLockStockFacade {
	private final TicketService ticketService;

	public TicketResponseDto reserveTicket (Long userId, TicketRequestDto ticketRequestDto) throws
		InterruptedException {
		while (true) {
			try {
				return ticketService.reserveTicket(userId, ticketRequestDto);
			} catch (Exception e) {
				Thread.sleep(1);
			}
		}
	}
}
