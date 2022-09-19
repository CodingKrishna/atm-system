package com.atm.exceptions;

public class InvalidAmount extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3546347639979199141L;

	public InvalidAmount(String  msg){
		super(msg);
	}
	
}
