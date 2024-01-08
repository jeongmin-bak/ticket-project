package com.example.ticketproject.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.ticketproject.dto.ticket.TicketRequestDto;
import com.example.ticketproject.dto.ticket.TicketResponseDto;

public class TicketServiceImpl implements TicketService{
	@Override
	public List<TicketResponseDto> getUserTicketList(Long userId) {
		return null;
	}

	@Override
	public TicketResponseDto showDetailTicket(Long userId, Long ticketId) {
		return null;
	}

	@Override
	public TicketResponseDto reserveTicket(Long userId, TicketRequestDto ticketRequestDto) {
		return null;
	}

	@Override
	public TicketResponseDto reserveTicketSortedSet(Long userId, TicketRequestDto ticketRequestDto) {
		return null;
	}

	@Override
	public ResponseEntity cancelUserTicket(Long userId, Long ticketId) {
		return null;
	}
}
