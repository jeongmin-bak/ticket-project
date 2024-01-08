package com.example.ticketproject.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ticketproject.dto.ApiResponse;
import com.example.ticketproject.dto.ticket.TicketResponseDto;
import com.example.ticketproject.redis.WaitingQueue;
import com.example.ticketproject.service.TicketService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "TicketController")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mytickets")
public class TicketController {
	private final TicketService ticketService;
	private final WaitingQueue waitingQueue;

	// 예매한 티켓 목록 조회
	@GetMapping("")
	public ApiResponse<List<TicketResponseDto>> viewListOfReservedTickets(Long userId){
		return ApiResponse.success("예매한 티켓 목록 조회에 성공했습니다.", ticketService.getUserTicketList(userId));
	}

}
