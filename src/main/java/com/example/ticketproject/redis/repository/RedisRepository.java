package com.example.ticketproject.redis.repository;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Repository
@RequiredArgsConstructor
@Slf4j(topic = "RedisRepository")
public class RedisRepository {
	private final RedisTemplate<String, String> redisTemplate;

	public Boolean zAddIfAbsent(String key, String value, double score){
		//registQueue에 사용
		return redisTemplate.opsForZSet().addIfAbsent(key, value, score);
	}
}
