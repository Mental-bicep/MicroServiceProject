package com.irctc.exception;

public class InsufficientBalanceException extends RuntimeException{
	
	public InsufficientBalanceException(String _msg) {
		super(_msg);
	}
}
