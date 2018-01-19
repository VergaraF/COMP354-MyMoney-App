
import java.awt.image.BufferedImage;

/**
 *
 * @author vincent
 */
public class BankPanel extends MainPanel {

    private BufferedImage appIcon;

    public BankPanel() {
        appIcon = chooseIconImage(appIcon, "money.png");
    }

    @Override
    public void setupForPanel() {
        setSize(600, 500);
        setResizable(false);
        setVisible(true);
        setIconImage(appIcon);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
