package com.example.ticketproject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.ticketproject.service.TicketService;
import com.example.ticketproject.service.TicketServiceImpl;

@Configuration
public class AppConfig {
	@Bean
	public TicketService ticketService(){
		return new TicketServiceImpl();
	}
}
