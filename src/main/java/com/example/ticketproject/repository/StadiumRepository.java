package com.example.ticketproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.ticketproject.entity.Stadium;

public interface StadiumRepository extends JpaRepository<Stadium, Long> {
	@Query(value="select * from stadium where stadium_id = ? ", nativeQuery = true)
	Optional<Stadium> findByStadiumId(Long stadiumId);
}
