package com.example.pbense.ucv.rentalcalculator;

public class RentalCalculator {

    /**
     * Given a monthly rental rate, return annualized income accounting for:
     * <ul>
     *     <li>The percentage of the property management fee
     *     <li>The anticipated vacancy rate
     *     <li>The anticipated maintenance rate
     * </ul>
     *
     * Example: a 1500 monthly rental rate, with a 7% (0.07) management fee, anticipated vacancy
     * rate of 3% (0.03), and anticipated maintenance rate 4% (0.04).
     */
    public double getGrossAnnualIncomeMinusLosses(
            double monthlyRentalRate,
            double managementFee,
            double vacancyRate,
            double maintenanceRate) {
        return (monthlyRentalRate * 12)
                * (1.0 - managementFee - vacancyRate - maintenanceRate);
    }

    /**
     * Given an interest rate, a number of months, and a loan principle, returns the monthly
     * payment.
     */
    public double getMonthlyPayment(
            double loanAmount, int termInMonths, double interestRate) {
        // Convert interest rate into a decimal
        // eg. 6.5% = 0.065
        interestRate /= 100.0;
        // Monthly interest rate
        // is the yearly rate divided by 12
        double monthlyRate = interestRate / 12.0;
        // The Math.pow() method is used calculate values raised to a power
        return (loanAmount * monthlyRate) /
                        (1 - Math.pow(1 + monthlyRate, -termInMonths));
    }

    /**
     * Given a monthly payment, annual property taxes and annual insurance premiums, return the
     * monthly payment inclusive taxes and insurance.
     */
    public double getMonthlyPaymentWithTaxesAndInsurance(
            double loanPaymentAmount, double annualTaxes, double annualInsurance) {
        return loanPaymentAmount + ((annualInsurance + annualTaxes) / 12);
    }
}
