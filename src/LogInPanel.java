
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Vincent
 */
public class LogInPanel extends JFrame {

    private final JTextField userArea;
    private final JPasswordField passwordArea;
    private final JButton logBtn;
    private final JButton cancelBtn;
    private final JLabel user;
    private final JLabel pass;
    private final JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItem;
    private BufferedImage appIcon;

    public LogInPanel() {
        super("MyMoney");

        //Menu bar settings
        menuBar = new JMenuBar();
        placeMenu(menuBar, menu, menuItem);

        //Buttons, text fields and icon settings
        appIcon = chooseIconImage(appIcon, "money.png");

        logBtn = new JButton("Log in");
        logInOnClick();

        cancelBtn = new JButton("Cancel");
        closeOnCancelClick();

        user = new JLabel("Username");
        userArea = new JTextField("", 15);

        pass = new JLabel("Password");
        passwordArea = new JPasswordField("", 15);
    }

    public void setupForPanel() {
        //Layout settings
        setLayout(new GridBagLayout());
        placeButtons();

        //Panel settings
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(appIcon);
        setJMenuBar(menuBar);
        setResizable(false);
        setVisible(true);
    }

    private void placeButtons() {
        GridBagConstraints gb = new GridBagConstraints();

        gb.gridx = 0;
        gb.gridy = 0;
        add(user, gb);

        gb.gridx = 1;
        gb.gridy = 0;
        add(userArea, gb);

        gb.gridx = 0;
        gb.gridy = 1;
        add(pass, gb);

        gb.gridx = 1;
        gb.gridy = 1;
        add(passwordArea, gb);

        gb.insets = new Insets(10, 0, 0, 0);
        gb.gridx = 0;
        gb.gridy = 2;
        add(logBtn, gb);

        gb.insets = new Insets(10, 0, 0, -95);
        gb.gridx = 1;
        gb.gridy = 2;
        add(cancelBtn, gb);
    }

    private void placeMenu(JMenuBar menuBar, JMenu menu, JMenuItem menuItem) {
        menu = new JMenu("Registration");
        menuBar.add(menu);
        menuItem = new JMenuItem("Account registration", KeyEvent.VK_A);
        menu.add(menuItem);

        menu = new JMenu("Help");
        menuBar.add(menu);
        menuItem = new JMenuItem("Documentation", KeyEvent.VK_D);
        menu.add(menuItem);

        menu = new JMenu("About");
        menuBar.add(menu);
        menuItem = new JMenuItem("MyMoney", KeyEvent.VK_M);
        menu.add(menuItem);
    }

    public final void closeOnCancelClick() {
        cancelBtn.addActionListener((ActionEvent e) -> {
            dispose();
        });
    }

    public final BufferedImage chooseIconImage(BufferedImage icon, String path) {
        try {
            icon = ImageIO.read(getClass().getClassLoader().getResource(path));
        } catch (IOException e) {
            e.getMessage();
        }
        return icon;
    }

    private void logInOnClick() {
        logBtn.addActionListener((ActionEvent e) -> {
            FinancePanel panel = new FinancePanel();
            panel.setupForPanel();
            dispose();
        });
    }
}
