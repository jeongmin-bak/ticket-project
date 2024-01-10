package com.example.ticketproject.redis.service;

import org.springframework.stereotype.Service;

import com.example.ticketproject.dto.ticket.TicketRequestDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "WaitingQueueSortedSetService")
@Service
@RequiredArgsConstructor
public class WaitingQueueSortedSetService implements WaitingQueueService{

	@Override
	public Long registerQueue(TicketRequestDto ticketRequestDto) {
		return null;
	}
}
