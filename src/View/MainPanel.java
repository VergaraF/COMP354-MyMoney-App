package View;

import java.awt.Dimension;

/**
 *
 * COMP 354 Project
 * Group PJ-A
 
 * This is the main GUI class for user login or registration. 
 */

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

import Controller.LogIn;

public class MainPanel extends JFrame {

	private final JTextField userArea;
	private final JPasswordField passwordArea;
	private final JButton logBtn;
	private final JButton cancelBtn;
	private final JLabel user;
	private final JLabel pass;
	private JLabel message;
	private final JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem menuItem;
	private BufferedImage appIcon;
	private static int loginCount = -1;

	public MainPanel() {
		super("MyMoney");

		// Menu bar settings
		menuBar = new JMenuBar();
		placeMenu(menuBar, menu, menuItem);

		// Buttons, text fields and icon settings
		appIcon = chooseIconImage(appIcon, "money.png");

		logBtn = new JButton("Log in");
		logInOnClick();

		cancelBtn = new JButton("Cancel");
		closeOnCancelClick(cancelBtn);

		user = new JLabel("Username");
		userArea = new JTextField("", 15);

		pass = new JLabel("Password");
		passwordArea = new JPasswordField("", 15);

		message = new JLabel("Login or Create an account");

	}

	public void setupForPanel() {
		// Layout settings
		setLayout(new GridBagLayout());
		placeButtons();

		// Panel settings
		setMinimumSize(new Dimension(960, 720));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(appIcon);
		setJMenuBar(menuBar);
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

		gb.insets = new Insets(10, 0, 0, 0);
		gb.gridx = 0;
		gb.gridy = 2;
		add(logBtn, gb);

		gb.insets = new Insets(10, 0, 0, -95);
		gb.gridx = 1;
		gb.gridy = 2;
		add(cancelBtn, gb);

		gb.gridx = 0;
		gb.gridy = 3;
		add(message, gb);
	}

	private void placeMenu(JMenuBar menuBar, JMenu menu, JMenuItem menuItem) {
		menu = new JMenu("Registration");
		menuBar.add(menu);
		// menuItem = new JMenuItem("Account Registration", KeyEvent.VK_A);

		menuItem = new JMenuItem(new AbstractAction("Account Registration") {

			public void actionPerformed(ActionEvent e) {

				// Code for registration menuAction
				RegistrationPanel regPanel = new RegistrationPanel();
				regPanel.setupForPanel();

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

	private void logInOnClick() {

		logBtn.addActionListener((ActionEvent e) -> {
			MainPanel panel = new BankPanel();
			// this.dispose();

			if (LogIn.validateUser(sendUserName(), sendUserPassword())) {

				panel.setupForPanel();
				userArea.setText("");
				passwordArea.setText("");
				loginCount = -1;

			} else {
				// Maximum number of login attempts is 3
				if (loginCount < 4) {
					setMessage("Username and password did not match! Try again");

				} else {

					setMessage("Too many login attempts! Exiting!!");

					try {
						Thread.sleep(5000);

					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					this.dispose();

				}
			}

		});
		// Count the number of login attempts.
		loginCount++;
	}

	public String sendUserName() {

		return userArea.getText();
	}

	public String sendUserPassword() {

		return passwordArea.getText();
	}

	// Method sets a directive message on the message board panel
	public void setMessage(String text) {
		message.setText(text);
	}

}
