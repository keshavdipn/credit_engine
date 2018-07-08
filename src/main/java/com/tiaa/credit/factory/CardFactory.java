package com.tiaa.credit.factory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tiaa.credit.constants.Card;
import com.tiaa.credit.domain.CreditCard;
import com.tiaa.credit.exception.InvalidRequestException;
import com.tiaa.credit.generator.AmexCardGenerator;
import com.tiaa.credit.generator.DiscoverCardGenerator;
import com.tiaa.credit.generator.MasterCardGenerator;
import com.tiaa.credit.generator.VisaCardGenerator;

@Component
public class CardFactory {
	
	@Autowired
	private AmexCardGenerator amexGenerator;	
	@Autowired
	private MasterCardGenerator masterGenerator;
	@Autowired
	private VisaCardGenerator visaGenerator;
	@Autowired
	private DiscoverCardGenerator discoverGenerator;
	
	public List<?  extends CreditCard> process(String cardName , int count){	
		
		
		if(cardName.equalsIgnoreCase(Card.VISA.getName())){			
			return visaGenerator.generateVisa(count);		
		}
		else if(cardName.equalsIgnoreCase(Card.MASTERCARD.getName())){
			return masterGenerator.generateMaster(count);
		}
		else if(cardName.equalsIgnoreCase(Card.AMERICANEXPRESS.getName())){
			return amexGenerator.generateAmex(count);
		}
		else if(cardName.equalsIgnoreCase(Card.DISCOVER.getName())){
			return discoverGenerator.generateDiscover(count);
		}
		else{
			throw new InvalidRequestException();
		}	
		
	}
	
	

}
