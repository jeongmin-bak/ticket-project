// package com.example.ticketproject.lock;
//
// import static org.junit.jupiter.api.Assertions.*;
//
// import java.util.concurrent.CountDownLatch;
// import java.util.concurrent.ExecutorService;
// import java.util.concurrent.Executors;
//
// import org.assertj.core.api.Assertions;
// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
//
// import com.example.ticketproject.dto.ticket.TicketRequestDto;
// import com.example.ticketproject.redis.lock.RedissonLockTicketFacade;
// import com.example.ticketproject.repository.TicketInfoRepository;
// import com.example.ticketproject.repository.TicketRepository;
// import com.example.ticketproject.service.TicketServiceImpl;
//
// @SpringBootTest
// public class RedissonLockTicketServiceTest {
// 	@Autowired
// 	private TicketServiceImpl ticketService;
// 	@Autowired
// 	private RedissonLockTicketFacade redissonLockTicketFacade;
// 	@Autowired
// 	private TicketInfoRepository ticketInfoRepository;
//
// 	@Test
// 	@DisplayName("일반 ticketservice 100명 예약 테스트/ 비관적 락")
// 	public void test() throws InterruptedException {
// 		int threadCount = 100;
// 		//멀티스레드 이용 ExecutorService : 비동기를 단순하게 처리할 수 있또록 해주는 java api
// 		ExecutorService executorService = Executors.newFixedThreadPool(32);
// 		//다른 스레드에서 수행이 완료될 때 까지 대기할 수 있도록 도와주는 API - 요청이 끝날때 까지 기다림
// 		CountDownLatch latch = new CountDownLatch(threadCount);
// 		for (int i = 0; i < threadCount; i++) {
// 			System.out.println(i + "번 유저 예매 시작");
// 			TicketRequestDto ticketRequestDto = TicketRequestDto.builder()
// 				.ticketInfoId(1L).posX((long)i).posY((long)i).build();
// 			executorService.submit(() ->{
// 				try{
// 					ticketService.reserveTicket(1L, ticketRequestDto);
// 					System.out.println("예약 완료");
// 				}finally {
// 					latch.countDown();
// 				}
// 			});
// 		}
// 		latch.await();
// 		long result = ticketInfoRepository.findById(1L).get().getStock();
// 		assertEquals(0L, result);
// 	}
//
// 	@Test
// 	@DisplayName("redisson 분산락을 적용하여 100명 예약 테스트")
// 	public void test1() throws InterruptedException{
// 		int threadCount = 100;
// 		ExecutorService executorService = Executors.newFixedThreadPool(32);
// 		CountDownLatch latch = new CountDownLatch(threadCount);
//
// 		for (int i = 0; i < threadCount; i++) {
// 			TicketRequestDto ticketRequestDto = TicketRequestDto.builder()
// 				.ticketInfoId(1L).posX((long)i).posY((long)i).build();
// 			executorService.submit(() ->{
// 				try{
// 					redissonLockTicketFacade.reserveTicket(1L, ticketRequestDto);
// 				}finally {
// 					latch.countDown();
// 				}
// 			});
// 		}
// 		latch.await();
// 		long result = ticketInfoRepository.findById(1L).get().getStock();
// 		assertEquals(0L, result);
// 	}
// }
