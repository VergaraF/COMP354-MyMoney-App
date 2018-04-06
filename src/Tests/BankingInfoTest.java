




package Tests;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Model.Model;
import Controller.Advice;
import Controller.TransactionsController;

public class BankingInfoTest {

	
	//Test that the transaction file is opened and not empty.
	@Test
	public void testTransactions() {
		String transactions = TransactionsController.getRawStringTransactions();
		
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
		String transactions = TransactionsController.getTransactionStringGroupedByDate();
		
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
		trans.addTransactions(".//datafiles//transactions_data");
		trans.exportTransactionsToFiles();
		
		assertTrue(new File(".//datafiles//transactions//").exists());
	}
	
	//savings info
		@Test
		public void testSavingsInfo() {
			   ArrayList<String> arr = new ArrayList<String>();
		        try (BufferedReader br = new BufferedReader(new FileReader(".//datafiles//Transacations")))
		        {

		            String sCurrentLine;

		            while ((sCurrentLine = br.readLine()) != null) {
		                arr.add(sCurrentLine);
		            }

		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		        
		        Advice a1 = new Advice();
		       String test = a1.savingAdvice(arr);   
		       
		       
		       if(test!=null)
				{
				assertTrue(true);
				}
				else 
					assertFalse(true);
		       
			}

}

















