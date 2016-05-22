package com.example.pbense.ucv;

import android.app.Fragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.lbounce.BounceFragment;
import com.example.pbense.ucv.rentalcalculator.RentalCalculatorFragment;

public class HomeFragment extends Fragment {
    Button rentalCalculatorButton;
    Button lbounceButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.home_fragment, container, false);
        rentalCalculatorButton = (Button) rootView.findViewById(R.id.rental_calculator_button);
        rentalCalculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_holder, new RentalCalculatorFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

        lbounceButton = (Button) rootView.findViewById(R.id.lbounce_button);
        lbounceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_holder, new BounceFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });


        return rootView;
    }
}
