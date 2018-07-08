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
import com.tiaa.credit.validator.Validator;

public class ValidatorTest {
	
	@Ignore
	public void testValidatorExpiryDate(){
		Validator validator = new Validator();
		MasterCardGenerator masterGen = new MasterCardGenerator();
	
	    List<? extends CreditCard> ls = validator.validate( masterGen.generateMaster(2));
		assertNotNull(ls);
		assertTrue(ls.size() == 2);
		Date d = Calendar.getInstance().getTime(); 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		String currentDate = sdf.format(d);
		assertTrue(ls.get(0).getExpiryDate().equals( currentDate));
		
		
	}
	
	@Test
	public void testValidatorRemoveInvalidCards(){
		Validator validator = new Validator();
		MasterCardGenerator masterGen = new MasterCardGenerator();
		 List ls = masterGen.generateMaster(1);
		 MasterCard invalid = new MasterCard("123", null);
		 ls.add(invalid);
	
	    ls = validator.validate( ls);
		assertNotNull(ls);
		//assertTrue(ls.size() == 1);
		System.out.println(ls.size());
		assertTrue(((CreditCard) ls.get(0)).getCardName().equalsIgnoreCase(Card.MASTERCARD.getName()));
		
		
	}

}
