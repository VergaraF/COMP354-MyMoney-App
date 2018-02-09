


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

    private static float homeSpending = 0;
    private static float foodSpending = 0;
    private static float hobbiesSpending = 0;
    private static float savingsSpending = 0;
    private static float otherSpending = 0;
    private static float homeBudget = 0;
    private static float foodBudget = 0;
    private static float hobbiesBudget = 0;
    private static float savingsBudget = 0;
    private static float otherBudget = 0;
    private static float totalBudget = 0;
    private static float totalSpending = 0;
    private static final JFrame budgetChartFrame = new JFrame("Budget Chart");
    private static final JFrame spendingsChartFrame = new JFrame("Spendings Chart");
    private static FinancePanel fp = new FinancePanel();

    public static void setup() {
        fp.setupForPanel();
        getBudgetDropInfo();
        getSpendingDropInfo();
        createBudgetChart();
        createSpendingsChart();
        resetBudget();
        resetSpendings();
    }

    public static void resetBudget() {
        fp.resetBudget.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homeBudget = 0;
                foodBudget = 0;
                hobbiesBudget = 0;
                savingsBudget = 0;
                otherBudget = 0;
                totalBudget = 0;
                fp.budget.setText(String.valueOf(String.format("%.2f", 0.0)));
                fp.homeB.setText(String.valueOf(String.format("%.2f", 0.0)));
                fp.foodB.setText(String.valueOf(String.format("%.2f", 0.0)));
                fp.hobbiesB.setText(String.valueOf(String.format("%.2f", 0.0)));
                fp.savingsB.setText(String.valueOf(String.format("%.2f", 0.0)));
                fp.otherB.setText(String.valueOf(String.format("%.2f", 0.0)));
            }
        });
    }

    public static void resetSpendings() {
        fp.resetSpendings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                totalSpending = 0;
                homeSpending = 0;
                foodSpending = 0;
                hobbiesSpending = 0;
                savingsSpending = 0;
                otherSpending = 0;
                fp.spendings.setText(String.valueOf(String.format("%.2f", 0.0)));
                fp.homeS.setText(String.valueOf(String.format("%.2f", 0.0)));
                fp.foodS.setText(String.valueOf(String.format("%.2f", 0.0)));
                fp.hobbiesS.setText(String.valueOf(String.format("%.2f", 0.0)));
                fp.savingsS.setText(String.valueOf(String.format("%.2f", 0.0)));
                fp.otherS.setText(String.valueOf(String.format("%.2f", 0.0)));

            }
        });
    }

    public static void createBudgetChart() {
        fp.makeChart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fp.budgetChart = new PieChartBuilder().width(400).height(400).title("Budget Chart").build();
                fp.budgetChart.addSeries("Home", (homeBudget / totalBudget));
                fp.budgetChart.addSeries("Food", (foodBudget / totalBudget));
                fp.budgetChart.addSeries("Hobbies", (hobbiesBudget / totalBudget));
                fp.budgetChart.addSeries("Savings", (savingsBudget / totalBudget));
                fp.budgetChart.addSeries("Other", (otherBudget / totalBudget));
                fp.bChart = new XChartPanel(fp.budgetChart);
                budgetChartFrame.add(fp.bChart);
                budgetChartFrame.setVisible(true);
                budgetChartFrame.setSize(900, 400);
            }
        });
    }

    public static void createSpendingsChart() {
        fp.makeChart2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fp.spendingChart = new PieChartBuilder().width(400).height(400).title("Spendings Chart").build();
                fp.spendingChart.addSeries("Home", (homeSpending / totalSpending));
                fp.spendingChart.addSeries("Food", (foodSpending / totalSpending));
                fp.spendingChart.addSeries("Hobbies", (hobbiesSpending / totalSpending));
                fp.spendingChart.addSeries("Savings", (savingsSpending / totalSpending));
                fp.spendingChart.addSeries("Other", (otherSpending / totalSpending));
                fp.sChart = new XChartPanel(fp.spendingChart);
                spendingsChartFrame.add(fp.sChart);
                spendingsChartFrame.setVisible(true);
                spendingsChartFrame.setSize(900, 400);
            }
        });
    }

    public static void getBudgetDropInfo() {
        fp.addToBudget.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (String.valueOf(fp.expectedSpending.getSelectedItem())) {
                    case "Home":
                        if (!fp.text1.getText().equals("")) {
                            homeBudget += Float.parseFloat(fp.text1.getText());
                            totalBudget += Float.parseFloat(fp.text1.getText());
                            fp.budget.setText(String.valueOf(String.format("%.2f", totalBudget)));
                            fp.homeB.setText(String.valueOf(String.format("%.2f", homeBudget)));
                        }
                        break;
                    case "Food":
                        if (!fp.text1.getText().equals("")) {
                            foodBudget += Float.parseFloat(fp.text1.getText());
                            totalBudget += Float.parseFloat(fp.text1.getText());
                            fp.budget.setText(String.valueOf(String.format("%.2f", totalBudget)));
                            fp.foodB.setText(String.valueOf(String.format("%.2f", foodBudget)));
                        }
                        break;
                    case "Hobbies":
                        if (!fp.text1.getText().equals("")) {
                            hobbiesBudget += Float.parseFloat(fp.text1.getText());
                            totalBudget += Float.parseFloat(fp.text1.getText());
                            fp.budget.setText(String.valueOf(String.format("%.2f", totalBudget)));
                            fp.hobbiesB.setText(String.valueOf(String.format("%.2f", hobbiesBudget)));
                        }
                        break;
                    case "Savings":
                        if (!fp.text1.getText().equals("")) {
                            savingsBudget += Float.parseFloat(fp.text1.getText());
                            totalBudget += Float.parseFloat(fp.text1.getText());
                            fp.budget.setText(String.valueOf(String.format("%.2f", totalBudget)));
                            fp.savingsB.setText(String.valueOf(String.format("%.2f", savingsBudget)));
                        }
                        break;
                    case "Other":
                        if (!fp.text1.getText().equals("")) {
                            otherBudget += Float.parseFloat(fp.text1.getText());
                            totalBudget += Float.parseFloat(fp.text1.getText());
                            fp.budget.setText(String.valueOf(String.format("%.2f", totalBudget)));
                            fp.otherB.setText(String.valueOf(String.format("%.2f", otherBudget)));
                        }
                        break;
                }
            }
        });
    }

    public static void getSpendingDropInfo() {
        fp.addToSpendings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (String.valueOf(fp.realSpending.getSelectedItem())) {
                    case "Home":
                        if (!fp.text2.getText().equals("")) {
                            homeSpending += Float.parseFloat(fp.text2.getText());
                            totalSpending += Float.parseFloat(fp.text2.getText());
                            fp.spendings.setText(String.valueOf(String.format("%.2f", totalSpending)));
                            fp.homeS.setText(String.valueOf(String.format("%.2f", homeSpending)));
                        }
                        break;
                    case "Food":
                        if (!fp.text2.getText().equals("")) {
                            foodSpending += Float.parseFloat(fp.text2.getText());
                            totalSpending += Float.parseFloat(fp.text2.getText());
                            fp.spendings.setText(String.valueOf(String.format("%.2f", totalSpending)));
                            fp.foodS.setText(String.valueOf(String.format("%.2f", foodSpending)));
                        }
                        break;
                    case "Hobbies":
                        if (!fp.text2.getText().equals("")) {
                            hobbiesSpending += Float.parseFloat(fp.text2.getText());
                            totalSpending += Float.parseFloat(fp.text2.getText());
                            fp.spendings.setText(String.valueOf(String.format("%.2f", totalSpending)));
                            fp.hobbiesS.setText(String.valueOf(String.format("%.2f", hobbiesSpending)));
                        }
                        break;
                    case "Savings":
                        if (!fp.text2.getText().equals("")) {
                            savingsSpending += Float.parseFloat(fp.text2.getText());
                            totalSpending += Float.parseFloat(fp.text2.getText());
                            fp.spendings.setText(String.valueOf(String.format("%.2f", totalSpending)));
                            fp.savingsS.setText(String.valueOf(String.format("%.2f", savingsSpending)));
                        }
                        break;
                    case "Other":
                        if (!fp.text2.getText().equals("")) {
                            otherSpending += Float.parseFloat(fp.text2.getText());
                            totalSpending += Float.parseFloat(fp.text2.getText());
                            fp.spendings.setText(String.valueOf(String.format("%.2f", totalSpending)));
                            fp.otherS.setText(String.valueOf(String.format("%.2f", otherSpending)));
                        }
                        break;
                }
            }
        });
    }
}

