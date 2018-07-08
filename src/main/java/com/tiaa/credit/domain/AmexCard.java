package com.tiaa.credit.domain;

import java.util.Date;

import com.tiaa.credit.constants.Card;

public class AmexCard extends CreditCard{

	
	public AmexCard(String number, String expDate){
		super(Card.AMERICANEXPRESS.getName(), number, expDate);
		
	}
}
