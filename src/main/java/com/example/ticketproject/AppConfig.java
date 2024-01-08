package com.example.ticketproject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
}
