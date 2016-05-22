package com.example.pbense.ucv.rentalcalculator;

import android.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pbense.ucv.R;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.regex.Pattern;

/**
 * A {@link Fragment} that hosts the {@link RentalCalculator}
 */
public class RentalCalculatorFragment extends Fragment {

    RentalCalculator rc = new RentalCalculator();

    Button calculateButton;
    Button resetButton;

    TextView paymentAmount;
    EditText loanAmount;
    EditText loanDuration;
    EditText loanRate;

    // Interest rates have to be like 1, 1.0, 5.5, etc.
    Pattern interestRatePattern = Pattern.compile("\\d+\\.?\\d+");
    NumberFormat loanAmountNumberFormat = NumberFormat.getNumberInstance();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.rental_calculator_fragment, container, false);
        loanAmount = (EditText) rootView.findViewById(R.id.loan_amount_hint);
        loanDuration = (EditText) rootView.findViewById(R.id.loan_duration_months_hint);
        loanRate = (EditText) rootView.findViewById(R.id.loan_rate_hint);
        paymentAmount = (TextView) rootView.findViewById(R.id.payment_amount);
        calculateButton = (Button) rootView.findViewById(R.id.calculate_button);
        resetButton = (Button) rootView.findViewById(R.id.reset_button);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    validateInputsAndCalculate();
                } catch (ParseException e) {

                }
            }
        });
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearInputs();
            }
        });
        return rootView;
    }

    private void clearInputs() {
        loanAmount.setText(null);
        loanDuration.setText(null);
        loanRate.setText(null);
        paymentAmount.setText(null);
    }

    private void validateInputsAndCalculate() throws ParseException {
        if (TextUtils.isEmpty(loanAmount.getText())
                || TextUtils.isEmpty(loanDuration.getText())
                || TextUtils.isEmpty(loanRate.getText())) {
            // TODO: display a warning - all inputs must be present
            return;
        }
        if (!TextUtils.isDigitsOnly(loanAmount.getText())) {
            // TODO: display a warning - duration has to be numeric only.
            return;
        }
        if (!interestRatePattern.matcher(loanRate.getText()).matches()) {
            // TODO: display a warning - user entered an invalid interest rate.
            return;
        }
        // TODO: Format the output correctly
        paymentAmount.setText(
                Double.toString(
                        rc.getMonthlyPayment(
                loanAmountNumberFormat.parse(loanAmount.getText().toString()).doubleValue(),
                Integer.valueOf(loanDuration.getText().toString()),
                Double.valueOf(loanRate.getText().toString()))));
    }
}
