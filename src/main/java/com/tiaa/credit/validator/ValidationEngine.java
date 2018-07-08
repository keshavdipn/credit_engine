package com.tiaa.credit.validator;

import java.util.List;
import java.util.concurrent.ForkJoinPool;

import org.springframework.stereotype.Component;

import com.tiaa.credit.domain.CreditCard;

@Component
public class ValidationEngine {

	private ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());


	public List<? extends CreditCard> validate(CardValidator validator, List<? extends CreditCard> lsCards) {

		validator.setLsCards(lsCards);
		ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());

		pool.invoke(validator);
		return lsCards;

	}
}
