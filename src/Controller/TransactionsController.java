package Controller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import Model.*;

public class TransactionsController {

	//public TransactionsGroup transactions;
	private Map<String, TransactionsGroup> transactions;
	
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
        		Scanner scan = new Scanner(entry);
        		scan.useDelimiter("\\s*");
        		
        		String amount = scan.next();
        		String date = scan.next();
        		String enterprise = scan.next();
        		String category = scan.next();
        		if (!transactions.containsKey(date)) {
        			transactions.put(date, new TransactionsGroup());
        		}
        		transactions.get(date).addTransaction(new Transaction(Integer.parseInt(amount), date, enterprise, category));
        		//transactions.addTransaction(new Transaction(Integer.parseInt(amount), date, enterprise, category));

        		scan.close();
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
		    //transactionsPerGivenDate.transactions.
		    try {
				Files.write(file, transactionEntries, Charset.forName("UTF-8"));
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
	
}
