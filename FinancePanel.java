
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JTextArea;

/**
 *
 * @author Vincent
 */
public class FinancePanel extends MainPanel {
    private JButton clsButton;
    private BufferedImage appIcon;
    private JTextArea textArea;

    public FinancePanel() {
        appIcon = chooseIconImage(appIcon, "money.png");
        
        clsButton = new JButton("Cancel");
        closeOnCancelClick(clsButton);
         textArea = new JTextArea(MyMoneyController.getFinanceStatement());
        
    }

    @Override
    public void setupForPanel() {
        setLayout(new GridBagLayout());
        //add(clsButton);
        add(textArea);

        //Panel settings
        setSize(600, 500);
        setResizable(true);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(appIcon);
    }
}
