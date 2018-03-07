
public enum TransactionCategory 
{
	HOME(1),
	FOOD(2),
	HOBBIES(3),
	SAVINGS(4),
	OTHER(5);
	
	private int value;
	
	private TransactionCategory(int value) 
	{
		this.value = value;
	}
	
	public int getValue() 
	{
		return value;
	}
}
