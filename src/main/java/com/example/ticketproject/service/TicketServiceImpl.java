package com.example.ticketproject.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.ticketproject.dto.ticket.TicketRequestDto;
import com.example.ticketproject.dto.ticket.TicketResponseDto;
import com.example.ticketproject.entity.Ticket;
import com.example.ticketproject.entity.TicketInfo;
import com.example.ticketproject.entity.User;
import com.example.ticketproject.repository.TicketInfoRepository;
import com.example.ticketproject.repository.TicketRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "TicketServiceImpl")
@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService{
	private final TicketInfoRepository ticketInfoRepository;
	private final TicketRepository ticketRepository;
	@Override
	public List<TicketResponseDto> getUserTicketList(Long userId) {
		return null;
	}

	@Override
	public TicketResponseDto showDetailTicket(Long userId, Long ticketId) {
		return null;
	}
	@Override
	@Transactional
	public TicketResponseDto reserveTicket(Long userId, TicketRequestDto ticketRequestDto) {
		log.info("티켓 예매 시작");
		TicketInfo ticketInfo = ticketInfoRepository.findById(ticketRequestDto.getTicketInfoId()).get();
		User user = User.builder().userId(userId).build();
		Ticket ticket = new Ticket(user, ticketInfo, ticketRequestDto);

		ticketRepository.save(ticket);
		ticketInfo.updateStock(-1L);
		return new TicketResponseDto(ticket);
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
