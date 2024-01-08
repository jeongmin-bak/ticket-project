package com.example.ticketproject.dto.ticketinfo;

import java.time.LocalDateTime;

import com.example.ticketproject.dto.sports.SportsResponseDto;
import com.example.ticketproject.entity.TicketInfo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TicketInfoResponseDto {
    private Long id;
    private LocalDateTime openDate;
    private LocalDateTime closeDate;
    private Long ticketPrice;
    private Long stock;
    private SportsResponseDto sports;


    public TicketInfoResponseDto(TicketInfo ticketInfo) {
        this.id = ticketInfo.getTicketInfoId();
        this.openDate = ticketInfo.getOpenDate();
        this.closeDate = ticketInfo.getCloseDate();
        this.ticketPrice = ticketInfo.getTicketPrice();
        this.stock = ticketInfo.getStock();
        this.sports = new SportsResponseDto(ticketInfo.getSports());
    }
}
