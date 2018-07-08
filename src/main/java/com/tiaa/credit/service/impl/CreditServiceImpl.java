package com.tiaa.credit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiaa.credit.domain.CreditCard;
import com.tiaa.credit.factory.CardFactory;
import com.tiaa.credit.service.api.CreditService;
import com.tiaa.credit.validator.Validator;



@Service
public class CreditServiceImpl implements CreditService {

	
	@Autowired	
	private CardFactory factory;
	
	@Autowired Validator validator;
	
	public List<? extends CreditCard> generateCards(String card, int count) {
		
		
		List<? extends CreditCard> ls=  this.factory.process(card, count);
		validator.validate(ls);
		return ls;
		
	}

}
