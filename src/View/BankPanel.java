package View;
import java.awt.Dimension;
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
import javax.swing.JScrollPane;

import Controller.*;
import Model.Model;

/**
 *
 * @author vincent
 */
public class BankPanel extends MainPanel {
	private JButton clsButton;
	private JButton budgetButton;
	private JButton rawButton;
	private JButton groupByDateButton;
	private JButton detailsInfo;


	private BufferedImage appIcon;
	private final JLabel bankInfo;
	private final JLabel Savings;
	private final JLabel SavingsInfo;
	private final JLabel Transactions;
	private final JLabel TransactionsInfo;
	
	TransactionsController transactionController = new TransactionsController();

	public BankPanel() {
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
		TransactionsInfo.setMaximumSize(new Dimension(350,700));
		TransactionsInfo.setPreferredSize(new Dimension(350,700));
		
		clsButton = new JButton("Exit");
		budgetButton = new JButton("Budget");
		rawButton = new JButton("Raw");
		groupByDateButton = new JButton("Date");
		detailsInfo = new JButton("Details");
		
		showRawTransacation(rawButton);
		showTransacationsGroupedByDate(groupByDateButton);
		closeOnCancelClick(clsButton);
		goToBudget(budgetButton);
	//	goToDetailInfo(detailsInfo);

	}

/*	public final void goToDetailInfo(JButton btn) {
		btn.addActionListener((ActionEvent e) -> {
			FinanceController.setup();
		});
	}*/
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

	//	JScrollPane scroller = new JScrollPane(Transactions, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

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

		gb.insets = new Insets(55, 5, 5, 5);
		gb.gridx = 3;
		gb.gridwidth = 5;
		gb.gridy = 2;
		gb.gridheight = 2;
		add(TransactionsInfo, gb);
		
		gb.insets = new Insets(5, 1, 5, 5);
		gb.gridx = 3;
		gb.gridwidth = 2;
		gb.gridy = 2;
		gb.gridheight = 2;
		add(rawButton, gb);
		
		gb.insets = new Insets(5, 150, 5, 5);
		gb.gridx = 3;
		gb.gridwidth = 2;
		gb.gridy = 2;
		gb.gridheight = 2;
		add(groupByDateButton, gb);

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
