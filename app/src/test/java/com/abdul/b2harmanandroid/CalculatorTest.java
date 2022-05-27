package com.abdul.b2harmanandroid;

import junit.framework.TestCase;

public class CalculatorTest extends TestCase {

    public void testAdd() {
        Calculator calculatorIns =  new Calculator();
        int expected = 40;
        //int actual = calculatorIns.add(10,20);
        int actual = Calculator.add(10,20);

        assertEquals(expected,actual);  //assert = ensure
    }
}