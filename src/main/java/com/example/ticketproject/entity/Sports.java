package com.example.ticketproject.entity;

import com.example.ticketproject.dto.sports.SportsRequestDto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Sports {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sportId;
    private String sportName;
    private String matchDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "stadium_id")
    private Stadium stadium;

    public Sports(SportsRequestDto sportsRequestDto, Stadium stadium) {
        this.sportName = sportsRequestDto.getSportName();
        this.matchDate = sportsRequestDto.getMatchDate();
        this.stadium = stadium;
    }

    public void update(SportsRequestDto sportsRequestDto) {
        this.sportName = sportsRequestDto.getSportName();
        this.matchDate = sportsRequestDto.getMatchDate();
    }
}
