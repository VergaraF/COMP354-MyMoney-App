/**
 * COMP 354 Project
 * Group PJ-A
 */
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JLabel;

import Controller.*;

/**
 *
 * @author vincent
 */
public class BankPanel extends MainPanel {
	private JButton clsButton;
	private JButton budgetButton;

	private BufferedImage appIcon;
	private final JLabel bankInfo;
	private final JLabel Savings;
	private final JLabel SavingsInfo;
	private final JLabel Transactions;
	private final JLabel TransactionsInfo;

	public BankPanel() {
		System.out.println("Generating data files");
		TransactionsController transController = new TransactionsController();
		transController.addTransactions(".//datafiles//Transacations");
		transController.exportTransactionsToFiles();
		
		
		appIcon = chooseIconImage(appIcon, "money.png");
		bankInfo = new JLabel("Banking Information");
		Savings = new JLabel("<HTML><U>Savings</U></HTML>");
		SavingsInfo = new JLabel(Model.displaySavings());
		Transactions = new JLabel("<HTML><U>Transactions</U></HTML>");
		TransactionsInfo = new JLabel(Model.displayTransactions());
		clsButton = new JButton("Exit");
		budgetButton = new JButton("Budget");
		closeOnCancelClick(clsButton);
		goToBudget(budgetButton);

	}

	public final void goToBudget(JButton btn) {
		btn.addActionListener((ActionEvent e) -> {
			FinanceController.setup();

		});
	}

	@Override
	public void setupForPanel() {

		setSize(900, 900);
		setResizable(false);
		setVisible(true);
		setLayout(new GridBagLayout());
		placeButtons();

		setIconImage(appIcon);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		bankInfo.setFont(new Font("SansSerif", Font.PLAIN, 28));
		Transactions.setFont(new Font("SansSerif", Font.PLAIN, 20));
		Savings.setFont(new Font("SansSerif", Font.PLAIN, 20));
	}

	private void placeButtons() {
		GridBagConstraints gb = new GridBagConstraints();

		gb.insets = new Insets(5, 5, 5, 5);
		gb.gridx = 2;
		gb.gridwidth = 3;
		gb.gridy = 0;
		gb.weightx = 1;
		gb.weighty = 1;

		add(bankInfo, gb);

		gb.insets = new Insets(5, 5, 5, 5);
		gb.gridx = 1;
		gb.gridwidth = 2;
		gb.gridy = 1;
		add(Savings, gb);

		gb.insets = new Insets(5, 5, 5, 5);
		gb.gridx = 3;
		gb.gridwidth = 2;
		gb.gridy = 1;
		add(Transactions, gb);

		gb.weighty = 10;

		gb.anchor = GridBagConstraints.NORTH;

		gb.insets = new Insets(5, 5, 5, 5);
		gb.gridx = 1;
		gb.gridwidth = 2;
		gb.gridy = 2;
		add(SavingsInfo, gb);

		gb.insets = new Insets(5, 5, 5, 5);
		gb.gridx = 3;
		gb.gridwidth = 2;
		gb.gridy = 2;
		gb.gridheight = 2;
		add(TransactionsInfo, gb);

		gb.anchor = GridBagConstraints.NORTH;
		gb.weighty = 3;
		gb.insets = new Insets(5, 5, 5, 5);
		gb.gridx = 1;
		gb.gridwidth = 3;
		gb.gridy = 3;
		add(clsButton, gb);

		gb.anchor = GridBagConstraints.NORTH;
		gb.weighty = 3;
		gb.insets = new Insets(5, 5, 5, 5);
		gb.gridx = 3;
		gb.gridwidth = 3;
		gb.gridy = 3;
		add(budgetButton, gb);

		setResizable(true);
	}

}
