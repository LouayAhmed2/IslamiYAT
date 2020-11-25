package com.example.islamapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.islamapp.R;


public class SebhaFeragment extends Fragment {

    private int totalcounter = 0;
    private int counter = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_sebha, container, false);
        final TextView totalCount = v.findViewById(R.id.totaltasbehcount);
        final TextView Count = v.findViewById(R.id.tasbehcount);
        final Spinner tasbehaspinner = v.findViewById(R.id.spinnertasbeh);


        Button b = v.findViewById(R.id.sebhalogo);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                totalCount.setText(String.valueOf(totalcounter++));
                Count.setText(String.valueOf(counter++));

            }
        });

        ImageButton Reset = v.findViewById(R.id.Restartbtn);
        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalCount.setText(0 + "");
                Count.setText(0 + "");
                counter = 0;
            }
        });

        tasbehaspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                counter = 0;
                Count.setText(0 + "");


            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
        return v;
    }

}