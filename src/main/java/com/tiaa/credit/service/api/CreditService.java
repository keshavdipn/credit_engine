package com.tiaa.credit.service.api;

import java.util.List;

import com.tiaa.credit.domain.CreditCard;

public interface CreditService {

	public List<? extends CreditCard> generateCards(String card, int count);
	
}
