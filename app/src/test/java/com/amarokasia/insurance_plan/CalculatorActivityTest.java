package com.amarokasia.insurance_plan;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorActivityTest {


    @Test
    public void calcMonthlyinstallment() {
        CalculatorActivity calc = new CalculatorActivity();
        double output;
        output = calc.calcMonthlyinstallment(200000,25000,30000,5000,40000);
        assertEquals(25000,output,0.1);

        output = calc.calcMonthlyinstallment(250000,30000,50000,10000,10000);
        assertEquals(37500,output,0.1);

        output = calc.calcMonthlyinstallment(300000,40000,70000,12000,20000);
        assertEquals(39500,output,0.1);

        output = calc.calcMonthlyinstallment(500000,50000,90000,8000,30000);
        assertEquals(80500,output,0.1);

        output = calc.calcMonthlyinstallment(1000000,75000,100000,5000,40000);
        assertEquals(195000,output,0.1);
    }


    @Test
    public void calcBestPlan() {
        CalculatorActivity calc = new CalculatorActivity();
        double monthlyinstallment;
        double output;

        monthlyinstallment = calc.calcMonthlyinstallment(200000,25000,30000,5000,40000);
        output = calc.calcBestPlan(monthlyinstallment);
        assertEquals(300000,output,0.1);

        monthlyinstallment = calc.calcMonthlyinstallment(250000,30000,50000,10000,10000);
        output = calc.calcBestPlan(monthlyinstallment);
        assertEquals(450000,output,0.1);

        monthlyinstallment = calc.calcMonthlyinstallment(300000,40000,70000,12000,20000);
        output = calc.calcBestPlan(monthlyinstallment);
        assertEquals(474000,output,0.1);

        monthlyinstallment = calc.calcMonthlyinstallment(500000,50000,90000,8000,30000);
        output = calc.calcBestPlan(monthlyinstallment);
        assertEquals(966000,output,0.1);

        monthlyinstallment = calc.calcMonthlyinstallment(1000000,75000,100000,5000,40000);
        output = calc.calcBestPlan(monthlyinstallment);
        assertEquals(2340000,output,0.1);
    }
}