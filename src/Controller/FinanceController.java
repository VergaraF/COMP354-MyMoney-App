package Controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.XChartPanel;

import View.*;
import Controller.*;
import Model.Transaction;
import Model.TransactionCategory;
/**
 *
 * @author Vincent
 */
public class FinanceController {

    public static float homeSpending = 0;
    public static float foodSpending = 0;
    public static float hobbiesSpending = 0;
    public static float otherSpending = 0;
    public static float healthSpending = 0;
    public static float transportSpending = 0;
    public static float entertainmentSpending = 0;
    public static float debtSpending = 0;
    public static float carSpending = 0;
    public static float totalSpending = 0;
    
    public static float homeBudget = 0;
    public static float foodBudget = 0;
    public static float hobbiesBudget = 0;
    public static float healthBudget = 0;
    public static float transportBudget = 0;
    public static float entertainmentBudget = 0;
    public static float debtBudget = 0;
    public static float carBudget = 0;
    public static float otherBudget = 0;
    public static float totalBudget = 0;
    
    public static final JFrame BUDGETCHARTFRAME = new JFrame("Budget Chart");
    public static final JFrame SPENDINGSCHARTFRAME = new JFrame("Spendings Chart");
    public static final FinancePanel FP = new FinancePanel();

    /**
     * Provide action on click for the finance panel
     */
    public static void setup() {
        FP.setupForPanel();
        getBudgetDropInfo();
        createBudgetChart();
        createSpendingsChart();
        resetBudget();
        loadSpendings();
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
                healthBudget = 0;
                transportBudget = 0;
                entertainmentBudget = 0;
                debtBudget = 0;
                carBudget = 0;
                otherBudget = 0;
                totalBudget = 0;
                FP.homeB.setText(String.valueOf(String.format("%.2f", 0.0)));
                FP.foodB.setText(String.valueOf(String.format("%.2f", 0.0)));
                FP.hobbiesB.setText(String.valueOf(String.format("%.2f", 0.0)));
                FP.healthB.setText(String.valueOf(String.format("%.2f", 0.0)));
                FP.transportB.setText(String.valueOf(String.format("%.2f", 0.0)));
                FP.entertainmentB.setText(String.valueOf(String.format("%.2f", 0.0)));
                FP.debtB.setText(String.valueOf(String.format("%.2f", 0.0)));
                FP.carB.setText(String.valueOf(String.format("%.2f", 0.0)));
                FP.otherB.setText(String.valueOf(String.format("%.2f", 0.0)));
                FP.budget.setText(String.valueOf(String.format("%.2f", 0.0)));
            }
        });
    }

    /**
     * Load the spendings to set the labels on the spending side
     */
    public static void loadSpendings() 
    {
        homeSpending = 0;
        foodSpending = 0;
        hobbiesSpending = 0;
        healthSpending = 0;
        transportSpending = 0;
        entertainmentSpending = 0;
        debtSpending = 0;
        carSpending = 0;
        otherSpending = 0;
        totalSpending = 0;
        
        Transaction[] transactions = TransactionsController.GetTransactions();
        
        for(int i = 0; i < transactions.length; i++)
		{
        	if(transactions[i].category == TransactionCategory.INCOME ||
        	   transactions[i].category == TransactionCategory.SAVINGS)
        	{
        		continue;
        	}
        	
        	homeSpending += transactions[i].category == TransactionCategory.HOME ? -transactions[i].amount : 0f;
        	foodSpending += transactions[i].category == TransactionCategory.FOOD ? -transactions[i].amount : 0f;
        	hobbiesSpending += transactions[i].category == TransactionCategory.HOBBIES ? -transactions[i].amount : 0f;
        	otherSpending += transactions[i].category == TransactionCategory.OTHER ? -transactions[i].amount : 0f;
        	healthSpending += transactions[i].category == TransactionCategory.HEALTH ? -transactions[i].amount : 0f;
            transportSpending += transactions[i].category == TransactionCategory.TRANSPORT ? -transactions[i].amount : 0f;
            entertainmentSpending += transactions[i].category == TransactionCategory.ENTR ? -transactions[i].amount : 0f;
            debtSpending += transactions[i].category == TransactionCategory.DEBT ? -transactions[i].amount : 0f;
            carSpending += transactions[i].category == TransactionCategory.CAR ? -transactions[i].amount : 0f;
        	totalSpending += -transactions[i].amount;
		}
        
        FP.homeS.setText(String.valueOf(String.format("%.2f", homeSpending)));
        FP.foodS.setText(String.valueOf(String.format("%.2f", foodSpending)));
        FP.hobbiesS.setText(String.valueOf(String.format("%.2f", hobbiesSpending)));
        FP.healthS.setText(String.valueOf(String.format("%.2f", healthSpending)));
        FP.transportS.setText(String.valueOf(String.format("%.2f", transportSpending)));
        FP.entertainmentS.setText(String.valueOf(String.format("%.2f", entertainmentSpending)));
        FP.debtS.setText(String.valueOf(String.format("%.2f", debtSpending)));
        FP.carS.setText(String.valueOf(String.format("%.2f", carSpending)));
        FP.otherS.setText(String.valueOf(String.format("%.2f", otherSpending)));
        FP.spendings.setText(String.valueOf(String.format("%.2f", totalSpending)));
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
                FP.budgetChart.addSeries("Health", (healthBudget / totalBudget));
                FP.budgetChart.addSeries("Transport", (transportBudget / totalBudget));
                FP.budgetChart.addSeries("Entertrainment", (entertainmentBudget / totalBudget));
                FP.budgetChart.addSeries("Debt", (debtBudget / totalBudget));
                FP.budgetChart.addSeries("Car", (carBudget / totalBudget));
                FP.budgetChart.addSeries("Other", (otherBudget / totalBudget));
                FP.bChart = new XChartPanel(FP.budgetChart);
                BUDGETCHARTFRAME.add(FP.bChart);
                BUDGETCHARTFRAME.setVisible(true);
                BUDGETCHARTFRAME.setMinimumSize(new Dimension(960, 720));
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
                FP.spendingChart.addSeries("Health", (healthSpending / totalSpending));
                FP.spendingChart.addSeries("Transport", (transportSpending / totalSpending));
                FP.spendingChart.addSeries("Entertrainment", (entertainmentSpending / totalSpending));
                FP.spendingChart.addSeries("Debt", (debtSpending / totalSpending));
                FP.spendingChart.addSeries("Car", (carSpending / totalSpending));
                FP.spendingChart.addSeries("Other", (otherSpending / totalSpending));
                FP.sChart = new XChartPanel(FP.spendingChart);
                SPENDINGSCHARTFRAME.add(FP.sChart);
                SPENDINGSCHARTFRAME.setVisible(true);
                SPENDINGSCHARTFRAME.setMinimumSize(new Dimension(960, 720));
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
                    case "Health":
                        if (!FP.text1.getText().equals("")) {
                            healthBudget += Float.parseFloat(FP.text1.getText());
                            totalBudget += Float.parseFloat(FP.text1.getText());
                            FP.budget.setText(String.valueOf(String.format("%.2f", totalBudget)));
                            FP.healthB.setText(String.valueOf(String.format("%.2f", healthBudget)));
                        }
                        break;
                    case "Transport":
                        if (!FP.text1.getText().equals("")) {
                            transportBudget += Float.parseFloat(FP.text1.getText());
                            totalBudget += Float.parseFloat(FP.text1.getText());
                            FP.budget.setText(String.valueOf(String.format("%.2f", totalBudget)));
                            FP.transportB.setText(String.valueOf(String.format("%.2f", transportBudget)));
                        }
                        break;
                    case "Entertainment":
                        if (!FP.text1.getText().equals("")) {
                            entertainmentBudget += Float.parseFloat(FP.text1.getText());
                            totalBudget += Float.parseFloat(FP.text1.getText());
                            FP.budget.setText(String.valueOf(String.format("%.2f", totalBudget)));
                            FP.entertainmentB.setText(String.valueOf(String.format("%.2f", entertainmentBudget)));
                        }
                        break;
                    case "Debt":
                        if (!FP.text1.getText().equals("")) {
                            debtBudget += Float.parseFloat(FP.text1.getText());
                            totalBudget += Float.parseFloat(FP.text1.getText());
                            FP.budget.setText(String.valueOf(String.format("%.2f", totalBudget)));
                            FP.debtB.setText(String.valueOf(String.format("%.2f", debtBudget)));
                        }
                        break;
                    case "Car":
                        if (!FP.text1.getText().equals("")) {
                            carBudget += Float.parseFloat(FP.text1.getText());
                            totalBudget += Float.parseFloat(FP.text1.getText());
                            FP.budget.setText(String.valueOf(String.format("%.2f", totalBudget)));
                            FP.carB.setText(String.valueOf(String.format("%.2f", carBudget)));
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
}
