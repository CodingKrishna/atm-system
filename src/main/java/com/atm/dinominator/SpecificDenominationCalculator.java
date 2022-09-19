package com.atm.dinominator;

import java.math.BigDecimal;
import java.util.Map;

import com.atm.card.Card;
import com.atm.exceptions.InvalidDinomiation;

public class SpecificDenominationCalculator extends DenominatorFinder {

	private Map<Integer, Integer> denominationPreference;

	public SpecificDenominationCalculator(Map<Integer, Integer> denominationPreference) {
		this.denominationPreference = denominationPreference;
	}

	@Override
	public Map<Integer, Integer> findDenomination(BigDecimal amount, Card card,Map<Integer, Integer> systemDinominations)
			throws InvalidDinomiation {
		return super.findDenomination(amount, card, this.denominationPreference);
	}

	@Override
	public void validateCashInSystem(BigDecimal amount, Map<Integer, Integer> systemDinominations) {
		// TODO Auto-generated method stub
	}

	@Override
	protected void validateMinBalanceAfterWithdraw(Map<Integer, Integer> data, Card card) {
		// TODO Auto-generated method stub
		
	}

}
