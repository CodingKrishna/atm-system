package com.atm.card;

import java.sql.Date;

import lombok.Data;

@Data
//@AllArgsConstructor
public class Card {

	private String cardNumber;
	private String customerName;
	private Date cardExpiry;
	private int pin;
	private CardType cardType;
	private int maxLimit;
	private int minLimit;

	private Card(CardBuilder builder) {
		this.cardExpiry = builder.cardExpiry;
		this.cardNumber = builder.cardNumber;
		this.customerName = builder.customerName;
		this.pin = builder.pin;
		this.cardType = builder.cardType;
		this.maxLimit = builder.maxLimit;
	}

	public static class CardBuilder {
		private String cardNumber;
		private String customerName;
		private Date cardExpiry;
		private int pin;
		private CardType cardType;
		private int maxLimit;
		private int minBalance;

		public CardBuilder(String cardNumber, String customerName, Date cardExpiry, int pin, CardType cardType) {
			this.cardNumber = cardNumber;
			this.customerName = customerName;
			this.cardExpiry = cardExpiry;
			this.pin = pin;
			this.cardType = cardType;
		}

		public CardBuilder setMaxLimit(int limit) {
			this.maxLimit = limit;
			return this;
		}
		
		public CardBuilder setMinBalance(int limit) {
			this.minBalance = limit;
			return this;
		}
		
		public Card build() {
			return new Card(this);
		}
	}

}
