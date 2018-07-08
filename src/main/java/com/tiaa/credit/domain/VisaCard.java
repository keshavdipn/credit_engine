package com.tiaa.credit.domain;

import java.util.Date;

import com.tiaa.credit.constants.Card;


public class VisaCard extends CreditCard{
	
	public VisaCard(String number, String expDate){
		super(Card.VISA.getName(),number, expDate);
		
	}

}
