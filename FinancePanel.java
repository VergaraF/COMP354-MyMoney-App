
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.knowm.xchart.PieChart;

/**
 *
 * @author Vincent
 */
public class FinancePanel extends MainPanel {

    protected BufferedImage appIcon;
    protected PieChart budgetChart;
    protected PieChart spendingChart;
    protected final String[] spendingList = {"Home", "Food", "Hobbies", "Savings", "Other"};
    protected JComboBox expectedSpending;
    protected JComboBox realSpending;
    protected JPanel bChart;
    protected JPanel sChart;
    protected JTextField text1;
    protected JTextField text2;
    protected JButton makeChart;
    protected JButton addToBudget;
    protected JButton makeChart2;
    protected JButton addToSpendings;
    protected JLabel label;
    protected JLabel budget;
    protected JLabel homeB;
    protected JLabel foodB;
    protected JLabel hobbiesB;
    protected JLabel savingsB;
    protected JLabel otherB;
    protected JLabel spendings;
    protected JLabel homeS;
    protected JLabel foodS;
    protected JLabel hobbiesS;
    protected JLabel savingsS;
    protected JLabel otherS;
    protected JButton resetBudget;
    protected JButton resetSpendings;

    public FinancePanel() {
        //Change the icon to the money png image
        appIcon = chooseIconImage(appIcon, "money.png");
        //Make the dropbox over the charts
        expectedSpending = new JComboBox(spendingList);
        realSpending = new JComboBox(spendingList);
        //Budget chart

        //Spending Chart
        //Setting up the textfields, charts and buttons over the charts
        text1 = new JTextField("", 6);
        text2 = new JTextField("", 6);
        makeChart = new JButton("Create chart");
        addToBudget = new JButton("Add to budget");
        makeChart2 = new JButton("Create chart");
        addToSpendings = new JButton("Add to spendings");
        resetBudget = new JButton("Reset budget");
        resetSpendings = new JButton("Reset spendings");
    }

    @Override
    public void setupForPanel() {
        /*
        Setting up for the FinancePanel
        2 labels are used to represent the total budget and the total spendings
        2 labels are used to represent the budget part of the panel and the
        spending part of the panel
        The user will be able to add data to the chart or create a new chart
         */
        setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();

        label = new JLabel("Expected Spendings");
        gb.insets = new Insets(0, -285, 300, 0);
        gb.gridx = 0;
        gb.gridy = 0;
        add(label, gb);

        label = new JLabel("Total Budget : ");
        gb.insets = new Insets(0, -322, 0, 0);
        gb.gridx = 0;
        gb.gridy = 0;
        add(label, gb);

        budget = new JLabel(String.valueOf(String.format("%.2f", 0.0)));
        gb.insets = new Insets(0, -100, 0, 0);
        gb.gridx = 0;
        gb.gridy = 0;
        add(budget, gb);

        label = new JLabel("Home : ");
        gb.insets = new Insets(0, -360, 250, 0);
        gb.gridx = 0;
        gb.gridy = 0;
        add(label, gb);

        homeB = new JLabel(String.valueOf(String.format("%.2f", 0.0)));
        gb.insets = new Insets(0, -100, 250, 0);
        gb.gridx = 0;
        gb.gridy = 0;
        add(homeB, gb);

        label = new JLabel("Food : ");
        gb.insets = new Insets(0, -365, 200, 0);
        gb.gridx = 0;
        gb.gridy = 0;
        add(label, gb);

        foodB = new JLabel(String.valueOf(String.format("%.2f", 0.0)));
        gb.insets = new Insets(0, -100, 200, 0);
        gb.gridx = 0;
        gb.gridy = 0;
        add(foodB, gb);

        label = new JLabel("Hobbies : ");
        gb.insets = new Insets(0, -345, 150, 0);
        gb.gridx = 0;
        gb.gridy = 0;
        add(label, gb);

        hobbiesB = new JLabel(String.valueOf(String.format("%.2f", 0.0)));
        gb.insets = new Insets(0, -100, 150, 0);
        gb.gridx = 0;
        gb.gridy = 0;
        add(hobbiesB, gb);

        label = new JLabel("Savings : ");
        gb.insets = new Insets(0, -350, 100, 0);
        gb.gridx = 0;
        gb.gridy = 0;
        add(label, gb);

        savingsB = new JLabel(String.valueOf(String.format("%.2f", 0.0)));
        gb.insets = new Insets(0, -100, 100, 0);
        gb.gridx = 0;
        gb.gridy = 0;
        add(savingsB, gb);

        label = new JLabel("Other : ");
        gb.insets = new Insets(0, -360, 50, 0);
        gb.gridx = 0;
        gb.gridy = 0;
        add(label, gb);

        otherB = new JLabel(String.valueOf(String.format("%.2f", 0.0)));
        gb.insets = new Insets(0, -100, 50, 0);
        gb.gridx = 0;
        gb.gridy = 0;
        add(otherB, gb);

        gb.insets = new Insets(0, -322, -80, 0);
        gb.gridx = 0;
        gb.gridy = 0;
        add(expectedSpending, gb);

        gb.insets = new Insets(0, -150, -80, 0);
        gb.gridx = 0;
        gb.gridy = 0;
        add(text1, gb);

        gb.insets = new Insets(0, 50, -80, 0);
        gb.gridx = 0;
        gb.gridy = 0;
        add(addToBudget, gb);

        gb.insets = new Insets(0, 293, -80, 0);
        gb.gridx = 0;
        gb.gridy = 0;
        add(makeChart, gb);
        
        label = new JLabel("Total Spendings : ");
        gb.insets = new Insets(0, -290, 0, 0);
        gb.gridx = 1;
        gb.gridy = 0;
        add(label, gb);

        spendings = new JLabel(String.valueOf(String.format("%.2f", 0.0)));
        gb.insets = new Insets(0, -50, 0, 0);
        gb.gridx = 1;
        gb.gridy = 0;
        add(spendings, gb);

        label = new JLabel("Real Spendings");
        gb.insets = new Insets(0, -305, 300, 0);
        gb.gridx = 1;
        gb.gridy = 0;
        add(label, gb);

        label = new JLabel("Home : ");
        gb.insets = new Insets(0, -350, 250, 0);
        gb.gridx = 1;
        gb.gridy = 0;
        add(label, gb);

        homeS = new JLabel(String.valueOf(String.format("%.2f", 0.0)));
        gb.insets = new Insets(0, -50, 250, 0);
        gb.gridx = 1;
        gb.gridy = 0;
        add(homeS, gb);

        label = new JLabel("Food : ");
        gb.insets = new Insets(0, -355, 200, 0);
        gb.gridx = 1;
        gb.gridy = 0;
        add(label, gb);

        foodS = new JLabel(String.valueOf(String.format("%.2f", 0.0)));
        gb.insets = new Insets(0, -50, 200, 0);
        gb.gridx = 1;
        gb.gridy = 0;
        add(foodS, gb);

        label = new JLabel("Hobbies : ");
        gb.insets = new Insets(0, -338, 150, 0);
        gb.gridx = 1;
        gb.gridy = 0;
        add(label, gb);

        hobbiesS = new JLabel(String.valueOf(String.format("%.2f", 0.0)));
        gb.insets = new Insets(0, -50, 150, 0);
        gb.gridx = 1;
        gb.gridy = 0;
        add(hobbiesS, gb);

        label = new JLabel("Savings : ");
        gb.insets = new Insets(0, -340, 100, 0);
        gb.gridx = 1;
        gb.gridy = 0;
        add(label, gb);

        savingsS = new JLabel(String.valueOf(String.format("%.2f", 0.0)));
        gb.insets = new Insets(0, -50, 100, 0);
        gb.gridx = 1;
        gb.gridy = 0;
        add(savingsS, gb);

        label = new JLabel("Other : ");
        gb.insets = new Insets(0, -350, 50, 0);
        gb.gridx = 1;
        gb.gridy = 0;
        add(label, gb);

        otherS = new JLabel(String.valueOf(String.format("%.2f", 0.0)));
        gb.insets = new Insets(0, -50, 50, 0);
        gb.gridx = 1;
        gb.gridy = 0;
        add(otherS, gb);

        gb.insets = new Insets(0, -315, -80, 0);
        gb.gridx = 1;
        gb.gridy = 0;
        add(realSpending, gb);

        gb.insets = new Insets(0, -150, -80, 0);
        gb.gridx = 1;
        gb.gridy = 0;
        add(text2, gb);

        gb.insets = new Insets(0, 57, -80, 0);
        gb.gridx = 1;
        gb.gridy = 0;
        add(addToSpendings, gb);

        gb.insets = new Insets(0, 303, -80, 0);
        gb.gridx = 1;
        gb.gridy = 0;
        add(makeChart2, gb);
        
        gb.insets = new Insets(0,-295,350,0);
        gb.gridx=0;
        gb.gridy=0;
        add(resetBudget,gb);
        
        gb.insets = new Insets(0,-265,350,0);
        gb.gridx=1;
        gb.gridy=0;
        add(resetSpendings,gb);


        //Panel settings
        setSize(900, 420);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(appIcon);
    }
}
