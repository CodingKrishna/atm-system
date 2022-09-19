package com.atm.dinominator;

import java.math.BigDecimal;
import java.util.Map;

import com.atm.card.Card;
import com.atm.exceptions.InvalidDinomiation;

public interface DenominationCalc {
	
	public Map<Integer, Integer> findDenomination(BigDecimal amount, Card card, Map<Integer, Integer> systemDinominations)
			throws InvalidDinomiation;

}
