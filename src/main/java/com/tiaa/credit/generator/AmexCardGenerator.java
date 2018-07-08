package com.tiaa.credit.generator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.tiaa.credit.domain.AmexCard;
import com.tiaa.credit.domain.CreditCard;

@Component
public class AmexCardGenerator extends CardGenerator {

	private String bankId = "37";
	private int digits = 16;

	@Override
	public List<AmexCard> generateCards(int count) {

		List<AmexCard> lsCards = new ArrayList<>();
		while (count > 0) {
			String cardNum = super.generate(bankId, digits);
			lsCards.add(new AmexCard(cardNum, null));
			count--;
		}
		return lsCards;

	}

}
