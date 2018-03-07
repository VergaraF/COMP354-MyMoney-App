
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

/**
 * A model of the MyMoney App
 * 
 * @author Kisife
 *
 */

public class Model 
{
	public static Model Instance;
	
	private String userName;
	private String password;
	private String inputFileName;
	private Transaction[] Transactions;
	
	public Model(String userName, String password) 
	{
		Instance = this;
		
		this.userName = userName;
		this.password = password;
		this.inputFileName = getUserDataFile(this.userName, this.password);
		
		Transactions = LoadTransactions();
	}

	public String getUserName() 
	{
		return userName;
	}

	public void setUserName(String userName) 
	{
		this.userName = userName;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getInputFileName() 
	{
		return inputFileName;
	}

	public void setInputFileName(String inputFileName) 
	{
		this.inputFileName = inputFileName;
	}
	
	public Transaction[] GetTransactions() 
	{
		return Transactions;
	}

	public Transaction[] LoadTransactions() 
	{
		Scanner file = null;

		try 
		{
			file = new Scanner(new FileInputStream(".//datafiles//Transacations"));
		} 
		catch (FileNotFoundException e) 
		{
			System.out.print("file could not be found.");

		}
		
		ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
		
		while (file.hasNextLine()) 
		{
			String line = file.nextLine();
			
			String[] transactionData = line.split(" ");
			Transaction newTransaction = new Transaction(
					Float.parseFloat(transactionData[0]), 
					transactionData[1], 
					transactionData[2], 
					TransactionCategory.valueOf(transactionData[3].toUpperCase())
			);
			
			transactionList.add(newTransaction);
		}

		file.close();
		
		return transactionList.toArray(new Transaction[transactionList.size()]);
	}
	
	public String DisplayTransactions()
	{
		String transactionString = "<html>";
		
		for(int i = 0; i < Transactions.length; i++)
		{
			String transactionLine = ""; 
			
			transactionLine += String.valueOf(String.format("%.2f", -Transactions[i].GetAmount()));
			transactionLine += ", ";
			transactionLine += Transactions[i].GetDate();
			transactionLine += ", ";
			transactionLine += Transactions[i].GetBusiness();
			transactionLine += ", ";
			transactionLine += Transactions[i].GetCategory().toString().toLowerCase();
			
			transactionString += transactionLine + "<br>";
		}
		
		return transactionString;
	}

	public String displaySavings() 
	{
		Scanner file = null;

		try {
			file = new Scanner(new FileInputStream(".//datafiles/savings"));
		} 
		catch (FileNotFoundException e) 
		{
			System.out.print("File could not be found.");
		}
		
		String savings = "";

		savings = file.next();

		file.close();

		return savings;
	}

	/**
	 * Use case one: As a user, user is able to create and access his account
	 */

	public void createUserAccounnt(String userName, String password) {
		// Create a new user object.
		Model aModel = new Model(userName, password);

		// Save user info into file/database
		saveUserInfo(userName, password);
	}

	/**
	 * Use case two: A user is able to load and see data from a bank account
	 */
	/**
	 * 
	 * @param fileString
	 *            input file name.
	 * @return The method returns the contents of the file as a single string.
	 */
	public String readUserData() {

		String fileString = this.inputFileName;

		InputStream inStream = null;
		BufferedReader reader = null;
		String readFile = null;
		String line;
		StringBuilder sb;

		try {
			inStream = new FileInputStream(fileString);
			reader = new BufferedReader(new InputStreamReader(inStream));

			line = reader.readLine();
			sb = new StringBuilder();

			while (line != null) {
				sb.append(line).append("\n");
				line = reader.readLine();
			}
			readFile = sb.toString();

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return readFile;
	}

	/**
	 * Use case three: A user is able to set financial goals to his file account
	 */
	public void setNewGoal() {

	}

	/**
	 * Method returns the corresponding file name for user data.
	 * 
	 * @param inputFileName
	 */
	private String getUserDataFile(String username, String password) {
		String fileName = "";

		if (LogIn.validateUser(username, password)) {

			fileName = "..//datafiles//default";
		} else {

			fileName = "..//datafiles//user_not_found";
		}

		/**
		 * if (username.equals("userOne") &&
		 * password.equals("userOne_password")) { fileName = "userOne"; } if
		 * (username.equals("userTwo") && password.equals("userTwo_password")) {
		 * fileName = "userTwo"; }
		 */

		return fileName;
	}

	/**
	 * This method saves user information to file/database.
	 * 
	 * @param userName2
	 * @param password2
	 */

	private void saveUserInfo(String userName2, String password2) {
		// TODO Auto-generated method stub

	}

}