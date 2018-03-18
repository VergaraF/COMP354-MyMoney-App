package Controller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import Model.*;

public class TransactionsController {

	//public TransactionsGroup transactions;
	private static Map<String, TransactionsGroup> transactions = new HashMap<String, TransactionsGroup>();
	
	public TransactionsController() {}
	
	public void addTransactions(String transactionFilePath) {
		ArrayList<String> entries = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader(transactionFilePath)))
        {
            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                entries.add(sCurrentLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
                   
        //-47.95 2017-05-09 STM Transport
        for (String entry : entries) {  		
        		String[] data = entry.split("\\s+");
        		if (data.length < 4) break;
        		
        		String amount = data[0];
        		String date = data[1];
        		String enterprise = data[2];  
        		TransactionCategory category = TransactionCategory.fromString(data[3]);

        			if (!transactions.containsKey(date)) {
            			transactions.put(date, new TransactionsGroup());
            		}
            		transactions.get(date).addTransaction(new Transaction(Double.parseDouble(amount), date, enterprise, category));
		}     
	}
	
	public void exportTransactionsToFiles() {
		boolean createDir = new File(".//datafiles//transactions").mkdirs();
		for (Entry<String, TransactionsGroup> entry : transactions.entrySet()) {
		    String key = entry.getKey();
		    TransactionsGroup transactionsPerGivenDate = entry.getValue();
		    
		    List<String> transactionEntries = new LinkedList<String>();
		    
		    for (Transaction transaction: transactionsPerGivenDate.transactions) { 	
		    		transactionEntries.add(transaction.toString());
		    }
		    
		    Path file = Paths.get(".//datafiles//transactions//" + key +".txt");

		    try {
				Files.write(file, transactionEntries, Charset.forName("UTF-8"));
			} catch (IOException e) {			
				e.printStackTrace();
			}
		}
	}
	
	public Map<String, TransactionsGroup> getTransactionsMapWithDateKeys(){
		return this.transactions;
	}
	
	public static Transaction[] GetTransactions()
	{
		List<Transaction> transactionsList = new ArrayList<Transaction>();
		
		for (TransactionsGroup transactionsGroup : transactions.values())
		{
			transactionsList.addAll(transactionsGroup.transactions);
		}
		
		return transactionsList.toArray(new Transaction[0]);
	}
	
	public static String getTransacationStringGroupedByDate() {
		String temp = "<html>";
		for (Entry<String, TransactionsGroup> entry : transactions.entrySet()) {
		    String key = entry.getKey();
		    TransactionsGroup transactionsPerGivenDate = entry.getValue();
		    
		   // List<String> transactionEntries = new LinkedList<String>();
		    temp += "<b>" + key + "=> </b>";
		    for (Transaction transaction: transactionsPerGivenDate.transactions) { 	
		    		temp += transaction.toString() +"<br/>";
		    }
		}
		
		temp += "</html>";
		return temp;
	}
	public static  String getRawStringTransacations() {
		Scanner s1 = null;

		try {
			s1 = new Scanner(new FileInputStream(".//datafiles//Transacations"));
		} catch (FileNotFoundException e) {
			System.out.print("file could not be found.");

		}
		String transactions = "<html>";

		while (s1.hasNextLine()) {
			transactions += s1.nextLine() + "<br/>";
		}

		s1.close();

		transactions += "</html>";
		return transactions;
	}

	
}
