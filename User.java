
/**
 *
 * @author Jean-Loup
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class User {
	private String password;
	private String userName;

	public String displayTransactions() {
		Scanner s1 = null;

		try {
			s1 = new Scanner(new FileInputStream("..//datafiles//Bank"));
		} catch (FileNotFoundException e) {
			System.out.print("file could not be found.");

		}
		String transactions = "<html>";

		while (s1.hasNextLine()) {
			transactions += s1.nextLine() + "<br>";
		}

		s1.close();

		return transactions;
	}

	public String displaySavings() {
		Scanner s1 = null;

		try {
			s1 = new Scanner(new FileInputStream("..//datafiles//Bank"));
		} catch (FileNotFoundException e) {
			System.out.print("File could not be found.");

		}
		String savings = "";

		savings = s1.next();

		s1.close();

		return savings;
	}

	public User() {
		password = "";
		userName = "";

	}

	public User(String password, String userName) {
		super();
		this.password = password;
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}