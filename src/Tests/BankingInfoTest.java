package Tests;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.LinkOption;

import org.junit.jupiter.api.Test;

import Model.Model;
import Controller.TransactionsController;

public class BankingInfoTest {

	
	//Test that the transaction file is opened and not empty.
	@Test
	public void testTransactions() {
		String transactions = TransactionsController.getRawStringTransacations();
		
		if(transactions!=null)
		{
		assertTrue(true);
		}
		else 
			assertFalse(true);
	}
	
	//Test that the bank file is opened and not empty.
	@Test
	public void testSavings() {
		String savings = Model.displaySavings();
		if(savings!=null){
			assertTrue(true);
		}
		else {
				assertFalse(true);
		}
	}
	
	//Test we get transactions by date
	@Test
	public void testTransactionsByDate() {
		String transactions = TransactionsController.getTransacationStringGroupedByDate();
		
		if(transactions!=null)
		{
		assertTrue(true);
		}
		else 
			assertFalse(true);
	}
	
	//test sorted files are created
	@Test
	public void testFileCreation() {
		TransactionsController trans = new TransactionsController();
		trans.addTransactions(".//datafiles//Transacations");
		trans.exportTransactionsToFiles();
		
		assertTrue(new File(".//datafiles//transactions//").exists());
	}

}
