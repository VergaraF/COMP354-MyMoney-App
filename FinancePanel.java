
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.knowm.xchart.*;

/**
 *
 * @author Vincent
 */
public class FinancePanel extends MainPanel {
    private BufferedImage appIcon;
    private PieChart budgetChart;
    private PieChart spendingChart;
    private final String[] spendingList = {"Home","Food","Hobbies","Savings","Other"};
    private JComboBox expectedSpending;
    private JComboBox realSpending;
    private JPanel bChart;
    private JPanel sChart;
    private JTextField text1;
    private JTextField text2;
    private JButton makeChart;
    private JButton addToChart;
    private JButton makeChart2;
    private JButton addToChart2;
    private JLabel label;
    
    public FinancePanel() {
        appIcon = chooseIconImage(appIcon, "money.png");
        expectedSpending = new JComboBox(spendingList);
        realSpending = new JComboBox(spendingList);
        
        budgetChart = new PieChartBuilder().width(400).height(200).title("Expected Spendings Chart").build();
        budgetChart.addSeries("test",20);
        budgetChart.addSeries("test2",20);
        budgetChart.addSeries("test3",20);
        budgetChart.addSeries("test4",20);
        budgetChart.addSeries("test5",20);
        
        spendingChart = new PieChartBuilder().width(400).height(200).title("Real Spendings Chart").build();
        spendingChart.addSeries("test",20);
        spendingChart.addSeries("test2",20);
        spendingChart.addSeries("test3",20);
        spendingChart.addSeries("test4",20);
        spendingChart.addSeries("test5",20);
        
        text1 = new JTextField("",6);
        text2 = new JTextField("",6);
        bChart = new XChartPanel(this.budgetChart);
        sChart = new XChartPanel(this.spendingChart);
        makeChart = new JButton("Create chart");
        addToChart = new JButton("Add to the chart");
        makeChart2 = new JButton("Create chart");
        addToChart2 = new JButton("Add to the chart");
    }

    @Override
    public void setupForPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();
     
        label = new JLabel("Expected Spendings");
        gb.insets = new Insets(0,0,100,0);
        gb.gridx=0;
        gb.gridy=0;
        add(label,gb);
        
        label = new JLabel("Total Budget : ");
        gb.insets = new Insets(0,-322,25,0);
        gb.gridx=0;
        gb.gridy=0;
        add(label,gb);
        
        gb.insets = new Insets(0,-322,-80,0);
        gb.gridx=0;
        gb.gridy=0;
        add(expectedSpending,gb);
        
        gb.insets = new Insets(0,-150,-80,0);
        gb.gridx=0;
        gb.gridy=0;
        add(text1,gb);
        
        gb.insets = new Insets(0,50,-80,0);
        gb.gridx=0;
        gb.gridy=0;
        add(addToChart,gb);
        
        gb.insets = new Insets(0,293,-80,0);
        gb.gridx=0;
        gb.gridy=0;
        add(makeChart,gb);
        
        label = new JLabel("Total Spendings : ");
        gb.insets = new Insets(0,-290,25,0);
        gb.gridx=1;
        gb.gridy=0;
        add(label,gb);
        
        label = new JLabel("Real Spendings");
        gb.insets = new Insets(0,0,100,0);
        gb.gridx=1;
        gb.gridy=0;
        add(label,gb);
        
        gb.insets = new Insets(0,-315,-80,0);
        gb.gridx=1;
        gb.gridy=0;
        add(realSpending,gb);
        
        gb.insets = new Insets(0,-150,-80,0);
        gb.gridx=1;
        gb.gridy=0;
        add(text2,gb);
        
        gb.insets = new Insets(0,57,-80,0);
        gb.gridx=1;
        gb.gridy=0;
        add(addToChart2,gb);
        
        gb.insets = new Insets(0,303,-80,0);
        gb.gridx=1;
        gb.gridy=0;
        add(makeChart2,gb);
        
        gb.insets = new Insets(0,0,0,0);
        gb.gridx=0;
        gb.gridy=1;
        add(bChart,gb);
        
        gb.insets = new Insets(0,10,0,0);
        gb.gridx=1;
        gb.gridy=1;
        add(sChart,gb);
        //Panel settings
        setSize(850, 400);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(appIcon);
    }
}
