package com.ps.service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import com.ps.entity.PaymentEntity;
import com.ps.repository.PaymentRepository;



@Service
public class PaymentService {
	private static final Logger log = LoggerFactory.getLogger(PaymentService.class);
	private final PaymentRepository paymentRepository;

	public PaymentService(PaymentRepository paymentRepository) {
		this.paymentRepository = paymentRepository;
	}
	
	public PaymentEntity confirmPayment(Integer amount,  Integer bookingId) {
		log.info("inside payment service before making payment for booking id= "+bookingId);
		PaymentEntity pEnt = new PaymentEntity();
		pEnt.setAmount(amount);
		pEnt.setBookingId(bookingId);
		pEnt.setTransactionId(UUID.randomUUID().toString());
		
		pEnt = paymentRepository.save(pEnt);
		
		log.info("inside payment service payment successful for booking id= "+bookingId);
		
		return pEnt;
	}
	
}
