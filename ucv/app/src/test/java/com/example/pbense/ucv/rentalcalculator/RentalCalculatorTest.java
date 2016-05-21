package com.example.pbense.ucv.rentalcalculator;


import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;

/**
 * Unit tests for the {@link RentalCalculator}
 */
public class RentalCalculatorTest {

    RentalCalculator rc = new RentalCalculator();

    @Test
    public void testCalculateMonthlyPayment() {
        // A 50k loan for 10 years with a 4.5% interest rate
        assertThat(rc.getMonthlyPayment(50000, 120, 4.5))
                .isWithin(518.19);
    }

    @Test
    public void testGetMonthlyPaymentWithTaxesAndInsurance() {
        assertThat(rc.getMonthlyPaymentWithTaxesAndInsurance(1000, 5000.0, 1250.0))
                .isWithin(1520.833);
    }

    @Test
    public void testGetAnnualIncomeMinusLosses() {
        assertThat(rc.getGrossAnnualIncomeMinusLosses(1250, 0.07, 0.03, 0.03)).isWithin(13350.0);
    }
}
