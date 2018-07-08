import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.tiaa.credit.constants.Card;
import com.tiaa.credit.domain.CreditCard;
import com.tiaa.credit.domain.MasterCard;
import com.tiaa.credit.generator.MasterCardGenerator;
import com.tiaa.credit.validator.MasterCardValidator;
import com.tiaa.credit.validator.ValidationEngine;

public class ValidatorTest {
	
	@Ignore
	public void testValidatorExpiryDate(){
		ValidationEngine validator = new ValidationEngine();
		MasterCardGenerator masterGen = new MasterCardGenerator();
		 MasterCardValidator masterValidator = new MasterCardValidator(masterGen.generateCards(2));
	    List<? extends CreditCard> ls = validator.validate( masterValidator , masterGen.generateCards(2));
		assertNotNull(ls);
		assertTrue(ls.size() == 2);
		Date d = Calendar.getInstance().getTime(); 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		String currentDate = sdf.format(d);
		assertTrue(ls.get(0).getExpiryDate().equals( currentDate));
		
		
	}
	
	@Test
	public void testValidatorRemoveInvalidCards(){
		ValidationEngine validator = new ValidationEngine();
		MasterCardGenerator masterGen = new MasterCardGenerator();
		 MasterCardValidator masterValidator = new MasterCardValidator(masterGen.generateCards(2));
		 List ls = masterGen.generateCards(1);
		 MasterCard invalid = new MasterCard("123", null);
		 ls.add(invalid);
	
	    ls = validator.validate(masterValidator,  ls);
		assertNotNull(ls);
		assertTrue(ls.size() == 1);
	
		assertTrue(((CreditCard) ls.get(0)).getCardName().equalsIgnoreCase(Card.MASTERCARD.getName()));
		
		
	}

}
