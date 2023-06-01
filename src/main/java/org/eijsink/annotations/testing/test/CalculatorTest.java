package org.eijsink.annotations.testing.test;

import org.eijsink.annotations.testing.annotation.Test;
import org.eijsink.annotations.testing.assertion.Assertions;
import org.eijsink.annotations.testing.service.Calculator;

public class CalculatorTest {

    @Test
    public void testAdd(){
        int actual = Calculator.add( 3, 7);
        Assertions.assertEquals( 10, actual);
    }

    @Test
    public void testSubtract(){
        int actual = Calculator.subtract( 7, 2);
        Assertions.assertEquals( 5, actual);
    }

    @Test
    public void testMultiply(){
        int actual = Calculator.multiply( 3, 7);
        Assertions.assertEquals( 21, actual);
    }

    @Test
    public void testEven(){
        boolean actual = Calculator.isEven( 24);
        Assertions.assertEquals( true, actual);
        Assertions.assertTrue( actual);
    }

    @Test(skip = true)
    public void testPositive(){
        boolean actual = Calculator.isPositive( 5);
        Assertions.assertEquals( true, actual);
        Assertions.assertTrue( actual);
    }

    @Test
    public void testNegative(){
        boolean actual = Calculator.isPositive( 5);
        Assertions.assertEquals( false, actual);
        Assertions.assertTrue( actual);
    }

}
