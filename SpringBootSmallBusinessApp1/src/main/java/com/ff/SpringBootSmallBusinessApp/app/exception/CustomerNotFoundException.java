package com.ff.SpringBootSmallBusinessApp.app.exception;

@SuppressWarnings("serial")
public class CustomerNotFoundException extends RuntimeException {
	public CustomerNotFoundException(String message) {
		super(message);
	}
}
