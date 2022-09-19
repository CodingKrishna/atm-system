package com.atm.exceptions;

public class InvalidDinomiation extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6031056461016168494L;

	public InvalidDinomiation(String msg){
		super(msg);
	}
}
