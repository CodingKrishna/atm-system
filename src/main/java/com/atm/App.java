package com.atm;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import com.atm.card.Card;
import com.atm.card.CardType;
import com.atm.service.ATMService;


public class App {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		ATMService ATM = ATMService.getInstance();
		BigDecimal amount = new BigDecimal(2500);
		Card card = new Card.CardBuilder("1234-5678-9103-2345", "Hari", new Date(2023, 12, 13), 1234, CardType.CREDIT)
				.setMinBalance(100)
				.setMaxLimit(7000)
				.build();
		Map<Integer, Integer> denominationPreference = new HashMap<>();
		//denominationPreference.put(200, 10);
		ATM.dispenseCash(amount, card, denominationPreference);
	}

}
