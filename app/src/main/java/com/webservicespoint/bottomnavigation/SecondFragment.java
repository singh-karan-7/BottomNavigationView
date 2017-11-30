package com.webservicespoint.bottomnavigation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by karanveer on 25/11/17.
 */

public class SecondFragment extends Fragment {

    TextView label;
    Button button;

    public static SecondFragment newInstance() {
        SecondFragment firstFrag = new SecondFragment();
        return firstFrag;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.second_fragment, container, false);

        label = view.findViewById(R.id.textView);
        button = view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                label.setText("Value Changed");
            }
        });

        return view;
    }
}
