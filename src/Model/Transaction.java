package Model;

public class Transaction {

	public String date;
	public double amount;
	public String enterprise;
	public String category;
	
	public Transaction(double amount, String date, String enterprise, String category) {
		this.amount = amount;
		this.date = date;
		this.enterprise = enterprise;
		this.category = category;
	}
	
	public String toString() {
		return this.amount + " " + this.date + " " + this.enterprise + " " + this.category;
	}
	
}
