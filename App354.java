/**
 *
 * COMP 354 Project
 * Group PJ-A
 */

public class App354 {

	public static void main(String[] args) {

		MyMoneyController.controller();

		// Test methods/cases for the LogIn class.
		LogInTest lt = new LogInTest();
		lt.testValidateUser();
		lt.testRecordNewUser();
		lt.testReadUserInfo();

	}

}
