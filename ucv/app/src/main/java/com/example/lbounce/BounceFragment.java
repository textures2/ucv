package com.example.lbounce;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.pbense.ucv.R;

/**
 * Created by lauramarshall on 5/21/16.
 */
public class BounceFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.bounce_fragment, container, false);
        return rootView;
    }
}
