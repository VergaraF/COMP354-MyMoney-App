package Model;

public class Transaction {

	public String date;
	public double amount;
	public String enterprise;
	public TransactionCategory category;
	
	public Transaction(double amount, String date, String enterprise, TransactionCategory category) {
		this.amount = amount;
		this.date = date;
		this.enterprise = enterprise;
		this.category = category;
	}
	
	public String toString() {
		return this.amount + " " + this.date + " " + this.enterprise + " " + this.category.toString().toLowerCase();
	}
	
}
