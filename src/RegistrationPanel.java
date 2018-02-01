import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegistrationPanel extends JFrame {

	private JTextField userArea;
	private JPasswordField passwordArea;
	private JPasswordField confirmPWDArea;
	private JButton registerBtn;
	private JButton cancelBtn;
	private JLabel user;
	private JLabel pass;
	private JLabel confirmPWD;
	private JLabel msgBoard;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem menuItem;
	private BufferedImage appIcon;
	private MainPanel mP = new MainPanel();
	

	public RegistrationPanel() {
		super("MyMoney");

		// Menu bar settings
		menuBar = new JMenuBar();
		placeMenu(menuBar, menu, menuItem);

		// Buttons, text fields and icon settings
		appIcon = chooseIconImage(appIcon, "money.png");

		registerBtn = new JButton("Register Account");

		registerOnClick();

		cancelBtn = new JButton("Cancel");
		closeOnCancelClick(cancelBtn);

		user = new JLabel("Username");
		userArea = new JTextField("", 15);

		pass = new JLabel("Password");
		passwordArea = new JPasswordField("", 15);
		confirmPWD = new JLabel("Confirm PWD");
		confirmPWDArea = new JPasswordField("", 15);
		msgBoard = new JLabel("");
	}

	public void setupForPanel() {
		// Layout settings
		setLayout(new GridBagLayout());
		placeButtons();

		// Panel settings
		setSize(800, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(appIcon);
		setJMenuBar(menuBar);
		setResizable(true);
		setVisible(true);
	}

	private void placeButtons() {
		GridBagConstraints gb = new GridBagConstraints();

		gb.gridx = 0;
		gb.gridy = 0;
		add(user, gb);

		gb.gridx = 1;
		gb.gridy = 0;
		add(userArea, gb);

		gb.gridx = 0;
		gb.gridy = 1;
		add(pass, gb);

		gb.gridx = 1;
		gb.gridy = 1;
		add(passwordArea, gb);

		gb.gridx = 0;
		gb.gridy = 2;
		add(confirmPWD,gb);

		gb.gridx = 1;
		gb.gridy = 2;
		add(confirmPWDArea,gb);

		gb.insets = new Insets(10, 10, 10, 10);
		gb.gridx = 0;
		gb.gridy = 3;
		add(registerBtn, gb);

		gb.insets = new Insets(10, 10, 10, 10);
		gb.gridx = 1;
		gb.gridy = 3;
		add(cancelBtn, gb);
		
		gb.gridx =3;
		gb.gridy = 6;
		add(msgBoard);
	}

	private void placeMenu(JMenuBar menuBar, JMenu menu, JMenuItem menuItem) {
		menu = new JMenu("Registration");
		menuBar.add(menu);
		// menuItem = new JMenuItem("Account Registration", KeyEvent.VK_A);

		menuItem = new JMenuItem(new AbstractAction("Account Registration") {

			public void actionPerformed(ActionEvent e) {

				// Menu item click logic!
				
				
			
			}
		});

		menu.add(menuItem);

		menu = new JMenu("Help");
		menuBar.add(menu);
		menuItem = new JMenuItem("Documentation", KeyEvent.VK_D);
		menu.add(menuItem);

		menu = new JMenu("About");
		menuBar.add(menu);
		menuItem = new JMenuItem("MyMoney", KeyEvent.VK_M);
		menu.add(menuItem);
	}

	public final void closeOnCancelClick(JButton btn) {
		btn.addActionListener((ActionEvent e) -> {
			dispose();
		});
	}

	public final BufferedImage chooseIconImage(BufferedImage icon, String path) {
		try {
			icon = ImageIO.read(getClass().getClassLoader().getResource(path));
		} catch (IOException e) {
			e.getMessage();
		}
		return icon;
	}

	/**
	 * Method handles the onclickEvent of the registration button.
	 */
	private void registerOnClick() {
		registerBtn.addActionListener((ActionEvent e) -> {

			String username = userArea.getText();
			String password = passwordArea.getText();
			String confirmPassword = confirmPWDArea.getText();

			if (!(username.equals("") || password.equals("") ||confirmPassword.equals(""))) {
				
				//Check if the passwords match.
				if (password.equals(confirmPassword)) {

					// Check if user exist already.
					if (!LogIn.validateUser(username, password)) {
						
						//Add user login to log_in file
						LogIn.recordNewUser(username, password);
						
						this.dispose();
						mP.setupForPanel();
						mP.setMessage("Account created. Please, login");

					} else {

						// Notify: Passwords do not match!!
						setupForPanel();
						msgBoard.setText("Username not available!");
					}

				}
				else{
					//Display on error panel
					
					setupForPanel();
					msgBoard.setText("Passwords did not match! Please, try again.");
				}
			}
			else{
				//Display on error panel
				setupForPanel();
			msgBoard.setText("Please, enter username and password.");
			}
			// MainPanel panel = new FinancePanel();
			// panel.setupForPanel();
			//this.dispose();
		});
	}

	public String sendUserName() {

		return userArea.toString();
	}

	public String sendUserPassword() {

		return passwordArea.toString();
	}
	
	
}
