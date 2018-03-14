package Model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TransactionsGroup {

	public List<Transaction> transactions; 
	
	public TransactionsGroup() {
		this.transactions = new LinkedList<Transaction>();
	};
	
	public void addTransaction(Transaction transaction) {
		this.transactions.add(transaction);
	}
}