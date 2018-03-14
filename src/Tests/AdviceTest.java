import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class AdviceTest extends TestCase {
    //homeBudget should be set to 0, testing the value
    @Test


    
    
    
    
    
    public class Testcases {
        public List<String> myArray() {
            List<String> ar = new ArrayList<>();
            ar.add("Customer1");
            ar.add("Customer2");
            ar.add("Customer3");
            return ar;
        }
    }

    class TestcasesTest {
        @Test
        public void testMyArray() {
            Testcases testcases = new Testcases();
            assertEquals(Arrays.asList("Customer1", "Customer2", "Customer3"), testcases.myArray());
        }
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

