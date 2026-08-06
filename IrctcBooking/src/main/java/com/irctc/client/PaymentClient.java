package com.irctc.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.irctc.entity.PaymentEntity;

@FeignClient(name = "PaymentService")
public interface PaymentClient {
	@PostMapping("/pay")
	PaymentEntity makePayment(@RequestParam("amount") Integer amount, @RequestParam("bookingId") Integer bookingId);
}
