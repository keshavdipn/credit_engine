package com.tiaa.credit.validator;

import java.util.List;
import java.util.concurrent.ForkJoinPool;

import org.springframework.stereotype.Component;

import com.tiaa.credit.domain.CreditCard;

@Component
public class Validator {

	private ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
	
	public List<? extends CreditCard> validate(List<? extends CreditCard> lsCards){
		
		CardValidator validators = new CardValidator(lsCards);
		ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
	
		pool.invoke(validators);
		return lsCards;
		
		
	}
}
