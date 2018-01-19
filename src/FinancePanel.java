
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import javax.swing.JButton;

/**
 *
 * @author Vincent
 */
public class FinancePanel extends MainPanel {
    private JButton clsButton;
    private BufferedImage appIcon;

    public FinancePanel() {
        appIcon = chooseIconImage(appIcon, "money.png");
        
        clsButton = new JButton("Cancel");
        closeOnCancelClick(clsButton);
    }

    @Override
    public void setupForPanel() {
        setLayout(new GridBagLayout());
        add(clsButton);

        //Panel settings
        setSize(600, 500);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(appIcon);
    }
}
