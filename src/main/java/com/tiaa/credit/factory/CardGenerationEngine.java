package com.tiaa.credit.factory;

import java.util.List;

import org.springframework.stereotype.Component;

import com.tiaa.credit.domain.CreditCard;
import com.tiaa.credit.generator.CardGenerator;

@Component
public class CardGenerationEngine {
		
	public List<?  extends CreditCard> process(CardGenerator cardGenerator , int count){	
		
		return cardGenerator.generateCards(count);		
		
		
	}
	
	

}
