
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Vincent
 */
public class Panel extends JFrame {

    private final JTextField userArea;
    private final JPasswordField passwordArea;
    private final JButton logBtn;
    private final JButton cancelBtn;
    private final JLabel user;
    private final JLabel pass;
    private BufferedImage appIcon;

    public Panel() {
        super("Budgeting App");
        
        //Buttons, text fields and icon settings
        appIcon = setIconImage(appIcon,"money.png");
        
        logBtn = new JButton("Log in");
        logInOnClick();

        cancelBtn = new JButton("Cancel");
        closeOnCancelClick();

        user = new JLabel("Username");
        userArea = new JTextField("", 15);

        pass = new JLabel("Password");
        passwordArea = new JPasswordField("", 15);

        //Layout settings
        setLayout(new GridBagLayout());
        placeButtons();
        
        //Panel settings
        setSize(300, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(appIcon);
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

    private void closeOnCancelClick() {
        cancelBtn.addActionListener((ActionEvent e) -> {
            dispose();
        });
    }
    private BufferedImage setIconImage(BufferedImage icon, String path){
        try{
        icon = ImageIO.read(getClass().getClassLoader().getResource(path));
        }catch(IOException e){
            e.printStackTrace();
        }
        return icon;
    }
    private void logInOnClick() {
        /*
        TO DO
        */
    }
}
