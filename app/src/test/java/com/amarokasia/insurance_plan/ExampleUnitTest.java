package com.amarokasia.insurance_plan;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 *
 */


public class   ExampleUnitTest {

    private CalculatorActivity calc = new CalculatorActivity();

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

//    @Test
//    public void testMonthlyInstallment(){
//        double result = calc.calcMonthlyinstallment(200000,25000,30000,5000,40000);
//        assertEquals(25000,result,1);
//    }
}