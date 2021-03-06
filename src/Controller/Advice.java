package Controller;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.DoubleStream;

import Model.Model;


public class Advice {
	
	public String Advice;
	public String savings = "";
	public void execute() {

        ArrayList<String> arr = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader(".//datafiles//transactions_data")))
        {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                arr.add(sCurrentLine + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        savingAdvice(arr); 
        
        
    }
	/* test array values
	private static void printArray(ArrayList<String> arr) {
	      for (int i = 0; i < arr.size(); i++) {
	         if (i > 0) {
	            System.out.println("");
	         }
	         System.out.print(arr.get(i));
	      }
	   }
	 */
	
	

	
	public String savingAdvice(ArrayList<String> arr){
		
		String [] array_arr = arr.toArray(new String[arr.size()]);
		double [] array_type = {0.00,0.00,0.00,0.00,0.00,0.00,0.00};
		double double_amount = 0;
		String advice = "";
		
		
		 for (int i = 0; i < array_arr.length; i++) {
			 
	         if (array_arr[i].length()>=4){
	         String ExpenseType 	= array_arr[i].substring(array_arr[i].length() - 5); //gets the 4 last characters
	
	         String StringAmount 	= array_arr[i].substring(0,array_arr[i].indexOf(".") + 3); //gets 2 characters after the .
	         double_amount = Double.parseDouble(StringAmount);
	         System.out.println(ExpenseType.equals("Inco"));
	         System.out.println(ExpenseType);
	         
	         if (ExpenseType.trim().equals("Inco")) {
	        	 
	        	 array_type[0]+=double_amount;
	         }
	         else if (ExpenseType.trim().equals("Home")) {
	        	 array_type[1]+=double_amount;
	         }
	         else if (ExpenseType.trim().equals("Food")) {
	        	 array_type[2]+=double_amount;
	         }
	         else if (ExpenseType.trim().equals("Entr")) {
	        	 array_type[3]+=double_amount;
	         }
	         else if (ExpenseType.trim().equals("Save")) {
	        	 array_type[5]+=double_amount;
	        	 array_type[6]= -25900;
	         }
	         else if (ExpenseType.equals("Debt")) {
	        	 array_type[6]+=double_amount;
	         }
	         else {
	        	 array_type[4]+=double_amount;
	         }
	         
	         }
	         else {advice="Error";}
	         
	      }
		 	 double sum = array_type[0]+array_type[1]+array_type[2]+array_type[3]+array_type[4]+array_type[5];
		 	 double totalExpense = array_type[1]+array_type[2]+array_type[3]+array_type[4];
		 	 String statement =  ("Your income this month is: " + array_type[0])+("You currently have " + array_type[5] + " in your savings account"+
		 			 	'\n' +"Your expense in the home category this month is: " + array_type[1]+ 
						'\n' +"Your expense in the food category this month is: " + array_type[2]+
						'\n' +"Your expense in the entertainment category this month is: " + array_type[3]+
						'\n' +"Your expense in the other category this month is: " + array_type[4]+
						'\n' +"The sum of your expenses up to date is " + totalExpense+
						'\n' +"The sum of your holdings minus your expenses , and without counting the debt to date is " + sum+
						'\n' +"Your total debts are of " + array_type[6]);
			 
			 System.out.println("");
			 
			 if(array_type[0]-totalExpense >= array_type[0]*.2 && sum !=0 && totalExpense !=0) {
				 advice = ('\n'+"You should be trying to save money as you have spent about "+ -(totalExpense)/array_type[0]*100 +"% of your income this month."+
						 '\n'+ "Your income is of "+ array_type[0]+ " yet you have spent "+totalExpense);
				 if(array_type[6]<= sum){ 
					 advice=advice += ('\n'+"You should be paying your debts rather than spending, as you have "+ array_type[6] +" in debt and "+array_type[5] +" in savings_data");
				 }
				 else {System.out.println("However, you have minimal debt");}
			 }
			 else if(array_type[6]<= sum && array_type[6] != 0){ 
				 advice=('\n'+"You should be paying your debts rather than spending, as you have "+ array_type[6] +"in debt and "+array_type[5] +" in savings_data");
				 advice+=('\n'+"However, you are accumulating money, as your bring in more than you use");	
			 }
			 else if ((array_type[6]<=0) && (array_type[0] >= totalExpense) && totalExpense !=0 && sum !=0){
				 advice=('\n'+"You have no debts and ae using less than you are making, keep at it!");
			 }
			 else {
				 advice=('\n'+"Your statement is not complete");
			 }
			 
			 this.Advice=statement+advice;
			 			 
			 //calculate how long it would take to pay debt
			 int months = 0;
			 double debt = array_type[6];
			 double income = array_type[0];
			 double moneySaved = 0;
			 double initialPayment = debt/10*-1;
			 while(debt<0)
			 {
				 debt += income/4;
				 //charge 10% interest once a year
					 if(months%12==0) {
					 debt += debt/10;
					 moneySaved += initialPayment + debt/10;
					 }
					 
				
			
				 ++months;
			 }
			 
			 moneySaved = ((int)(moneySaved *100)/100.0);
			 			 
			 if(array_type[6]<0)
			 {
				 
			 savings += "Your debt is costing you "+array_type[6]/10*-1+"$ a year "+
			 "with a 10% interest rate.\n"+
			 "It would take you "+months+" months to pay off your debt if "+
			 "you paid 25% of your current salary towards it every month.\n"
			 + "This would save you: "+moneySaved+"$ and "+array_type[6]/10*-1+"$"+
			 " every subsequent year.";
			 }
			 else {
				 savings += "You have no debts.";
			 }
			 
			 Model.setSavings(savings);
			 
		
		return advice;
	}
	
	
}

