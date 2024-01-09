package com.example.ticketproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ticketproject.entity.Sports;

public interface SportsRepository extends JpaRepository<Sports, Long> {
}
