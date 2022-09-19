package com.atm.card.validator;

import com.atm.card.Card;

public class DebitCardValidator  implements AtmCardValidator {

	@Override
	public boolean validate(Card card) {
		// actual validation of card.
		return true;
	}

	@Override
	public String getErrorMsg() {
		return "Debit Card Validation failed";
	}
}
