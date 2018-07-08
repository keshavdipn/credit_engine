package com.tiaa.credit.generator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.tiaa.credit.domain.DiscoverCard;
import com.tiaa.credit.domain.CreditCard;
import com.tiaa.credit.domain.DiscoverCard;

@Component
public class DiscoverCardGenerator extends CardGenerator{

	private String bankId = "6";
	private int digits = 16;

	public List<DiscoverCard> generateCards(int count) {

		List<DiscoverCard> lsCards  = new ArrayList<>();
		while (count > 0) {
			String cardNum = super.generate(bankId, digits);
			lsCards.add(new DiscoverCard(cardNum, null));
			count--;
		}
		return lsCards;

	}
}
