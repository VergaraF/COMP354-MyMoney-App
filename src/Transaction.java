
public class Transaction 
{
	private float _amount;
	private String _date;
	private String _business;
	private TransactionCategory _category;
	
	public Transaction(float amount, String date, String business, TransactionCategory category) 
	{
		_amount = amount;
		_date = date;
		_business = business;
		_category = category;
	}

	public float GetAmount() 
	{
		return _amount;
	}

	public String GetDate() 
	{
		return _date;
	}

	public String GetBusiness() 
	{
		return _business;
	}

	public TransactionCategory GetCategory() 
	{
		return _category;
	}
}
