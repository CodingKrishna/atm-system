package com.atm.cash.dispenser;

import java.util.Map;

public class CashDispenser {

	public static void dispenseCash(Map<Integer, Integer> denominators) {
		
		denominators.entrySet().stream().forEach(entiry -> {
			System.out.println("Denomination:" + entiry.getKey() + " Count: " + entiry.getValue());
		});
	}
}
