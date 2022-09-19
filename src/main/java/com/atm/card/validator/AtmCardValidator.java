package com.atm.card.validator;

import com.atm.card.Card;

public interface AtmCardValidator {
	
	boolean validate(Card card);
	
	String getErrorMsg();
}
