
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

/**
 *
 * @author Vincent
 */
public class FinancePanel extends LogInPanel {

    private BufferedImage appIcon;

    public FinancePanel() {
        appIcon = chooseIconImage(appIcon, "money.png");
    }

    @Override
    public void setupForPanel() {
        setSize(600, 500);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(appIcon);
    }
}
