package com.tiaa.credit.generator;

import java.util.List;
import java.util.Random;

import com.tiaa.credit.domain.CreditCard;


public abstract class CardGenerator {
	
	public abstract List<? extends CreditCard > generateCards(int count);

	protected String generate(String bin, int length) {

		Random random = new Random(System.currentTimeMillis());

		int randomNumberLength = length - (bin.length() + 1);

		StringBuilder builder = new StringBuilder(bin);
		for (int i = 0; i < randomNumberLength; i++) {
			int digit = random.nextInt(10);
			builder.append(digit);
		}

		int checkDigit = this.getCheckDigit(builder.toString());
		builder.append(checkDigit);

		return builder.toString();
	}

	private int getCheckDigit(String number) {

		int sum = 0;
		for (int i = 0; i < number.length(); i++) {

			int digit = Integer.parseInt(number.substring(i, (i + 1)));

			if ((i % 2) == 0) {
				digit = digit * 2;
				if (digit > 9) {
					digit = (digit / 10) + (digit % 10);
				}
			}
			sum += digit;
		}
		int mod = sum % 10;
		return ((mod == 0) ? 0 : 10 - mod);
	}

}
