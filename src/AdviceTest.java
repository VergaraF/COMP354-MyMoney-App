import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class AdviceTest extends TestCase {
    //homeBudget should be set to nothing, testing the value

/*
    class TestcasesTest {
        @Test
        public void testMyArray() {
            Advice advice_test = new Advice();
            assertEquals(Arrays.asList("","","","","","",""), advice_test.myArray(0.00,0.00,0.00,0.00,0.00,0.00,0.00));
            
            

            assertArrayEquals(list1.toArray(), list2.toArray());
        }
    }
    */
	
    public void test2(){
        assertTrue(Advice.homeSpending==0);
    }
    
    
}






