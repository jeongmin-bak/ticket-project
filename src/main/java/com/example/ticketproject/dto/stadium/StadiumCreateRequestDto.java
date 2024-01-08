package com.example.ticketproject.dto.stadium;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StadiumCreateRequestDto {
	private String stadiumName;
}
