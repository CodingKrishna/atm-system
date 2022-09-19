package com.atm.dinominator;

import java.util.Map;
import java.util.Objects;

public class DenominationFactor {

	public static DenominationCalc getDenominationCalc(Map<Integer, Integer> denominationPreference) {
		if (Objects.nonNull(denominationPreference) && denominationPreference.size() > 0) {
			return new SpecificDenominationCalculator(denominationPreference);
		}
		return new RandomDenominationCalculator();
	}
}
