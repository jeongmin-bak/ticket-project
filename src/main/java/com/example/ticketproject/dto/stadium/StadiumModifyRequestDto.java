package com.example.ticketproject.dto.stadium;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StadiumModifyRequestDto {
	private String stadiumName;
}
