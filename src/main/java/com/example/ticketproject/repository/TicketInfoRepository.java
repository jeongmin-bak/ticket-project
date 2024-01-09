package com.example.ticketproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ticketproject.entity.TicketInfo;

@Repository
public interface TicketInfoRepository extends JpaRepository<TicketInfo, Long> {
	@Override //기본 적으로 findById 을 제공하기 때문에 Override 하여 재정의 후 사용
	@EntityGraph(attributePaths = {"sports","sports.stadium"})
	Optional<TicketInfo> findById(Long ticketId);

}
