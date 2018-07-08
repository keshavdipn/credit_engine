package com.tiaa.credit.domain;

import java.util.Date;

import com.tiaa.credit.constants.Card;

public class DiscoverCard extends CreditCard{
	
	public DiscoverCard(String number, String expDate){
		super(Card.DISCOVER.getName(), number, expDate);
	
	}

}
