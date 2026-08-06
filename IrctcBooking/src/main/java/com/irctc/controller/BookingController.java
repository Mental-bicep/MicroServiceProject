package com.irctc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.irctc.entity.TicketEntity;
import com.irctc.exception.InsufficientBalanceException;
import com.irctc.request.BookingRequest;
import com.irctc.response.ErrorResponse;
import com.irctc.service.BookingService;

@RestController
@RequestMapping("/irctc")
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@PostMapping("/bookTicket")
	public TicketEntity bookTicket(@RequestBody BookingRequest req) {
		return bookingService.bookTicket(req);
	}
	
	@GetMapping("/checkpnr/{pnr}")
	public TicketEntity checkPnrStatus(@PathVariable("pnr") Integer pnr ) {
		System.out.println("inside check PNR controller **********************************************************");
		return bookingService.checkPnrStatus(pnr);
	}
	
	@GetMapping("getAllTickets")
	public List<TicketEntity> findAllTicketsByUserId(@RequestParam Long userId, 
													@RequestParam Integer pageNumber,
													@RequestParam Integer pageSize ){
		System.out.println("Inside findAll tickets method ***********************************************");
		return bookingService.findAllTicketForAUser(userId, pageNumber, pageSize);
		
	}
	
//	@ExceptionHandler(InsufficientBalanceException.class)
//	public ResponseEntity<ErrorResponse> handleInsufficientBalanceException(InsufficientBalanceException e){
//		ErrorResponse err = new ErrorResponse();
//		err.setErrorCode("IB-101");
//		err.setErrorMsg(e.getMessage());
//		
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
//	}
	
	@ExceptionHandler(InsufficientBalanceException.class)
	public ResponseEntity<?> handleInsufficientBalanceExceptionFromController(InsufficientBalanceException e){
		ErrorResponse err = new ErrorResponse();
		err.setErrorCode("IB-101");
		err.setErrorMsg(e.getMessage() + " ->handled from controller");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
}
