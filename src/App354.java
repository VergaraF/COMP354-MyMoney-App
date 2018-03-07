/**
 *
 * COMP 354 Project
 * Group PJ-A
 */
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import Controller.MyMoneyController;
import Tests.*;
import Model.*;
import Controller.*;

public class App354 {

	public static void main(String[] args) {

		MyMoneyController.controller();

		// Test methods/cases for the LogIn class.
		LogInTest lt = new LogInTest();
		lt.testValidateUser();
		lt.testRecordNewUser();
		lt.testReadUserInfo();
		//Test cases for FinanceController class.
		Result result = JUnitCore.runClasses(FinanceTest.class);
        	for (Failure failure : result.getFailures()) {
            		System.out.println(failure.toString());
        	}
        	System.out.println("Test equals to null were a failure");
		
		  //Test cases for bankPanel class
         	 BankingInfoTest b1 = new BankingInfoTest();
         	 b1.testTransactions();
         	 b1.testSavings();
	}
}
