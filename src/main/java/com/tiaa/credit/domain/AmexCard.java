package com.tiaa.credit.domain;

import org.springframework.context.annotation.Bean;

import com.tiaa.credit.constants.Card;

public class AmexCard extends CreditCard{

	
	public AmexCard(String number, String expDate){
		super(Card.AMERICANEXPRESS.getName(), number, expDate);
		
	}
}
