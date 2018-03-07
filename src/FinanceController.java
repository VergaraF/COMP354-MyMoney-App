
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.XChartPanel;

/**
 *
 * @author Vincent
 */
public class FinanceController {

    protected static float homeSpending = 0;
    protected static float foodSpending = 0;
    protected static float hobbiesSpending = 0;
    protected static float savingsSpending = 0;
    protected static float otherSpending = 0;
    protected static float homeBudget = 0;
    protected static float foodBudget = 0;
    protected static float hobbiesBudget = 0;
    protected static float savingsBudget = 0;
    protected static float otherBudget = 0;
    protected static float totalBudget = 0;
    protected static float totalSpending = 0;
    protected static final JFrame BUDGETCHARTFRAME = new JFrame("Budget Chart");
    protected static final JFrame SPENDINGSCHARTFRAME = new JFrame("Spendings Chart");
    protected static final FinancePanel FP = new FinancePanel();

    /**
     * Provide action on click for the finance panel
     */
    public static void setup() {
        FP.setupForPanel();
        getBudgetDropInfo();
        getSpendingDropInfo();
        createBudgetChart();
        createSpendingsChart();
        resetBudget();
        resetSpendings();
    }

    /**
     * Allow the reset budget button to reset the labels on the budget side
     */
    public static void resetBudget() {
        FP.resetBudget.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homeBudget = 0;
                foodBudget = 0;
                hobbiesBudget = 0;
                savingsBudget = 0;
                otherBudget = 0;
                totalBudget = 0;
                FP.budget.setText(String.valueOf(String.format("%.2f", 0.0)));
                FP.homeB.setText(String.valueOf(String.format("%.2f", 0.0)));
                FP.foodB.setText(String.valueOf(String.format("%.2f", 0.0)));
                FP.hobbiesB.setText(String.valueOf(String.format("%.2f", 0.0)));
                FP.savingsB.setText(String.valueOf(String.format("%.2f", 0.0)));
                FP.otherB.setText(String.valueOf(String.format("%.2f", 0.0)));
            }
        });
    }

    /**
     * Allow the reset spending button to reset the labels on the spending side
     */
    public static void resetSpendings() {
        FP.resetSpendings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                totalSpending = 0;
                homeSpending = 0;
                foodSpending = 0;
                hobbiesSpending = 0;
                savingsSpending = 0;
                otherSpending = 0;
                FP.spendings.setText(String.valueOf(String.format("%.2f", 0.0)));
                FP.homeS.setText(String.valueOf(String.format("%.2f", 0.0)));
                FP.foodS.setText(String.valueOf(String.format("%.2f", 0.0)));
                FP.hobbiesS.setText(String.valueOf(String.format("%.2f", 0.0)));
                FP.savingsS.setText(String.valueOf(String.format("%.2f", 0.0)));
                FP.otherS.setText(String.valueOf(String.format("%.2f", 0.0)));

            }
        });
    }

    /**
     * Create a chart with the budget labels when you click on the create a
     * chart button on the budget side.
     */
    public static void createBudgetChart() {
        FP.makeChart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FP.budgetChart = new PieChartBuilder().width(400).height(400).title("Budget Chart").build();
                FP.budgetChart.addSeries("Home", (homeBudget / totalBudget));
                FP.budgetChart.addSeries("Food", (foodBudget / totalBudget));
                FP.budgetChart.addSeries("Hobbies", (hobbiesBudget / totalBudget));
                FP.budgetChart.addSeries("Savings", (savingsBudget / totalBudget));
                FP.budgetChart.addSeries("Other", (otherBudget / totalBudget));
                FP.bChart = new XChartPanel(FP.budgetChart);
                BUDGETCHARTFRAME.add(FP.bChart);
                BUDGETCHARTFRAME.setVisible(true);
                BUDGETCHARTFRAME.setSize(900, 400);
            }
        });
    }

    /**
     * Create a chart with the spending labels when you click on the create a
     * chart button on the spending side.
     */
    public static void createSpendingsChart() {
        FP.makeChart2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FP.spendingChart = new PieChartBuilder().width(400).height(400).title("Spendings Chart").build();
                FP.spendingChart.addSeries("Home", (homeSpending / totalSpending));
                FP.spendingChart.addSeries("Food", (foodSpending / totalSpending));
                FP.spendingChart.addSeries("Hobbies", (hobbiesSpending / totalSpending));
                FP.spendingChart.addSeries("Savings", (savingsSpending / totalSpending));
                FP.spendingChart.addSeries("Other", (otherSpending / totalSpending));
                FP.sChart = new XChartPanel(FP.spendingChart);
                SPENDINGSCHARTFRAME.add(FP.sChart);
                SPENDINGSCHARTFRAME.setVisible(true);
                SPENDINGSCHARTFRAME.setSize(900, 400);
            }
        });
    }

    /**
     * Take the amount from the text field on the budget side and put it in the
     * label corresponding to the category from the drop box menu.
     */
    public static void getBudgetDropInfo() {
        FP.addToBudget.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (String.valueOf(FP.expectedSpending.getSelectedItem())) {
                    case "Home":
                        if (!FP.text1.getText().equals("")) {
                            homeBudget += Float.parseFloat(FP.text1.getText());
                            totalBudget += Float.parseFloat(FP.text1.getText());
                            FP.budget.setText(String.valueOf(String.format("%.2f", totalBudget)));
                            FP.homeB.setText(String.valueOf(String.format("%.2f", homeBudget)));
                        }
                        break;
                    case "Food":
                        if (!FP.text1.getText().equals("")) {
                            foodBudget += Float.parseFloat(FP.text1.getText());
                            totalBudget += Float.parseFloat(FP.text1.getText());
                            FP.budget.setText(String.valueOf(String.format("%.2f", totalBudget)));
                            FP.foodB.setText(String.valueOf(String.format("%.2f", foodBudget)));
                        }
                        break;
                    case "Hobbies":
                        if (!FP.text1.getText().equals("")) {
                            hobbiesBudget += Float.parseFloat(FP.text1.getText());
                            totalBudget += Float.parseFloat(FP.text1.getText());
                            FP.budget.setText(String.valueOf(String.format("%.2f", totalBudget)));
                            FP.hobbiesB.setText(String.valueOf(String.format("%.2f", hobbiesBudget)));
                        }
                        break;
                    case "Savings":
                        if (!FP.text1.getText().equals("")) {
                            savingsBudget += Float.parseFloat(FP.text1.getText());
                            totalBudget += Float.parseFloat(FP.text1.getText());
                            FP.budget.setText(String.valueOf(String.format("%.2f", totalBudget)));
                            FP.savingsB.setText(String.valueOf(String.format("%.2f", savingsBudget)));
                        }
                        break;
                    case "Other":
                        if (!FP.text1.getText().equals("")) {
                            otherBudget += Float.parseFloat(FP.text1.getText());
                            totalBudget += Float.parseFloat(FP.text1.getText());
                            FP.budget.setText(String.valueOf(String.format("%.2f", totalBudget)));
                            FP.otherB.setText(String.valueOf(String.format("%.2f", otherBudget)));
                        }
                        break;
                }
            }
        });
    }

    /**
     * Take the amount from the text field on the spending side and put it in
     * the label corresponding to the category from the drop box menu.
     */
    public static void getSpendingDropInfo() {
        FP.addToSpendings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (String.valueOf(FP.realSpending.getSelectedItem())) {
                    case "Home":
                        if (!FP.text2.getText().equals("")) {
                            homeSpending += Float.parseFloat(FP.text2.getText());
                            totalSpending += Float.parseFloat(FP.text2.getText());
                            FP.spendings.setText(String.valueOf(String.format("%.2f", totalSpending)));
                            FP.homeS.setText(String.valueOf(String.format("%.2f", homeSpending)));
                        }
                        break;
                    case "Food":
                        if (!FP.text2.getText().equals("")) {
                            foodSpending += Float.parseFloat(FP.text2.getText());
                            totalSpending += Float.parseFloat(FP.text2.getText());
                            FP.spendings.setText(String.valueOf(String.format("%.2f", totalSpending)));
                            FP.foodS.setText(String.valueOf(String.format("%.2f", foodSpending)));
                        }
                        break;
                    case "Hobbies":
                        if (!FP.text2.getText().equals("")) {
                            hobbiesSpending += Float.parseFloat(FP.text2.getText());
                            totalSpending += Float.parseFloat(FP.text2.getText());
                            FP.spendings.setText(String.valueOf(String.format("%.2f", totalSpending)));
                            FP.hobbiesS.setText(String.valueOf(String.format("%.2f", hobbiesSpending)));
                        }
                        break;
                    case "Savings":
                        if (!FP.text2.getText().equals("")) {
                            savingsSpending += Float.parseFloat(FP.text2.getText());
                            totalSpending += Float.parseFloat(FP.text2.getText());
                            FP.spendings.setText(String.valueOf(String.format("%.2f", totalSpending)));
                            FP.savingsS.setText(String.valueOf(String.format("%.2f", savingsSpending)));
                        }
                        break;
                    case "Other":
                        if (!FP.text2.getText().equals("")) {
                            otherSpending += Float.parseFloat(FP.text2.getText());
                            totalSpending += Float.parseFloat(FP.text2.getText());
                            FP.spendings.setText(String.valueOf(String.format("%.2f", totalSpending)));
                            FP.otherS.setText(String.valueOf(String.format("%.2f", otherSpending)));
                        }
                        break;
                }
            }
        });
    }
}
