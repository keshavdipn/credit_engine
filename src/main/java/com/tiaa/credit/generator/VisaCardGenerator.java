package com.tiaa.credit.generator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.tiaa.credit.domain.VisaCard;


@Component
public class VisaCardGenerator extends CardGenerator {

	private String bankId = "4";
	private int digits = 16;

	public List<VisaCard> generateVisa(int count) {

		List<VisaCard> lsCards  = new ArrayList<>();
		while (count > 0) {
			String cardNum = super.generate(bankId, digits);
			lsCards.add(new VisaCard(cardNum, null));
			count--;
		}
		return lsCards;

	}
}
