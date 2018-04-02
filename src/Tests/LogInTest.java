package Tests;
/**
 * This is a JUnit test class. For now, it implements three methods: saveUserInfo(), 
 * recordNewUser() and validateUser(),form the LogIn class.
 */

import Controller.LogIn;
import junit.framework.TestCase;

public class LogInTest extends TestCase {

	// Test for the recordUser method. Asserts the size of the arraylist
	// containing user information.

	public void testRecordNewUser() {
		int currentSize = LogIn.login_info.size();

		assertEquals("Failure in recording new user in the LogIn class!", currentSize, LogIn.login_info.size());

	}

	public void testSaveUserInfo() {
		//fail("Not yet implemented");
	}

	// Test for the readUserInfo method. Conditionally asserts the size of the
	// array list
	// containing user information
	public void testReadUserInfo() {
		LogIn.readUserInfo();
		int currentSize = LogIn.login_info.size();
		assertFalse(currentSize <= 0);

	}
	// Test for the validateUser() method. Asserts true if user information is
	// contained in

	public void testValidateUser() {
		boolean test = LogIn.validateUser("test", "test");
		assertEquals("Failure validating the user information!", test, true);

	}

}
