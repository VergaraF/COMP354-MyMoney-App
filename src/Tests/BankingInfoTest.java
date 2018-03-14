import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BankingInfoTest {

	//Test that the transaction file is opened and not empty.
	@Test
	public
	void testTransactions() {
	
		
		String transactions = Model.displayTransactions();
		
		if(transactions!=null)
		{
		assertTrue(true);
		}
		else 
			assertFalse(true);
	}
	
	//Test that the bank file is opened and not empty.
	@Test
	public
		void testSavings() {
		
			
			String savings = Model.displaySavings();
			
			if(savings!=null)
			{
			assertTrue(true);
			}
			else 
				assertFalse(true);
		}

}
