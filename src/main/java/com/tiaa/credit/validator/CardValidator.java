	package com.tiaa.credit.validator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.RecursiveAction;

import com.tiaa.credit.domain.CreditCard;


public class CardValidator extends RecursiveAction{
	
	private List<? extends CreditCard> lsCards;
	private int low;
	private int high;
	
	CardValidator( List<? extends CreditCard>   leftLs ){
		this.lsCards = leftLs;
		
	}	

	private boolean validate(String number) {
		
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
	
	
	public void validateCards(){
		Iterator<? extends CreditCard> it = lsCards.iterator();
		while(it.hasNext()){
			CreditCard card= it.next();
			if(!validate(card.getCardNumber()))
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


	@Override
	protected void compute() {
		if(this.lsCards.size() < 100){
			 validateCards();
			 return ;
		}
			
			int mid = lsCards.size()/2;
			
			List leftLs = new ArrayList(lsCards.subList(0, mid));
			List rightLs = new ArrayList(lsCards.subList(mid+1, lsCards.size()));
			CardValidator left = new CardValidator(leftLs);
			CardValidator right = new CardValidator(rightLs);
			invokeAll(left, right);	
			lsCards.clear();
			lsCards.addAll(leftLs);
			lsCards.addAll(rightLs);
		
		}
					
			
		
	
}
