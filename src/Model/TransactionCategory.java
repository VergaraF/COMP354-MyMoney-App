package Model;

public enum TransactionCategory 
{
	OTHER(0),
	HOME(1),
	FOOD(2),
	HOBBIES(3),
	SAVINGS(4),
	HEALTH(5),
	SAVE(6),
	ENTR(7),
	DEBT(8),
	CAR(9),
	INCOME(10),
	TRANSPORT(11);
	
	private int value;
	
	private TransactionCategory(int value) 
	{
		this.value = value;
	}
	
	public int getValue() 
	{
		return value;
	}
	
	public static TransactionCategory fromString(String text) 
	{
	    for (TransactionCategory category : TransactionCategory.values()) 
	    {
	    	if (text.equalsIgnoreCase(category.toString())) 
	    	{
	    		return category;
	    	}
	    }
	    
	    return TransactionCategory.OTHER;
	}
}
