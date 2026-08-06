package com.ps.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ps.entity.PaymentEntity;
import com.ps.repository.PaymentRepository;



@Service
public class PaymentService {
	
	private final PaymentRepository paymentRepository;

	public PaymentService(PaymentRepository paymentRepository) {
		this.paymentRepository = paymentRepository;
	}
	
	public PaymentEntity confirmPayment(Integer amount,  Integer bookingId) {
		
		PaymentEntity pEnt = new PaymentEntity();
		pEnt.setAmount(amount);
		pEnt.setBookingId(bookingId);
		pEnt.setTransactionId(UUID.randomUUID().toString());
		
		pEnt = paymentRepository.save(pEnt);
		return pEnt;
	}
	
}
