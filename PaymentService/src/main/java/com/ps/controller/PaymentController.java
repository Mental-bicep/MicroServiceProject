package com.ps.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ps.entity.PaymentEntity;
import com.ps.service.PaymentService;

@RestController
public class PaymentController {
	
	private final PaymentService paymentService;
	
	public PaymentController(PaymentService paymentService) {
		// TODO Auto-generated constructor stub
		this.paymentService = paymentService;
	}
	
	@PostMapping("/pay")
	public PaymentEntity acceptPayment(@RequestParam("amount") Integer amount,
									@RequestParam("bookingId") Integer bookingId) {
		return paymentService.confirmPayment(amount, bookingId);
	}
}
