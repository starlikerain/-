package test.CalculatorTest;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import test.Calculator.Calculator;

public class CalculatorTest {

    @Before
    public void init(){
        System.out.println("init...");
    }

    @After
    public void close(){
        System.out.println("closed!~");
    }

    /**
     *
     */
    @Test
    public void testAdd(){
        Calculator calculator = new Calculator();

        int addResult = calculator.add(1, 2);

        Assert.assertEquals(2, addResult);
    }
}
