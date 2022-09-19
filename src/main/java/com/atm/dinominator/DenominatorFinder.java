package com.atm.dinominator;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.atm.card.Card;
import com.atm.exceptions.InvalidDinomiation;

public abstract class DenominatorFinder implements DenominationCalc {

	@Override
	public Map<Integer, Integer> findDenomination(BigDecimal amount, Card card, Map<Integer, Integer> systemDinominations)
			throws InvalidDinomiation {
		// validate cash is present in the system.
		validateCashInSystem(amount, systemDinominations);
		// find denominators
		Map<Integer, Integer> data = findDenominators(amount, systemDinominations);
		// validate min balance after 
		validateMinBalanceAfterWithdraw(data, card);
		return data;
	}

	private Map<Integer, Integer> findDenominators(BigDecimal amount, Map<Integer, Integer> systemDinominations) {
		Map<Integer, Integer> deno = new HashMap<>();
		int total = 0;
		for (Map.Entry<Integer, Integer> entry : systemDinominations.entrySet()) {
			if (total < amount.intValue()) {
				int n = Math.round((amount.intValue() - total) / entry.getKey());
				total = total + (n * entry.getKey());
				if (n > 0) {
					deno.put(entry.getKey(), n);
				}
			}
		}
		if (total != amount.intValue()) {
			// custom errors in sub classes.
			throw new InvalidDinomiation("Invalid denomination amount..");
		}
		return deno;
	}

	protected abstract void validateCashInSystem(BigDecimal amount, Map<Integer, Integer> systemDinominations);
	
	protected abstract void validateMinBalanceAfterWithdraw(Map<Integer, Integer> data, Card card);
}
