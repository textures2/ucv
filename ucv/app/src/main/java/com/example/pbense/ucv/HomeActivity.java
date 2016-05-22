package com.example.pbense.ucv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.pbense.ucv.rentalcalculator.RentalCalculatorFragment;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_holder, new HomeFragment())
                .addToBackStack(null)
                .commit();
    }
}
