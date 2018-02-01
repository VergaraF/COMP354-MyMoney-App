import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LogIn {

	private static ArrayList<String> login_info = new ArrayList<String>();
	private static FileWriter writer;
	private static boolean loggedIn = false;

	/**
	 * Adds user login info to arrayList.
	 * 
	 * @param string
	 */
	public static void recordNewUser(String username, String password) {

		// Check if this user name and password combination already exist.
		// if (!validateUser(username, password)) {

		String newUserInfo = username + "::" + password;

		// Add user details to array list.
		login_info.add(newUserInfo);

		// write user details to file.
		saveUserInfo(newUserInfo);

		// }

		// Set logIn status to true.
		loggedIn = true;

	}

	/**
	 * Method writes user login info to file.
	 */
	public static void saveUserInfo(String userInfo) {

		try {
			writer = new FileWriter("..//datafiles//login_info", true);
			if (userInfo != "") {
				writer.write("\n" + userInfo);
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
		String lineString = "";
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("..//datafiles//login_info"));
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

		String savedInfo = username + "::" + password;

		return login_info.contains(savedInfo);
	}

}
