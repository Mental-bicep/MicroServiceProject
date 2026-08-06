package com.irctc.exception;

import java.net.http.HttpRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.irctc.response.ErrorResponse;

//@RestControllerAdvice
//public class GlobalExceptionHandler {
	
//	@ExceptionHandler(InsufficientBalanceException.class)
//	public ResponseEntity<ErrorResponse> handleInsufficientBalanceException(InsufficientBalanceException e){
//		ErrorResponse err = new ErrorResponse();
//		err.setErrorCode("IB-101");
//		err.setErrorMsg("Insufficient Balance - Ticket cannot be booked");
		
//		ResponseEntity<ErrorResponse> re =  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
//		return re;
		
		
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
//		
//	}
//	
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<?> handleGenericException(Exception e){
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//	}
//}

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(InsufficientBalanceException.class)
	public ResponseEntity<?> handleInsufficientBalanceException(InsufficientBalanceException e){
		ErrorResponse err = new ErrorResponse();
		err.setErrorCode("IB-101");
		err.setErrorCode(e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGenericException(Exception e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
}