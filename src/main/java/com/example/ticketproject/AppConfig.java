package com.example.ticketproject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.ticketproject.controller.TicketController;
import com.example.ticketproject.entity.Ticket;
import com.example.ticketproject.redis.queue.WaitingQueue;
import com.example.ticketproject.redis.queue.WaitingQueueSortedSetService;
import com.example.ticketproject.repository.TicketInfoRepository;
import com.example.ticketproject.repository.TicketRepository;
import com.example.ticketproject.service.TicketService;
import com.example.ticketproject.service.TicketServiceImpl;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class AppConfig {
	private final TicketRepository ticketRepository;
	private final TicketInfoRepository ticketInfoRepository;

	@Bean
	public TicketService ticketService(){
		return new TicketServiceImpl(ticketInfoRepository, ticketRepository);
	}

	@Bean
	public WaitingQueue waitingQueue(){
		return new WaitingQueueSortedSetService();
	}
}
