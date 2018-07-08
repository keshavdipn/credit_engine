package com.tiaa.credit.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiaa.credit.constants.Card;
import com.tiaa.credit.domain.CreditCard;
import com.tiaa.credit.exception.InvalidRequestException;
import com.tiaa.credit.factory.CardGenerationEngine;
import com.tiaa.credit.generator.AmexCardGenerator;
import com.tiaa.credit.generator.DiscoverCardGenerator;
import com.tiaa.credit.generator.MasterCardGenerator;
import com.tiaa.credit.generator.VisaCardGenerator;
import com.tiaa.credit.service.api.CreditService;
import com.tiaa.credit.validator.AmexCardValidator;
import com.tiaa.credit.validator.DiscoverCardValidator;
import com.tiaa.credit.validator.MasterCardValidator;
import com.tiaa.credit.validator.ValidationEngine;
import com.tiaa.credit.validator.VisaCardValidator;



@Service
public class CreditServiceImpl implements CreditService {

	@Autowired
	private AmexCardGenerator amexGenerator;	
	@Autowired
	private MasterCardGenerator masterGenerator;
	@Autowired
	private VisaCardGenerator visaGenerator;
	@Autowired
	private DiscoverCardGenerator discoverGenerator;	
	
	@Autowired 
	private ValidationEngine validationEngine;
	
	@Autowired 
	private CardGenerationEngine generationEngine;
	
	public List<? extends CreditCard> generateCards(String cardName, int count) {
		
		List<? extends CreditCard> ls= new ArrayList<>();
		
		if(cardName.equalsIgnoreCase(Card.VISA.getName())){			
			ls =  generationEngine.process(visaGenerator, count);	
			validationEngine.validate(new VisaCardValidator() ,ls);
			return ls;
		}
		else if(cardName.equalsIgnoreCase(Card.MASTERCARD.getName())){
			ls =  generationEngine.process(masterGenerator, count);
			validationEngine.validate(new MasterCardValidator() ,ls);
			return ls;
		}
		else if(cardName.equalsIgnoreCase(Card.AMERICANEXPRESS.getName())){
			ls =  generationEngine.process(amexGenerator, count);
			validationEngine.validate(new AmexCardValidator() ,ls);
			return ls;
		}
		else if(cardName.equalsIgnoreCase(Card.DISCOVER.getName())){
			ls =  generationEngine.process(discoverGenerator, count);
			validationEngine.validate(new DiscoverCardValidator() ,ls);
			return ls;
		}
		else{
			throw new InvalidRequestException();
		}	
		
		
	}

}
