import junit.framework.TestCase;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

class BankingInfoTest {

	//Test that the transaction file is opened and not empty.
	@Test
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
