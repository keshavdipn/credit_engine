import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.tiaa.credit.constants.Card;
import com.tiaa.credit.domain.AmexCard;
import com.tiaa.credit.domain.DiscoverCard;
import com.tiaa.credit.domain.MasterCard;
import com.tiaa.credit.domain.VisaCard;
import com.tiaa.credit.generator.AmexCardGenerator;
import com.tiaa.credit.generator.DiscoverCardGenerator;
import com.tiaa.credit.generator.MasterCardGenerator;
import com.tiaa.credit.generator.VisaCardGenerator;

public class CardGeneratorTest {
	
	
	@Test
	public void testAmex(){
		AmexCardGenerator amexGen = new AmexCardGenerator();
		List<AmexCard> ls = amexGen.generateAmex(2);
		assertNotNull(ls);
		assertTrue(ls.size() == 2);
		assertTrue(ls.get(0).getCardNumber().startsWith("37"));
		assertTrue(ls.get(0).getCardName().equalsIgnoreCase(Card.AMERICANEXPRESS.getName()));	
		
	}
	
	@Test
	public void testVisa(){
		VisaCardGenerator visaGen = new VisaCardGenerator();
		List<VisaCard> ls = visaGen.generateVisa(2);
		assertNotNull(ls);
		assertTrue(ls.size() == 2);
		assertTrue(ls.get(0).getCardNumber().startsWith("4"));
		assertTrue(ls.get(0).getCardName().equalsIgnoreCase(Card.VISA.getName()));	
		
	}
	
	@Test
	public void testMaster(){
		MasterCardGenerator masterGen = new MasterCardGenerator();
		List<MasterCard> ls = masterGen.generateMaster(2);
		assertNotNull(ls);
		assertTrue(ls.size() == 2);
		assertTrue(ls.get(0).getCardNumber().startsWith("5"));
		assertTrue(ls.get(0).getCardName().equalsIgnoreCase(Card.MASTERCARD.getName()));	
		
	}
	
	@Test
	public void testDiscover(){
		DiscoverCardGenerator discoverGen = new DiscoverCardGenerator();
		List<DiscoverCard> ls = discoverGen.generateDiscover(2);
		assertNotNull(ls);
		assertTrue(ls.size() == 2);
		assertTrue(ls.get(0).getCardNumber().startsWith("6"));
		assertTrue(ls.get(0).getCardName().equalsIgnoreCase(Card.DISCOVER.getName()));	
		
	}
	
	
	

}
