
/**
 * This is controller class for the application.
 */
import javax.swing.SwingUtilities;

public class MyMoneyController {

	private static MainPanel mp;
	private static Model aModel;

	/**
	 * Controller operations
	 */

	public static void controller() {
	
		/**
		 * Set up GUIs on start.
		 */
		SwingUtilities.invokeLater(() -> {
			MainPanel p = new MainPanel();
			p.setupForPanel();
		});

		/**
		 * Read userInfo files for login
		 */

		LogIn.readUserInfo();

		/**
		 * Read user data files
		 */

	}

	public static String getFinanceStatement() {

		mp = new MainPanel();
		aModel = new Model(mp.sendUserName(), mp.sendUserPassword());
		return aModel.readUserData();

	}

}
