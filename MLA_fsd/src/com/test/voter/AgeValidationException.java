package com.test.voter;

public class AgeValidationException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AgeValidationException(String msg) {
		super(msg);
	}
}
