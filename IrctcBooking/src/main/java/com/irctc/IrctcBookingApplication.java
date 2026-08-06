package com.irctc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class IrctcBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(IrctcBookingApplication.class, args);
	}

}
