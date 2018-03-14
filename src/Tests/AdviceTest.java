package Tests;
import junit.framework.TestCase;
import java.util.ArrayList;
import org.junit.Test;
import Controller.Advice;

public class AdviceTest extends TestCase {

    //Tests if input is not of proper length, smaller than 4, it should return error
    @Test
    public void test1(){
    	ArrayList<String> list = new ArrayList<String>();
    	list.add("");
    	Advice finan_Advice = new Advice();
    	finan_Advice.savingAdvice(list);
    	assertEquals(finan_Advice.savingAdvice(list),"Error");
    }
  
      //Tests if input is a real value and whether or not it is equal to "Error", should fail
    public void test2(){
    	ArrayList<String> list = new ArrayList<String>();
    	list.add("-230960.00 2016-02-18 Student Loans Debt");
    	Advice finan_Advice = new Advice();
    	finan_Advice.savingAdvice(list);
    	assertEquals(finan_Advice.savingAdvice(list),"Error");
    }
    
    //Tests for the expected output, given good input
    public void test3(){
    	ArrayList<String> list = new ArrayList<String>();
    	list.add("-230960.00 2016-02-18 Student Loans Debt");
    	Advice finan_Advice = new Advice();
    	finan_Advice.savingAdvice(list);
    	assertEquals(finan_Advice.savingAdvice(list),"You should be paying your debts rather than spending, as you have -230960.0in debt and 0.0 in savingsHowever, you are accumulating money, as your bring in more than you use");
    }
}
    
    
 


