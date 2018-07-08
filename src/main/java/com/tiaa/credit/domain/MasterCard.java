package com.tiaa.credit.domain;

import java.util.Date;

import com.tiaa.credit.constants.Card;

public class MasterCard extends CreditCard {
	
	
	public MasterCard(String number, String expDate){
		super(Card.MASTERCARD.getName(), number, expDate);
	
	}

}
