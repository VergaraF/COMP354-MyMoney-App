package View;

import java.awt.Dimension;
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

	public BufferedImage appIcon;
    public PieChart budgetChart;
    public PieChart spendingChart;
    public final String[] spendingList = {"Home", "Food", "Hobbies", "Health", "Transport", "Entertainment", "Debt", "Car", "Other"};
    public JPanel bChart;
    public JPanel sChart;
    public JTextField text1;
    public JTextField text2;
    
    public JLabel label;
    
    public JButton resetBudget;
    public JLabel homeB;
    public JLabel foodB;
    public JLabel hobbiesB;
    public JLabel healthB;
    public JLabel entertainmentB;
    public JLabel debtB;
    public JLabel carB;
    public JLabel transportB;
    public JLabel otherB;
    public JLabel budget;
    public JComboBox expectedSpending;
    public JButton makeChart;
    public JButton addToBudget;
    
    public JLabel homeS;
    public JLabel foodS;
    public JLabel hobbiesS;
    public JLabel otherS;
    public JLabel healthS;
    public JLabel transportS;
    public JLabel entertainmentS;
    public JLabel debtS;
    public JLabel carS;
    public JLabel spendings;
    public JButton makeChart2;
    
    private final int verticalPadding = 5;
    private final int horizontalPadding = 10;
   
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

        //Setting up the textfields
        text1 = new JTextField("", 6);
        text2 = new JTextField("", 6);

        //Setting up the add and create chart buttons on the budget side
        makeChart = new JButton("Create chart");
        addToBudget = new JButton("Add to budget");

        //Setting up the add and create chart buttons on the spending side
        makeChart2 = new JButton("Create chart");

        //Setting up the reset budget button
        resetBudget = new JButton("Reset budget");
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
    public void setupForPanel() 
    {
        //GridBagLayout setup
        setLayout(new GridBagLayout());
        GridBagConstraints budgetLayout = new GridBagConstraints();
        
        //Reset budget button
        budgetLayout.fill = GridBagConstraints.HORIZONTAL;
        budgetLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        budgetLayout.gridwidth = 1;
        budgetLayout.gridx = 0;
        budgetLayout.gridy = 0;
        add(resetBudget, budgetLayout);
        
        //Expected spendings label under the reset budget button
        label = new JLabel("Expected Spendings");
        budgetLayout.fill = GridBagConstraints.HORIZONTAL;
        budgetLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        budgetLayout.gridwidth = 4;
        budgetLayout.gridx = 0;
        budgetLayout.gridy = 1;
        add(label, budgetLayout);

        //Home label on budget side
        label = new JLabel("Home : ");
        budgetLayout.fill = GridBagConstraints.HORIZONTAL;
        budgetLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        budgetLayout.gridwidth = 1;
        budgetLayout.gridx = 0;
        budgetLayout.gridy = 2;
        add(label, budgetLayout);

        //Home amount on budget side
        homeB = new JLabel(String.valueOf(String.format("%.2f", 0.0)));
        budgetLayout.fill = GridBagConstraints.HORIZONTAL;
        budgetLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        budgetLayout.gridwidth = 1;
        budgetLayout.gridx = 1;
        budgetLayout.gridy = 2;
        add(homeB, budgetLayout);

        //Food label on budget side
        label = new JLabel("Food : ");
        budgetLayout.fill = GridBagConstraints.HORIZONTAL;
        budgetLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        budgetLayout.gridwidth = 1;
        budgetLayout.gridx = 0;
        budgetLayout.gridy = 3;
        add(label, budgetLayout);

        //Food amount on budget side
        foodB = new JLabel(String.valueOf(String.format("%.2f", 0.0)));
        budgetLayout.fill = GridBagConstraints.HORIZONTAL;
        budgetLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        budgetLayout.gridwidth = 1;
        budgetLayout.gridx = 1;
        budgetLayout.gridy = 3;
        add(foodB, budgetLayout);

        //Hobbies label on budget side
        label = new JLabel("Hobbies : ");
        budgetLayout.fill = GridBagConstraints.HORIZONTAL;
        budgetLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        budgetLayout.gridwidth = 1;
        budgetLayout.gridx = 0;
        budgetLayout.gridy = 4;
        add(label, budgetLayout);

        //Hobbies amount on budget side
        hobbiesB = new JLabel(String.valueOf(String.format("%.2f", 0.0)));
        budgetLayout.fill = GridBagConstraints.HORIZONTAL;
        budgetLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        budgetLayout.gridwidth = 1;
        budgetLayout.gridx = 1;
        budgetLayout.gridy = 4;
        add(hobbiesB, budgetLayout);

        //Health label on spending side
        label = new JLabel("Health : ");
        budgetLayout.fill = GridBagConstraints.HORIZONTAL;
        budgetLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        budgetLayout.gridwidth = 1;
        budgetLayout.gridx = 0;
        budgetLayout.gridy = 5;
        add(label, budgetLayout);

        //Health amount on spending side
        healthB = new JLabel(String.valueOf(String.format("%.2f", 0.0)));
        budgetLayout.fill = GridBagConstraints.HORIZONTAL;
        budgetLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        budgetLayout.gridwidth = 1;
        budgetLayout.gridx = 1;
        budgetLayout.gridy = 5;
        add(healthB, budgetLayout);
        
        //Transport label on spending side
        label = new JLabel("Transport : ");
        budgetLayout.fill = GridBagConstraints.HORIZONTAL;
        budgetLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        budgetLayout.gridwidth = 1;
        budgetLayout.gridx = 0;
        budgetLayout.gridy = 6;
        add(label, budgetLayout);

        //Transport amount on spending side
        transportB = new JLabel(String.valueOf(String.format("%.2f", 0.0)));
        budgetLayout.fill = GridBagConstraints.HORIZONTAL;
        budgetLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        budgetLayout.gridwidth = 1;
        budgetLayout.gridx = 1;
        budgetLayout.gridy = 6;
        add(transportB, budgetLayout);
        
        //Entertainment label on spending side
        label = new JLabel("Entertainment : ");
        budgetLayout.fill = GridBagConstraints.HORIZONTAL;
        budgetLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        budgetLayout.gridwidth = 1;
        budgetLayout.gridx = 0;
        budgetLayout.gridy = 7;
        add(label, budgetLayout);

        //Entertainment amount on spending side
        entertainmentB = new JLabel(String.valueOf(String.format("%.2f", 0.0)));
        budgetLayout.fill = GridBagConstraints.HORIZONTAL;
        budgetLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        budgetLayout.gridwidth = 1;
        budgetLayout.gridx = 1;
        budgetLayout.gridy = 7;
        add(entertainmentB, budgetLayout);
        
        //Debt label on spending side
        label = new JLabel("Debt : ");
        budgetLayout.fill = GridBagConstraints.HORIZONTAL;
        budgetLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        budgetLayout.gridwidth = 1;
        budgetLayout.gridx = 0;
        budgetLayout.gridy = 8;
        add(label, budgetLayout);

        //Debt amount on spending side
        debtB = new JLabel(String.valueOf(String.format("%.2f", 0.0)));
        budgetLayout.fill = GridBagConstraints.HORIZONTAL;
        budgetLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        budgetLayout.gridwidth = 1;
        budgetLayout.gridx = 1;
        budgetLayout.gridy = 8;
        add(debtB, budgetLayout);
        
        //Car label on spending side
        label = new JLabel("Car : ");
        budgetLayout.fill = GridBagConstraints.HORIZONTAL;
        budgetLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        budgetLayout.gridwidth = 1;
        budgetLayout.gridx = 0;
        budgetLayout.gridy = 9;
        add(label, budgetLayout);

        //Car amount on spending side
        carB = new JLabel(String.valueOf(String.format("%.2f", 0.0)));
        budgetLayout.fill = GridBagConstraints.HORIZONTAL;
        budgetLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        budgetLayout.gridwidth = 1;
        budgetLayout.gridx = 1;
        budgetLayout.gridy = 9;
        add(carB, budgetLayout);
        
        //Other label on spending side
        label = new JLabel("Other : ");
        budgetLayout.fill = GridBagConstraints.HORIZONTAL;
        budgetLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        budgetLayout.gridwidth = 1;
        budgetLayout.gridx = 0;
        budgetLayout.gridy = 10;
        add(label, budgetLayout);

        //Other amount on spending side
        otherB = new JLabel(String.valueOf(String.format("%.2f", 0.0)));
        budgetLayout.fill = GridBagConstraints.HORIZONTAL;
        budgetLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        budgetLayout.gridwidth = 1;
        budgetLayout.gridx = 1;
        budgetLayout.gridy = 10;
        add(otherB, budgetLayout);
        
        //Total spending label
        label = new JLabel("Total Budget : ");
        budgetLayout.fill = GridBagConstraints.HORIZONTAL;
        budgetLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        budgetLayout.gridwidth = 1;
        budgetLayout.gridx = 0;
        budgetLayout.gridy = 11;
        add(label, budgetLayout);

        //Total spending amount
        budget = new JLabel(String.valueOf(String.format("%.2f", 0.0)));
        budgetLayout.fill = GridBagConstraints.HORIZONTAL;
        budgetLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        budgetLayout.gridwidth = 1;
        budgetLayout.gridx = 1;
        budgetLayout.gridy = 11;
        add(budget, budgetLayout);
        
        //Drop box on the budget side
        budgetLayout.fill = GridBagConstraints.HORIZONTAL;
        budgetLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        budgetLayout.gridwidth = 1;
        budgetLayout.gridx = 0;
        budgetLayout.gridy = 12;
        add(expectedSpending, budgetLayout);

        //Textfield on the budget side
        budgetLayout.fill = GridBagConstraints.HORIZONTAL;
        budgetLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        budgetLayout.gridwidth = 1;
        budgetLayout.gridx = 1;
        budgetLayout.gridy = 12;
        add(text1, budgetLayout);

        //Add to budget button
        budgetLayout.fill = GridBagConstraints.HORIZONTAL;
        budgetLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        budgetLayout.gridwidth = 1;
        budgetLayout.gridx = 2;
        budgetLayout.gridy = 12;
        add(addToBudget, budgetLayout);

        //Create a chart button on the budget side
        budgetLayout.fill = GridBagConstraints.HORIZONTAL;
        budgetLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        budgetLayout.gridwidth = 1;
        budgetLayout.gridx = 3;
        budgetLayout.gridy = 12;
        add(makeChart, budgetLayout);

        //
        
        //Real spendings label under the reset spendings button
        label = new JLabel("Real Spendings");
        budgetLayout.fill = GridBagConstraints.HORIZONTAL;
        budgetLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        budgetLayout.gridwidth = 4;
        budgetLayout.gridx = 4;
        budgetLayout.gridy = 1;
        add(label, budgetLayout);

        //Home label on spending side
        label = new JLabel("Home : ");
        budgetLayout.fill = GridBagConstraints.HORIZONTAL;
        budgetLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        budgetLayout.gridwidth = 1;
        budgetLayout.gridx = 4;
        budgetLayout.gridy = 2;
        add(label, budgetLayout);

        //Home amount on spending side
        homeS = new JLabel(String.valueOf(String.format("%.2f", 0.0)));
        budgetLayout.fill = GridBagConstraints.HORIZONTAL;
        budgetLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        budgetLayout.gridwidth = 1;
        budgetLayout.gridx = 5;
        budgetLayout.gridy = 2;
        add(homeS, budgetLayout);

        //Food label on spending side
        label = new JLabel("Food : ");
        budgetLayout.fill = GridBagConstraints.HORIZONTAL;
        budgetLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        budgetLayout.gridwidth = 1;
        budgetLayout.gridx = 4;
        budgetLayout.gridy = 3;
        add(label, budgetLayout);

        //Food amount on spending side
        foodS = new JLabel(String.valueOf(String.format("%.2f", 0.0)));
        budgetLayout.fill = GridBagConstraints.HORIZONTAL;
        budgetLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        budgetLayout.gridwidth = 1;
        budgetLayout.gridx = 5;
        budgetLayout.gridy = 3;
        add(foodS, budgetLayout);

        //Hobbies label on spending side
        label = new JLabel("Hobbies : ");
        budgetLayout.fill = GridBagConstraints.HORIZONTAL;
        budgetLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        budgetLayout.gridwidth = 1;
        budgetLayout.gridx = 4;
        budgetLayout.gridy = 4;
        add(label, budgetLayout);

        //Hobbies amount on spending side
        hobbiesS = new JLabel(String.valueOf(String.format("%.2f", 0.0)));
        budgetLayout.fill = GridBagConstraints.HORIZONTAL;
        budgetLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        budgetLayout.gridwidth = 1;
        budgetLayout.gridx = 5;
        budgetLayout.gridy = 4;
        add(hobbiesS, budgetLayout);
        
        //Health label on spending side
        label = new JLabel("Health : ");
        budgetLayout.fill = GridBagConstraints.HORIZONTAL;
        budgetLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        budgetLayout.gridwidth = 1;
        budgetLayout.gridx = 4;
        budgetLayout.gridy = 5;
        add(label, budgetLayout);

        //Health amount on spending side
        healthS = new JLabel(String.valueOf(String.format("%.2f", 0.0)));
        budgetLayout.fill = GridBagConstraints.HORIZONTAL;
        budgetLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        budgetLayout.gridwidth = 1;
        budgetLayout.gridx = 5;
        budgetLayout.gridy = 5;
        add(healthS, budgetLayout);
        
        //Transport label on spending side
        label = new JLabel("Transport : ");
        budgetLayout.fill = GridBagConstraints.HORIZONTAL;
        budgetLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        budgetLayout.gridwidth = 1;
        budgetLayout.gridx = 4;
        budgetLayout.gridy = 6;
        add(label, budgetLayout);

        //Transport amount on spending side
        transportS = new JLabel(String.valueOf(String.format("%.2f", 0.0)));
        budgetLayout.fill = GridBagConstraints.HORIZONTAL;
        budgetLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        budgetLayout.gridwidth = 1;
        budgetLayout.gridx = 5;
        budgetLayout.gridy = 6;
        add(transportS, budgetLayout);
        
        //Entertainment label on spending side
        label = new JLabel("Entertainment : ");
        budgetLayout.fill = GridBagConstraints.HORIZONTAL;
        budgetLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        budgetLayout.gridwidth = 1;
        budgetLayout.gridx = 4;
        budgetLayout.gridy = 7;
        add(label, budgetLayout);

        //Entertainment amount on spending side
        entertainmentS = new JLabel(String.valueOf(String.format("%.2f", 0.0)));
        budgetLayout.fill = GridBagConstraints.HORIZONTAL;
        budgetLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        budgetLayout.gridwidth = 1;
        budgetLayout.gridx = 5;
        budgetLayout.gridy = 7;
        add(entertainmentS, budgetLayout);
        
        //Debt label on spending side
        label = new JLabel("Debt : ");
        budgetLayout.fill = GridBagConstraints.HORIZONTAL;
        budgetLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        budgetLayout.gridwidth = 1;
        budgetLayout.gridx = 4;
        budgetLayout.gridy = 8;
        add(label, budgetLayout);

        //Debt amount on spending side
        debtS = new JLabel(String.valueOf(String.format("%.2f", 0.0)));
        budgetLayout.fill = GridBagConstraints.HORIZONTAL;
        budgetLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        budgetLayout.gridwidth = 1;
        budgetLayout.gridx = 5;
        budgetLayout.gridy = 8;
        add(debtS, budgetLayout);
        
        //Car label on spending side
        label = new JLabel("Car : ");
        budgetLayout.fill = GridBagConstraints.HORIZONTAL;
        budgetLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        budgetLayout.gridwidth = 1;
        budgetLayout.gridx = 4;
        budgetLayout.gridy = 9;
        add(label, budgetLayout);

        //Car amount on spending side
        carS = new JLabel(String.valueOf(String.format("%.2f", 0.0)));
        budgetLayout.fill = GridBagConstraints.HORIZONTAL;
        budgetLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        budgetLayout.gridwidth = 1;
        budgetLayout.gridx = 5;
        budgetLayout.gridy = 9;
        add(carS, budgetLayout);
        
        //Other label on spending side
        label = new JLabel("Other : ");
        budgetLayout.fill = GridBagConstraints.HORIZONTAL;
        budgetLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        budgetLayout.gridwidth = 1;
        budgetLayout.gridx = 4;
        budgetLayout.gridy = 10;
        add(label, budgetLayout);

        //Other amount on spending side
        otherS = new JLabel(String.valueOf(String.format("%.2f", 0.0)));
        budgetLayout.fill = GridBagConstraints.HORIZONTAL;
        budgetLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        budgetLayout.gridwidth = 1;
        budgetLayout.gridx = 5;
        budgetLayout.gridy = 10;
        add(otherS, budgetLayout);
        
        //Total spending label
        label = new JLabel("Total Spendings : ");
        budgetLayout.fill = GridBagConstraints.HORIZONTAL;
        budgetLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        budgetLayout.gridwidth = 1;
        budgetLayout.gridx = 4;
        budgetLayout.gridy = 11;
        add(label, budgetLayout);

        //Total spending amount
        spendings = new JLabel(String.valueOf(String.format("%.2f", 0.0)));
        budgetLayout.fill = GridBagConstraints.HORIZONTAL;
        budgetLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        budgetLayout.gridwidth = 1;
        budgetLayout.gridx = 5;
        budgetLayout.gridy = 11;
        add(spendings, budgetLayout);

        //Make chart button on spending side
        budgetLayout.fill = GridBagConstraints.HORIZONTAL;
        budgetLayout.insets = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
        budgetLayout.gridwidth = 1;
        budgetLayout.gridx = 4;
        budgetLayout.gridy = 12;
        add(makeChart2, budgetLayout);

        //JFrame settings
        setMinimumSize(new Dimension(960, 720));
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(appIcon);
    }
}
