package com.example.ticketproject.dto.stadium;


import com.example.ticketproject.entity.Stadium;

import lombok.Getter;

@Getter
public class StadiumResponseDto {

	private Long stadiumId;
	private String stadiumName;

	public StadiumResponseDto(Stadium stadium) {
		this.stadiumId = stadium.getStadiumId();
		this.stadiumName = stadium.getStadiumName();
	}
}
