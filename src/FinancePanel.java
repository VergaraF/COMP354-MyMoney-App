
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
    //protected JTextField text2;
    protected JButton makeChart;
    protected JButton addToBudget;
    protected JButton makeChart2;
    //protected JButton addToSpendings;
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
    //protected JButton resetSpendings;

    /**
     * Default constructor for FinancePanel class
     *
     * Assigning default values to the buttons, text fields, the drop boxes and
     * the icon of the JFrame.
     */
    public FinancePanel() {
        //Change the icon to the money png image
        appIcon = chooseIconImage(appIcon, "money.png");

        //Make the dropbox over the charts
        expectedSpending = new JComboBox(spendingList);
        realSpending = new JComboBox(spendingList);

        //Setting up the textfields
        text1 = new JTextField("", 6);
        //text2 = new JTextField("", 6);

        //Setting up the add and create chart buttons on the budget side
        makeChart = new JButton("Create chart");
        addToBudget = new JButton("Add to budget");

        //Setting up the add and create chart buttons on the spending side
        makeChart2 = new JButton("Create chart");
        //addToSpendings = new JButton("Add to spendings");

        //Setting up the reset budget button
        resetBudget = new JButton("Reset budget");

        //Setting up the reset spending button
        //resetSpendings = new JButton("Reset spendings");
    }

    /**
     * OVERRIDING THE MAINPANEL setupForPanel METHOD
     *
     * The FinancePanel class use the GridBagLayout to distribute the components
     * on the JFrame.
     *
     * 6 labels are used on the budget side to show the amounts dedicated to the
     * home,the food,the hobbies,the savings and for other budgeting. The 6th
     * label is for the total budget amount.
     *
     * 6 labels are used on the spending side to show the amounts dedicated to
     * the home, the food,the hobbies, the savings and for other spending. The
     * 6th label is for the total spending amount.
     *
     * There is 2 reset buttons. There is one to reset the budget amount in each
     * label and one to reset the spending amount in each label.
     *
     * There is a drop box on each side(budget or spending) to choose which
     * category you want to add an amount in.
     *
     * There is 2 add buttons to add an amount either to the spending side or
     * the budget side.
     *
     * There is 2 buttons to make a pie chart either from the budget side or the
     * spending side.
     *
     * There is 2 text fields to enter an amount on the budget side or on the
     * spending side.
     */
    @Override
    public void setupForPanel() {
        //GridBagLayout setup
        setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();

        //Expected spendings label under the reset budget button
        label = new JLabel("Expected Spendings");
        gb.insets = new Insets(0, -285, 300, 0);
        gb.gridx = 0;
        gb.gridy = 0;
        add(label, gb);

        //Total budget label
        label = new JLabel("Total Budget : ");
        gb.insets = new Insets(0, -322, 0, 0);
        gb.gridx = 0;
        gb.gridy = 0;
        add(label, gb);

        //Total budget amount
        budget = new JLabel(String.valueOf(String.format("%.2f", 0.0)));
        gb.insets = new Insets(0, -100, 0, 0);
        gb.gridx = 0;
        gb.gridy = 0;
        add(budget, gb);

        //Home label on budget side
        label = new JLabel("Home : ");
        gb.insets = new Insets(0, -360, 250, 0);
        gb.gridx = 0;
        gb.gridy = 0;
        add(label, gb);

        //Home amount on budget side
        homeB = new JLabel(String.valueOf(String.format("%.2f", 0.0)));
        gb.insets = new Insets(0, -100, 250, 0);
        gb.gridx = 0;
        gb.gridy = 0;
        add(homeB, gb);

        //Food label on budget side
        label = new JLabel("Food : ");
        gb.insets = new Insets(0, -365, 200, 0);
        gb.gridx = 0;
        gb.gridy = 0;
        add(label, gb);

        //Food amount on budget side
        foodB = new JLabel(String.valueOf(String.format("%.2f", 0.0)));
        gb.insets = new Insets(0, -100, 200, 0);
        gb.gridx = 0;
        gb.gridy = 0;
        add(foodB, gb);

        //Hobbies label on budget side
        label = new JLabel("Hobbies : ");
        gb.insets = new Insets(0, -345, 150, 0);
        gb.gridx = 0;
        gb.gridy = 0;
        add(label, gb);

        //Hobbies amount on budget side
        hobbiesB = new JLabel(String.valueOf(String.format("%.2f", 0.0)));
        gb.insets = new Insets(0, -100, 150, 0);
        gb.gridx = 0;
        gb.gridy = 0;
        add(hobbiesB, gb);

        //Savings label on budget side
        label = new JLabel("Savings : ");
        gb.insets = new Insets(0, -350, 100, 0);
        gb.gridx = 0;
        gb.gridy = 0;
        add(label, gb);

        //Savings amount on budget side
        savingsB = new JLabel(String.valueOf(String.format("%.2f", 0.0)));
        gb.insets = new Insets(0, -100, 100, 0);
        gb.gridx = 0;
        gb.gridy = 0;
        add(savingsB, gb);

        //Other label on budget side
        label = new JLabel("Other : ");
        gb.insets = new Insets(0, -360, 50, 0);
        gb.gridx = 0;
        gb.gridy = 0;
        add(label, gb);

        //Other amout on budget side
        otherB = new JLabel(String.valueOf(String.format("%.2f", 0.0)));
        gb.insets = new Insets(0, -100, 50, 0);
        gb.gridx = 0;
        gb.gridy = 0;
        add(otherB, gb);

        //Drop box on the budget side
        gb.insets = new Insets(0, -322, -80, 0);
        gb.gridx = 0;
        gb.gridy = 0;
        add(expectedSpending, gb);

        //Textfield on the budget side
        gb.insets = new Insets(0, -150, -80, 0);
        gb.gridx = 0;
        gb.gridy = 0;
        add(text1, gb);

        //Add to budget button
        gb.insets = new Insets(0, 50, -80, 0);
        gb.gridx = 0;
        gb.gridy = 0;
        add(addToBudget, gb);

        //Create a chart button on the budget side
        gb.insets = new Insets(0, 293, -80, 0);
        gb.gridx = 0;
        gb.gridy = 0;
        add(makeChart, gb);

        //Total spending label
        label = new JLabel("Total Spendings : ");
        gb.insets = new Insets(0, -290, 0, 0);
        gb.gridx = 1;
        gb.gridy = 0;
        add(label, gb);

        //Total spending amount
        spendings = new JLabel(String.valueOf(String.format("%.2f", 0.0)));
        gb.insets = new Insets(0, -50, 0, 0);
        gb.gridx = 1;
        gb.gridy = 0;
        add(spendings, gb);

        //Real spendings label under the reset spendings button
        label = new JLabel("Real Spendings");
        gb.insets = new Insets(0, -305, 300, 0);
        gb.gridx = 1;
        gb.gridy = 0;
        add(label, gb);

        //Home label on spending side
        label = new JLabel("Home : ");
        gb.insets = new Insets(0, -350, 250, 0);
        gb.gridx = 1;
        gb.gridy = 0;
        add(label, gb);

        //Home amount on spending side
        homeS = new JLabel(String.valueOf(String.format("%.2f", 0.0)));
        gb.insets = new Insets(0, -50, 250, 0);
        gb.gridx = 1;
        gb.gridy = 0;
        add(homeS, gb);

        //Food label on spending side
        label = new JLabel("Food : ");
        gb.insets = new Insets(0, -355, 200, 0);
        gb.gridx = 1;
        gb.gridy = 0;
        add(label, gb);

        //Food amount on spending side
        foodS = new JLabel(String.valueOf(String.format("%.2f", 0.0)));
        gb.insets = new Insets(0, -50, 200, 0);
        gb.gridx = 1;
        gb.gridy = 0;
        add(foodS, gb);

        //Hobbies label on spending side
        label = new JLabel("Hobbies : ");
        gb.insets = new Insets(0, -338, 150, 0);
        gb.gridx = 1;
        gb.gridy = 0;
        add(label, gb);

        //Hobbies amount on spending side
        hobbiesS = new JLabel(String.valueOf(String.format("%.2f", 0.0)));
        gb.insets = new Insets(0, -50, 150, 0);
        gb.gridx = 1;
        gb.gridy = 0;
        add(hobbiesS, gb);

        //Savings label on spending side
        label = new JLabel("Savings : ");
        gb.insets = new Insets(0, -340, 100, 0);
        gb.gridx = 1;
        gb.gridy = 0;
        add(label, gb);

        //Savings amount on spending side
        savingsS = new JLabel(String.valueOf(String.format("%.2f", 0.0)));
        gb.insets = new Insets(0, -50, 100, 0);
        gb.gridx = 1;
        gb.gridy = 0;
        add(savingsS, gb);

        //Other label on spending side
        label = new JLabel("Other : ");
        gb.insets = new Insets(0, -350, 50, 0);
        gb.gridx = 1;
        gb.gridy = 0;
        add(label, gb);

        //Other amout on spending side
        otherS = new JLabel(String.valueOf(String.format("%.2f", 0.0)));
        gb.insets = new Insets(0, -50, 50, 0);
        gb.gridx = 1;
        gb.gridy = 0;
        add(otherS, gb);

        /*
        
        //Drop box on spending side
        gb.insets = new Insets(0, -315, -80, 0);
        gb.gridx = 1;
        gb.gridy = 0;
        add(realSpending, gb);

        //Textfield on the spending side
        gb.insets = new Insets(0, -150, -80, 0);
        gb.gridx = 1;
        gb.gridy = 0;
        add(text2, gb);

        //Add to spending button
        gb.insets = new Insets(0, 57, -80, 0);
        gb.gridx = 1;
        gb.gridy = 0;
        add(addToSpendings, gb);

		//Reset spending button
        gb.insets = new Insets(0, -265, 350, 0);
        gb.gridx = 1;
        gb.gridy = 0;
        add(resetSpendings, gb);

         */

        //Make chart button on spending side
        gb.insets = new Insets(0, 303, -80, 0);
        gb.gridx = 1;
        gb.gridy = 0;
        add(makeChart2, gb);

        //Reset budget button
        gb.insets = new Insets(0, -295, 350, 0);
        gb.gridx = 0;
        gb.gridy = 0;
        add(resetBudget, gb);

        //JFrame settings
        setSize(900, 420);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(appIcon);
    }
}
