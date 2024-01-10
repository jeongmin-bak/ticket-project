package com.example.ticketproject.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ticketproject.dto.ticket.TicketRequestDto;
import com.example.ticketproject.redis.facade.OptimisticLockStockFacade;
import com.example.ticketproject.repository.TicketInfoRepository;

@SpringBootTest
public class TicketServiceTest {
	@Autowired
	private TicketServiceImpl ticketService;
	@Autowired
	private OptimisticLockStockFacade optimisticLockStockFacade;

	@Autowired
	private TicketInfoRepository ticketInfoRepository;

	@Test
	@DisplayName("일반 ticketservice 100명 예약 테스트")
	public void test() throws InterruptedException {
		int threadCount = 100;
		//멀티스레드 이용 ExecutorService : 비동기를 단순하게 처리할 수 있또록 해주는 java api
		ExecutorService executorService = Executors.newFixedThreadPool(32);
		//다른 스레드에서 수행이 완료될 때 까지 대기할 수 있도록 도와주는 API - 요청이 끝날때 까지 기다림
		CountDownLatch latch = new CountDownLatch(threadCount);
		for (int i = 0; i < threadCount; i++) {
			TicketRequestDto ticketRequestDto = TicketRequestDto.builder()
				.ticketInfoId(1L).posX((long)i).posY((long)i).build();
			executorService.submit(() ->{
				try{
					ticketService.reserveTicket(1L, ticketRequestDto);
					System.out.println("예약 완료");
				}finally {
					latch.countDown();
				}
			});
		}
		latch.await();
		long result = ticketInfoRepository.findById(1L).get().getStock();
		assertEquals(0L, result);
	}

	@Test
	@DisplayName("Optimistic Lock(낙관적 락) 사용")
	public void test2() throws InterruptedException {
		int threadCount = 100;
		ExecutorService executorService = Executors.newFixedThreadPool(32);
		CountDownLatch latch = new CountDownLatch(threadCount);

		for (int i = 0; i < threadCount; i++) {
			TicketRequestDto ticketRequestDto = TicketRequestDto.builder()
				.ticketInfoId(1L).posX((long)i).posY((long)i).build();
			executorService.submit(() -> {
				try{
					optimisticLockStockFacade.reserveTicket(1L, ticketRequestDto);
				}catch (InterruptedException e){
					e.printStackTrace();
				}finally {
					latch.countDown();
				}
			});
		}

		latch.await();
		long result = ticketInfoRepository.findById(1L).get().getStock();
		assertEquals(0L, result);
	}
}
