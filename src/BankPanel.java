import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author vincent
 */
public class BankPanel extends MainPanel {
	private JButton clsButton;
    private BufferedImage appIcon;
    private final JLabel bankInfo;
    private final JLabel Savings;
    private final JLabel SavingsInfo;
    private final JLabel Transactions;
    private final JLabel TransactionsInfo;
    
    User u = new User();

    public BankPanel() {
        appIcon = chooseIconImage(appIcon, "money.png");
        bankInfo = new JLabel("Banking Information");
        Savings = new JLabel("<HTML><U>Savings</U></HTML>");
        SavingsInfo = new JLabel(u.displaySavings());
        Transactions = new JLabel("<HTML><U>Transactions</U></HTML>");
        TransactionsInfo = new JLabel(u.displayTransactions());
        clsButton = new JButton("Exit");
        closeOnCancelClick(clsButton);
    }
    
    

    @Override
    public void setupForPanel() {
    	
        setSize(600, 500);
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
    
    private void placeButtons()
    {
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
        gb.gridheight= 2;
        add(TransactionsInfo, gb);
        
        gb.anchor = GridBagConstraints.NORTH;
        gb.weighty = 3; 
        gb.insets = new Insets(5, 5, 5, 5);
        gb.gridx = 2;
        gb.gridwidth = 3;
        gb.gridy = 3;
        add(clsButton, gb);
    }

}
