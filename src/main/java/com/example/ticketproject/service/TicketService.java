package com.example.ticketproject.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.ticketproject.dto.ticket.TicketRequestDto;
import com.example.ticketproject.dto.ticket.TicketResponseDto;
import com.example.ticketproject.entity.User;

import jakarta.transaction.Transactional;

public interface TicketService {
	public List<TicketResponseDto> getUserTicketList(Long userId);

	public TicketResponseDto showDetailTicket(Long userId, Long ticketId);

	public TicketResponseDto reserveTicket(Long userId, TicketRequestDto ticketRequestDto);

	public TicketResponseDto reserveTicketSortedSet(Long userId, TicketRequestDto ticketRequestDto);

	public ResponseEntity cancelUserTicket(Long userId, Long ticketId);
}
