package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import Controller.LogIn;

/**
 * A model of the MyMoney App
 * 
 * @author Kisife
 *
 */

public class Model {

	private String userName;
	private String password;
	private String inputFileName;
	private static String savings;

	public Model(String userName, String password) {
		this.userName = userName;
		this.password = password;
		this.inputFileName = getUserDataFile(this.userName, this.password);

	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getInputFileName() {
		return inputFileName;
	}

	public void setInputFileName(String inputFileName) {
		this.inputFileName = inputFileName;
	}
	
	public static void setSavings(String save)
	{
		savings = save;
	}

	public static String displaySavings() {
		
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
