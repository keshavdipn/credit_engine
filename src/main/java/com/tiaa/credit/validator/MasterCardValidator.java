package com.tiaa.credit.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.tiaa.credit.domain.CreditCard;

@Component
public class MasterCardValidator extends CardValidator{


	private String bankId = "5";
	private int digits = 16;
	public MasterCardValidator(){
		
	}
	
	public MasterCardValidator(List<? extends CreditCard> lsCards) {
		super(lsCards);		
	}
	
	
	@Override
	protected void compute() {
		if(this.lsCards.size() < 100){
			checkCards();
			 return ;
		}
			
			int mid = lsCards.size()/2;
			
			List leftLs = new ArrayList(lsCards.subList(0, mid));
			List rightLs = new ArrayList(lsCards.subList(mid+1, lsCards.size()));
			CardValidator left = new MasterCardValidator(leftLs);
			CardValidator right = new MasterCardValidator(rightLs);
			invokeAll(left, right);	
			lsCards.clear();
			lsCards.addAll(leftLs);
			lsCards.addAll(rightLs);
		
		}

	@Override
	protected boolean validateCard(CreditCard card) {
		return card.getCardNumber().length() == digits 
			   && card.getCardNumber().startsWith(bankId)
			   && validateLuhn(card.getCardNumber());
		
	}

}
