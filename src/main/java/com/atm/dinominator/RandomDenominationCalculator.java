package com.atm.dinominator;

import java.math.BigDecimal;
import java.util.Map;

import com.atm.card.Card;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RandomDenominationCalculator extends DenominatorFinder {

	@Override
	public void validateCashInSystem(BigDecimal amount, Map<Integer, Integer> systemDinominations) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void validateMinBalanceAfterWithdraw(Map<Integer, Integer> data, Card card) {
		// TODO Auto-generated method stub
		
	}

	
}
