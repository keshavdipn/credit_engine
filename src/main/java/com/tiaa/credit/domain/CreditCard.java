package com.tiaa.credit.domain;

import java.util.Date;

public abstract class CreditCard {
	

	private String cardName;	
	private String cardNumber;
	private String expiryDate;
	
	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public CreditCard(){
		
	}
	
	public CreditCard(String name, String number , String expiryDate){
		this.cardName = name;
		this.cardNumber = number;
		this.expiryDate = expiryDate;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	
	

}
