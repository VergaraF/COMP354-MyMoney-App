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
public class BankPanel extends MainPanel 
{
	private JButton exitButton;
	private JButton budgetButton;
	private JButton rawButton;
	private JButton groupByDateButton;
	private JButton detailsInfo;

	private BufferedImage appIcon;
	private final JLabel bankInfoTitle;
	private final JLabel savingsSubtitle;
	private final JTextPane savingsContent;
	private final JLabel transactionsSubtitle;
	private final JLabel adviceSubtitle;
	private final JTextPane adviceContent;
	private final JTextPane transactionsContent;
	
	TransactionsController transactionController = new TransactionsController();

	public BankPanel() 
	{
		getContentPane().setLayout(null);
		
		System.out.println("Generating data files");
		
		transactionController.addTransactions(".//datafiles//transactions_data");
		transactionController.exportTransactionsToFiles();
		
		appIcon = chooseIconImage(appIcon, "money.png");
		
		bankInfoTitle = new JLabel("Banking Information");
		
		Advice finan_Advice = new Advice();
		finan_Advice.execute();
		adviceSubtitle = new JLabel("Advice");
		adviceContent = new JTextPane();
		adviceContent.setText(finan_Advice.Advice);
		adviceContent.setEditable(false);
		
		savingsSubtitle = new JLabel("Savings");
		savingsContent = new JTextPane();
		savingsContent.setText(Model.displaySavings());
		savingsContent.setEditable(false);
		
		transactionsSubtitle = new JLabel("Transactions");
		transactionsContent = new JTextPane();
		transactionsContent.setText(transactionController.getRawStringTransactions());
		transactionsContent.setEditable(false);
		
		exitButton = new JButton("Exit");
		budgetButton = new JButton("Budget");
		rawButton = new JButton("Raw");
		groupByDateButton = new JButton("Date");
		detailsInfo = new JButton("Details");
		
		showRawTransaction(rawButton);
		showTransactionsGroupedByDate(groupByDateButton);
		closeOnCancelClick(exitButton);
		goToBudget(budgetButton);
	}

	public final void showRawTransaction(JButton btn) 
	{
		btn.addActionListener((ActionEvent e) -> 
		{
			this.transactionsContent.setText(transactionController.getRawStringTransactions());
		});
	}
	
	public final void showTransactionsGroupedByDate(JButton btn) 
	{
		btn.addActionListener((ActionEvent e) -> 
		{
			this.transactionsContent.setText(transactionController.getTransactionStringGroupedByDate());
		});
	}
	
	public final void goToBudget(JButton btn) 
	{
		btn.addActionListener((ActionEvent e) -> 
		{
			FinanceController.setup();
		});
	}

	@Override
	public void setupForPanel() 
	{
		setMinimumSize(new Dimension(960, 720));
		setVisible(true);
		placeButtons();

		setIconImage(appIcon);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		bankInfoTitle.setFont(new Font("SansSerif", Font.PLAIN, 28));
		transactionsSubtitle.setFont(new Font("SansSerif", Font.PLAIN, 20));
		savingsSubtitle.setFont(new Font("SansSerif", Font.PLAIN, 20));
		adviceSubtitle.setFont(new Font("SansSerif", Font.PLAIN, 20));
	}
	
	private final int verticalPadding = 5;
    private final int horizontalPadding = 10;
	
	private void placeButtons() 
	{
		//GridBagLayout setup
        setLayout(new GridBagLayout());
        GridBagConstraints bankPaneLayout = new GridBagConstraints();
        bankPaneLayout.weightx = 1.0f;
        bankPaneLayout.weighty = 1.0f;
        
      //Bank info Title
        bankPaneLayout.fill = GridBagConstraints.CENTER;
        bankPaneLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        bankPaneLayout.gridwidth = 6;
        bankPaneLayout.weighty = 0;
        bankPaneLayout.gridx = 0;
        bankPaneLayout.gridy = 0;
        add(bankInfoTitle, bankPaneLayout);
        
      //Advice subtitle
        bankPaneLayout.fill = GridBagConstraints.CENTER;
        bankPaneLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        bankPaneLayout.gridwidth = 2;
        bankPaneLayout.weighty = 0;
        bankPaneLayout.gridx = 0;
        bankPaneLayout.gridy = 1;
        add(adviceSubtitle, bankPaneLayout);
        
      //Savings subtitle
        bankPaneLayout.fill = GridBagConstraints.CENTER;
        bankPaneLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        bankPaneLayout.gridwidth = 2;
        bankPaneLayout.weighty = 0;
        bankPaneLayout.gridx = 2;
        bankPaneLayout.gridy = 1;
        add(savingsSubtitle, bankPaneLayout);
        
      //Transaction subtitle
        bankPaneLayout.fill = GridBagConstraints.CENTER;
        bankPaneLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        bankPaneLayout.gridwidth = 2;
        bankPaneLayout.weighty = 0;
        bankPaneLayout.gridx = 4;
        bankPaneLayout.gridy = 1;
        add(transactionsSubtitle, bankPaneLayout);
        
      //Transactions button 1
        bankPaneLayout.fill = GridBagConstraints.CENTER;
        bankPaneLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        bankPaneLayout.gridwidth = 1;
        bankPaneLayout.weighty = 0;
        bankPaneLayout.gridx = 4;
        bankPaneLayout.gridy = 2;
        add(rawButton, bankPaneLayout);
        
      //Transactions button 2
        bankPaneLayout.fill = GridBagConstraints.CENTER;
        bankPaneLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        bankPaneLayout.gridwidth = 1;
        bankPaneLayout.weighty = 0;
        bankPaneLayout.gridx = 5;
        bankPaneLayout.gridy = 2;
        add(groupByDateButton, bankPaneLayout);
        
      //Advice content
        bankPaneLayout.fill = GridBagConstraints.BOTH;
        bankPaneLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        bankPaneLayout.gridwidth = 2;
        bankPaneLayout.weighty = 1;
        bankPaneLayout.gridx = 0;
        bankPaneLayout.gridy = 3;
        add(adviceContent, bankPaneLayout);
        
      //savings content
        bankPaneLayout.fill = GridBagConstraints.BOTH;
        bankPaneLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        bankPaneLayout.gridwidth = 2;
        bankPaneLayout.weighty = 1;
        bankPaneLayout.gridx = 2;
        bankPaneLayout.gridy = 3;
        add(savingsContent, bankPaneLayout);
        
      //transactions content
        bankPaneLayout.fill = GridBagConstraints.BOTH;
        bankPaneLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        bankPaneLayout.gridwidth = 2;
        bankPaneLayout.weighty = 1;
        bankPaneLayout.gridx = 4;
        bankPaneLayout.gridy = 3;
        add(transactionsContent, bankPaneLayout);
        
      //exit button
        bankPaneLayout.fill = GridBagConstraints.CENTER;
        bankPaneLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        bankPaneLayout.gridwidth = 1;
        bankPaneLayout.weighty = 0;
        bankPaneLayout.gridx = 1;
        bankPaneLayout.gridy = 4;
        add(exitButton, bankPaneLayout);
        
      //Budget button
        bankPaneLayout.fill = GridBagConstraints.CENTER;
        bankPaneLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        bankPaneLayout.gridwidth = 1;
        bankPaneLayout.weighty = 0;
        bankPaneLayout.gridx = 4;
        bankPaneLayout.gridy = 4;
        add(budgetButton, bankPaneLayout);
		
		setResizable(true);
	}
}
