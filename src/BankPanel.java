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
        Savings = new JLabel("Savings");
        SavingsInfo = new JLabel(u.displaySavings());
        Transactions = new JLabel("Transacations");
        TransactionsInfo = new JLabel(u.displayTransactions());
        clsButton = new JButton("Exit");
        closeOnCancelClick(clsButton);
    }
    
    

    @Override
    public void setupForPanel() {
    	setLayout(new GridBagLayout());
    	placeButtons();
        setSize(600, 500);
        setResizable(false);
        setVisible(true);
        setIconImage(appIcon);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private void placeButtons()
    {
    	GridBagConstraints gb = new GridBagConstraints();

    	gb.insets = new Insets(300, 0, 0, 0);
        gb.gridx = 1;
        gb.gridy = 2;
        add(clsButton, gb);
        
        gb.insets = new Insets(-400, 0, 0, 0);
        gb.gridx = 1;
        gb.gridy = 2;
        add(bankInfo, gb);
        
        gb.insets = new Insets(-300, 0, 0, 300);
        gb.gridx = 1;
        gb.gridy = 2;
        add(Savings, gb);
        
        gb.insets = new Insets(-250, 0, 0, 300);
        gb.gridx = 1;
        gb.gridy = 2;
        add(SavingsInfo, gb);
        
        gb.insets = new Insets(-300, 0, 0, -200);
        gb.gridx = 1;
        gb.gridy = 2;
        add(Transactions, gb);
        
        gb.insets = new Insets(-230, 0, 0, -200);
        gb.gridx = 1;
        gb.gridy = 2;
        add(TransactionsInfo, gb);
    }

}
