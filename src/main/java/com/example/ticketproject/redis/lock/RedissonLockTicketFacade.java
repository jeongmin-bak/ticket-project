package com.example.ticketproject.redis.lock;

import java.util.concurrent.TimeUnit;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import com.example.ticketproject.dto.ticket.TicketRequestDto;
import com.example.ticketproject.dto.ticket.TicketResponseDto;
import com.example.ticketproject.service.TicketService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j(topic = "redisson")
@RequiredArgsConstructor
public class RedissonLockTicketFacade {

    private final RedissonClient redissonClient;
    private final TicketService ticketService;

    // 예매하기 부분에 Redisson으로 락을 걸어줌
    public TicketResponseDto reserveTicket(Long userId, TicketRequestDto requestDto) {
        Long ticketInfoId = requestDto.getTicketInfoId();
        RLock lock = redissonClient.getLock(ticketInfoId.toString());
        TicketResponseDto responseDto;
        log.info("lock 획득 시도");
        try {
            // lock 획득 시도 시간, lock 점유 시간
            boolean available = lock.tryLock(30, 1, TimeUnit.SECONDS);

            if (!available) {
                log.info("lock 획득 실패");
                return new TicketResponseDto();
            }
            log.info("lock 획득 성공");
            responseDto = ticketService.reserveTicket(userId, requestDto);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }

        return responseDto;
    }
}
