package View;
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
import Model.Model;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;

/**
 *
 * @author vincent
 */
public class BankPanel extends MainPanel {
	private JButton clsButton;
	private JButton budgetButton;
	private JButton rawButton;
	private JButton groupByDateButton;

	private BufferedImage appIcon;
	private final JLabel bankInfo;
	private final JLabel Savings;
	private final JLabel SavingsInfo;
	private final JLabel Transactions;
	//michael
	private final JLabel Advices;
	private final JTextPane AdviceInfo;
	//
	private final JLabel TransactionsInfo;
	
	TransactionsController transactionController = new TransactionsController();

	public BankPanel() {
		getContentPane().setLayout(null);
		
		
		
		
		//[Fabian]
		System.out.println("Generating data files");
		
		transactionController.addTransactions(".//datafiles//Transacations");
		transactionController.exportTransactionsToFiles();
		//
		
		appIcon = chooseIconImage(appIcon, "money.png");
		
		bankInfo = new JLabel("Banking Information");
		Savings = new JLabel("<HTML><B>Savings</B></HTML>");
		SavingsInfo = new JLabel(Model.displaySavings());
		Transactions = new JLabel("<HTML><B>Transactions</B></HTML>");
		TransactionsInfo = new JLabel(transactionController.getRawStringTransacations());
		
		//michael
		Advice finan_Advice = new Advice();
		finan_Advice.execute();
		Advices = new JLabel("<HTML><B>Advice</U></HTML>");
		//AdviceInfo = new JLabel(finan_Advice.Advice);
		
		AdviceInfo = new JTextPane();
		AdviceInfo.setText(finan_Advice.Advice);
		//AdviceInfo.setBounds(300, 50, 10, 40);
		getContentPane().add(AdviceInfo);
		
		/*
		JTextPane txtpnHello = new JTextPane();
		txtpnHello.setText("hello");
		txtpnHello.setBounds(287, 199, 6, 20);
		getContentPane().add(txtpnHello);*/
		//
		
		clsButton = new JButton("Exit");
		budgetButton = new JButton("Budget");
		rawButton = new JButton("Raw");
		groupByDateButton = new JButton("Date");
		
		showRawTransacation(rawButton);
		showTransacationsGroupedByDate(groupByDateButton);
		closeOnCancelClick(clsButton);
		goToBudget(budgetButton);

	}

	public final void showRawTransacation(JButton btn) {
		btn.addActionListener((ActionEvent e) -> {
			this.TransactionsInfo.setText(transactionController.getRawStringTransacations());
		});
	}
	
	public final void showTransacationsGroupedByDate(JButton btn) {
		btn.addActionListener((ActionEvent e) -> {
			this.TransactionsInfo.setText(transactionController.getTransacationStringGroupedByDate());
		});
	}
	
	public final void goToBudget(JButton btn) {
		btn.addActionListener((ActionEvent e) -> {
			FinanceController.setup();
		});
	}

	@Override
	public void setupForPanel() {

		setSize(2000, 2000);
		setResizable(false);
		setVisible(true);
		getContentPane().setLayout(new GridBagLayout());
		placeButtons();

		setIconImage(appIcon);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		bankInfo.setFont(new Font("SansSerif", Font.PLAIN, 28));
		Transactions.setFont(new Font("SansSerif", Font.PLAIN, 20));
		Savings.setFont(new Font("SansSerif", Font.PLAIN, 20));
		//michael
		Advices.setFont(new Font("SansSerif", Font.PLAIN, 20));
		//
	}

	private void placeButtons() {
		GridBagConstraints gb = new GridBagConstraints();

		gb.insets = new Insets(5, 5, 5, 5);
		gb.gridx = 2;
		gb.gridwidth = 3;
		gb.gridy = 0;
		gb.weightx = 1;
		gb.weighty = 1;
		getContentPane().add(bankInfo, gb);

		gb.insets = new Insets(5, 5, 5, 5);
		gb.gridx = 1;
		gb.gridwidth = 2;
		gb.gridy = 1;
		getContentPane().add(Advices, gb);
		
		//michael
		gb.insets = new Insets(5, 5, 5, 5);
		gb.gridx = 3;
		gb.gridwidth = 2;
		gb.gridy = 1;
		getContentPane().add(Savings, gb);
		//
		
		gb.insets = new Insets(5, 5, 5, 5);
		gb.gridx = 5;
		gb.gridwidth = 2;
		gb.gridy = 1;
		getContentPane().add(Transactions, gb);

		gb.weighty = 10;

		gb.anchor = GridBagConstraints.NORTH;

		gb.insets = new Insets(5, 5, 5, 5);
		gb.gridx = 3;
		gb.gridwidth = 2;
		gb.gridy = 2;
		getContentPane().add(SavingsInfo, gb);

		gb.insets = new Insets(55, 5, 5, 5);
		gb.gridx = 5;
		gb.gridwidth = 4;
		gb.gridy = 2;
		gb.gridheight = 2;
		getContentPane().add(TransactionsInfo, gb);
		
		
		gb.anchor = GridBagConstraints.NORTH;
		gb.insets = new Insets(55, 5, 5, 5);
		gb.gridx = 2;
		gb.gridwidth = 2;
		gb.gridy = 2;
		gb.gridheight = 2;
		getContentPane().add(AdviceInfo, gb);
		
		
		gb.insets = new Insets(5, 1, 5, 5);
		gb.gridx = 5;
		gb.gridwidth = 2;
		gb.gridy = 2;
		gb.gridheight = 2;
		getContentPane().add(rawButton, gb);
		
		gb.insets = new Insets(5, 150, 5, 5);
		gb.gridx = 5;
		gb.gridwidth = 2;
		gb.gridy = 2;
		gb.gridheight = 2;
		getContentPane().add(groupByDateButton, gb);

		gb.anchor = GridBagConstraints.NORTH;
		gb.weighty = 3;
		gb.insets = new Insets(5, 5, 5, 5);
		gb.gridx = 1;
		gb.gridwidth = 3;
		gb.gridy = 3;
		getContentPane().add(clsButton, gb);

		gb.anchor = GridBagConstraints.NORTH;
		gb.weighty = 3;
		gb.insets = new Insets(5, 5, 5, 5);
		gb.gridx = 5;
		gb.gridwidth = 3;
		gb.gridy = 3;
		getContentPane().add(budgetButton, gb);
		
		
		setResizable(true);
	}
}
