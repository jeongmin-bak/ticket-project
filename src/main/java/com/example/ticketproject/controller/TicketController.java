package com.example.ticketproject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "TicketController")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mytickets")
public class TicketController {
}
