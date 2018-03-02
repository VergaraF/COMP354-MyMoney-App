

/**
 *
 * @author Vincent
 */

import junit.framework.TestCase;
import org.junit.Test;

public class FinanceTest extends TestCase {
    //homeBudget should be set to 0, testing the value
    @Test
    public void test1(){
        assertTrue(FinanceController.homeBudget==1);
    }
    //homeSpending should be set to 0, testing the value
    @Test
    public void test2(){
        assertTrue(FinanceController.homeSpending==0);
    }
    //FP.text1 should be set to "", testing the value
    @Test
    public void test3(){
        assertTrue(FinanceController.FP.text1.equals("156"));
    }
}
