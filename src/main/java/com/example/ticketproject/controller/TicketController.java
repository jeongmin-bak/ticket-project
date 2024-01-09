package com.example.ticketproject.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ticketproject.dto.ApiResponse;
import com.example.ticketproject.dto.ticket.TicketRequestDto;
import com.example.ticketproject.dto.ticket.TicketResponseDto;
import com.example.ticketproject.redis.lock.RedissonLockTicketFacade;
import com.example.ticketproject.redis.queue.WaitingQueue;
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
	private final RedissonLockTicketFacade redissonLockTicketFacade;

	// 예매한 티켓 목록 조회
	@GetMapping("")
	public ApiResponse<List<TicketResponseDto>> viewListOfReservedTickets(@RequestParam(name = "userId") Long userId){
		return ApiResponse.success("예매한 티켓 목록 조회에 성공했습니다.", ticketService.getUserTicketList(userId));
	}

	// 예매한 티켓 상세 조회
	@GetMapping("/ticketId/{ticketId}")
	public ApiResponse<TicketResponseDto> detailViewReservedTicket(@RequestParam(name = "userId") Long userId, @PathVariable(name = "ticketId") Long ticketId){
		log.info("[Controller : detailViewReservedTicket userId = ] " + userId);
		return ApiResponse.success("티켓 상세 조회에 성공했습니다", ticketService.showDetailTicket(userId, ticketId));
	}

	// 예매 - redisson
	@PostMapping("/reserve/redisson")
	public ApiResponse reserveTicket(@RequestParam(name="userId")Long userId, @RequestBody TicketRequestDto ticketRequestDto) {
		return ApiResponse.success("예매가 완료되었습니다.", redissonLockTicketFacade.reserveTicket(userId, ticketRequestDto));
	}

}
