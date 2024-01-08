package com.example.ticketproject.dto.sports;

import com.example.ticketproject.entity.Sports;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SportsResponseDto {
    private Long id;
    private String sportsName;
    private String matchDate;
    private Long stadiumId;
    private String stadiumName;

    public SportsResponseDto(Sports sports) {
        this.id = sports.getSportId();
        this.sportsName = sports.getSportName();
        this.matchDate = sports.getMatchDate();
        this.stadiumId = sports.getStadium().getStadiumId();
        this.stadiumName = sports.getStadium().getStadiumName();

    }
}
