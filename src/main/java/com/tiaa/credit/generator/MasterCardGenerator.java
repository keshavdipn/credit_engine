package com.tiaa.credit.generator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.tiaa.credit.domain.MasterCard;


@Component
public class MasterCardGenerator extends CardGenerator{

	private String bankId = "5";
	private int digits = 16;

	public List<MasterCard> generateCards(int count) {

		List<MasterCard> lsCards  = new ArrayList<>();
		while (count > 0) {
			String cardNum = super.generate(bankId, digits);
			lsCards.add(new MasterCard(cardNum, null));
			count--;
		}
		return lsCards;

	}
}
