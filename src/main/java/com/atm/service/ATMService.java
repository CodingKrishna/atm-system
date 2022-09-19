package com.atm.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import com.atm.card.Card;
import com.atm.card.validator.AtmCardValidator;
import com.atm.card.validator.AtmCardValidatorFactor;
import com.atm.cash.Cash;
import com.atm.cash.dispenser.CashDispenser;
import com.atm.dinominator.DenominationCalc;
import com.atm.dinominator.DenominationFactor;
import com.atm.exceptions.InvalidAmount;
import com.atm.exceptions.InvalidCard;

public class ATMService {

	private static volatile ATMService instance;
	private static Object mutex = new Object();

	private ATMService() {
		init();
	}

	public static ATMService getInstance() {
		ATMService result = instance;
		if (result == null) {
			synchronized (mutex) {
				result = instance;
				if (result == null)
					instance = result = new ATMService();
			}
		}
		return result;
	}
	
	public static void init() {
		Cash.loadCash();
	}

	public void dispenseCash(BigDecimal amount, Card card, Map<Integer, Integer> denominationPreference) {
		if(amount.intValue() < 0 || amount.intValue() > card.getMaxLimit()) {
			throw new InvalidAmount("Invalid Amount..Plase enter valid emount..");
		}
		//factor method
		List<AtmCardValidator> validators = AtmCardValidatorFactor.getAtmValidator(card.getCardType());
		// validator pattern 
		validate(card, validators);
		// strategy and template pattern used.
		DenominationCalc dinominatorCalc = DenominationFactor.getDenominationCalc(denominationPreference);
		Map<Integer, Integer> denominators = dinominatorCalc.findDenomination(amount, card, Cash.getCurrentSystemDinominations());
		// 
		CashDispenser.dispenseCash(denominators);
	}

	private void validate(Card card, List<AtmCardValidator> validators) throws InvalidCard {
		List<String> errors = validators.stream().map(validaor -> {
			if (!validaor.validate(card)) {
				return validaor.getErrorMsg();
			}
			return null;
		}).collect(Collectors.toList());

		if (Objects.nonNull(errors) && errors.size() > 1) {
			throw new InvalidCard(String.join(",", errors));
		}
	}
	
	
	
}
