	package com.tiaa.credit.validator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.RecursiveAction;

import com.tiaa.credit.domain.CreditCard;


public abstract class CardValidator extends RecursiveAction{
	
	protected List<? extends CreditCard> lsCards;
	
	CardValidator(){
		
	}
	
	CardValidator( List<? extends CreditCard>   lsCards ){
		this.lsCards = lsCards;
		
	}	

	protected boolean validateLuhn(String number) {
		
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
		return sum % 10==0;
		
	}
	
	protected abstract boolean  validateCard(CreditCard card);
	
	
	protected void checkCards(){
		Iterator<? extends CreditCard> it = lsCards.iterator();
		while(it.hasNext()){
			CreditCard card= it.next();
			if(!validateCard(card))
				it.remove();
			else
			{
				Date d = Calendar.getInstance().getTime(); 
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
				String currentDate = sdf.format(d);
				card.setExpiryDate(currentDate);
			}
		}
	
		
	}

	public List<? extends CreditCard> getLsCards() {
		return lsCards;
	}

	public void setLsCards(List<? extends CreditCard> lsCards) {
		this.lsCards = lsCards;
	}	
		
	
		
	
}
