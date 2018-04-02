package Controller;
/**
 *
 * COMP 354 Project
 * Group PJ-A

 * This is LogIn class. it handles user login behavior.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LogIn {

	public static ArrayList<String> login_info = new ArrayList<String>();
	private static FileWriter writer;
	private static boolean loggedIn = false;

	/**
	 * Adds user login info to arrayList.
	 * 
	 * @param string
	 */
	public static void recordNewUser(String username, String password) {

		// Compose a user info string to save in file.
		String newUserInfo = username + "::" + password;

		// write user details to file.
		saveUserInfo(newUserInfo);

		// Set logIn status to true.
		loggedIn = true;

	}

	/**
	 * Method writes user login info to file.
	 * @throws NoSuchAlgorithmException 
	 */
	public static void saveUserInfo(String userInfo) {

		try {
			writer = new FileWriter(".//datafiles//login_info", true);
			if (userInfo != "") {
				
				String encryptedString = EncryptionController.OneWayEncrypt(userInfo);
				
				writer.write("\n" + encryptedString);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				writer.flush();
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	/**
	 * Method reads user login info from file and save in array list for look
	 * up.
	 */

	public static void readUserInfo() {
		
		login_info.clear();
		
		String lineString = "";
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(".//datafiles//login_info"));
			// reader = new BufferedReader(new FileReader("login_info"));
			while ((lineString = reader.readLine()) != null) {
				login_info.add(lineString);

			}

		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	/**
	 * 
	 * @param userLogin
	 *            user login info.
	 * @return true if user info exist in file else false.
	 */
	public static boolean validateUser(String username, String password) {

		readUserInfo();
		
		String encryptedString = EncryptionController.OneWayEncrypt(username + "::" + password);
		
		return login_info.contains(encryptedString);
	}

}
