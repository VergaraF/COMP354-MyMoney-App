package Model;

import java.util.ArrayList;
import java.util.List;

public class TransactionsGroup {

	public List<Transaction> transactions; 
	
	public TransactionsGroup() {};
	
	public void addTransaction(Transaction transaction) {
		this.transactions.add(transaction);
	}
}