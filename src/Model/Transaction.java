package Model;

public class Transaction {

	public String date;
	public int amount;
	public String enterprise;
	public String category;
	
	public Transaction(int amount, String date, String enterprise, String category) {
		this.amount = amount;
		this.date = date;
		this.enterprise = enterprise;
		this.category = category;
	}
	
	public String toString() {
		return this.amount + " " + this.date + " " + this.enterprise + " " + this.category;
	}
	
}
