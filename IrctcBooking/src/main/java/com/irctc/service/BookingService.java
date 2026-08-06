package com.irctc.service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.irctc.client.PaymentClient;
import com.irctc.entity.PaymentEntity;
import com.irctc.entity.TicketEntity;
import com.irctc.exception.InsufficientBalanceException;
import com.irctc.mapper.TicketEntityMapper;
import com.irctc.repository.BookingRepository;
import com.irctc.repository.PaymentRepository;
import com.irctc.request.BookingRequest;

@Service
public class BookingService {
	
	private final BookingRepository bookingRepository;
	private final TicketEntityMapper ticketEntityMapper;
	private final PaymentRepository paymentRepository;
	private final PaymentClient paymentClient;
	
	public BookingService(BookingRepository bookingRepository, 
			TicketEntityMapper ticketEntityMapper,
			PaymentRepository paymentRepository,
			PaymentClient paymentClient) {
		this.bookingRepository = bookingRepository;
		this.ticketEntityMapper = ticketEntityMapper;
		this.paymentRepository = paymentRepository;
		this.paymentClient = paymentClient;
	}
	
	@Transactional
	public TicketEntity bookTicket(BookingRequest req) {
		TicketEntity tt =ticketEntityMapper.bookingReqToTicketEntityMapper(req);
		bookingRepository.save(tt);
		
//		PaymentEntity pEnt = new PaymentEntity();
//		pEnt.setAmount(500);
//		pEnt.setBookingId(tt.getBookingId());
//		pEnt.setTransactionId("TXN"+getPnr());
		
//		triggerAbruptCrash(); // comment out for happy flow
		
//		paymentRepository.save(pEnt);
		
		PaymentEntity pEnt = paymentClient.makePayment(getRandomAmount(), tt.getBookingId());
		if(pEnt.getPaymentId() > 0)
			tt.setPnr(getPnr());
		else throw new RuntimeException("Payment failed in paymentService");
		
		TicketEntity savedEntity = bookingRepository.save(tt);
		System.out.println("saveEnt is "+ savedEntity.toString());
		
		return savedEntity;
	}
	
	public Integer getRandomAmount() {
		return getPnr();
	}
	
	public Integer getPnr() {
		return ThreadLocalRandom.current().nextInt(10000, 100000);
	}
	
	public TicketEntity checkPnrStatus(Integer Pnr) {
		List<TicketEntity> ents = bookingRepository.findByPnr(Pnr);
		return ents.get(0);
	}
	
//	public List<TicketEntity> findAllTicketsForAUser(Long userId, Integer pageNumber, Integer PageSize){
//		Pageable pageable = PageRequest.of(pageNumber, PageSize);
//		return bookingRepository.findByUserId(userId, pageable);
//	}
	
	public List<TicketEntity> findAllTicketForAUser(Long userId, Integer pageNumber, Integer pageSize){
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		List<TicketEntity> res = bookingRepository.findByUserId(userId, pageable);
		return res;
	}
	
	
	public void triggerAbruptCrash() {
		System.out.println("Throwing Illegal argument exception to create a Crash scenario");
		
		throw new InsufficientBalanceException("Self created exception to generate Crash scenarion");
	}
}
