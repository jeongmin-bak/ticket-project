package com.example.ticketproject.dto.ticket;

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
public class TicketRequestDto {
	private Long userId;
	private Long ticketInfoId;
	private Long posX;
	private Long posY;


	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
