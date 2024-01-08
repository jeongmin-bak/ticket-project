package com.example.ticketproject.dto.ticketinfo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketInfoRequestDto {
    private Long sportsId;
    private Long ticketPrice;
    private Long stock;
    private LocalDateTime openDate;
    private LocalDateTime closeDate;
}
