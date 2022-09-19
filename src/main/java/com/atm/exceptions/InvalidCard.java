package com.atm.exceptions;

public class InvalidCard extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1424898184298114237L;

	public InvalidCard(String msg) {
		super(msg);
	}
}
