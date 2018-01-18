import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author Vincent
 */
public class Panel extends JFrame {

    private JTextField userArea;
    private JTextField passwordArea;
    private JButton btn;

    public Panel() {
        super("Comp 354 App");
        setLayout(new GridBagLayout());
        userArea = new JTextField("Username", 15);
        passwordArea = new JTextField("Password", 15);
        btn = new JButton("Log in");

        GridBagConstraints gb = new GridBagConstraints();

        gb.gridx = 0;
        gb.gridy = 0;
        gb.weightx = 1;
        gb.weighty = 1;
        gb.fill = GridBagConstraints.NONE;
        gb.anchor = GridBagConstraints.LINE_END;
        add(userArea, gb);

        gb.gridx = 1;
        gb.gridy = 0;
        gb.anchor = GridBagConstraints.LINE_START;
        add(passwordArea, gb);
        
        gb.gridx = 2;
        gb.gridy = 0;
        add(btn,gb);
        
        setSize(600, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        getContentPane().setBackground(Color.yellow);
    }
}
