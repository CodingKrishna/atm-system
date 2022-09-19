package com.atm.card.validator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.atm.card.CardType;

import lombok.NonNull;

public class AtmCardValidatorFactor {

	private static final Map<CardType, List<AtmCardValidator>> validators = new HashMap<>();
	static {
		loadValidators();
	}

	public static void loadValidators() {
		validators.put(CardType.CREDIT, List.of(new CreditCardValidator()));
		validators.put(CardType.DEBIT, List.of(new DebitCardValidator()));
	}

	public static List<AtmCardValidator> getAtmValidator(@NonNull CardType type) {
		return Optional.ofNullable(validators.get(type)).orElse(List.of());
	}
}
