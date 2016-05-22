package com.example.pbense.ucv.rentalcalculator;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pbense.ucv.R;

/**
 * A {@link Fragment} that hosts the {@link RentalCalculator}
 */
public class RentalCalculatorFragment extends Fragment {

    RentalCalculator rc = new RentalCalculator();

    Button calculateButton;
    TextView paymentAmount;
    EditText loanAmount;
    EditText loanDuration;
    EditText loanRate;

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
        return rootView;
    }
}
