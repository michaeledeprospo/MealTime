package com.example.mealplan;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class FirstFragment extends Fragment {

    EditText calorieEdit;
    String calories;
    Button submit;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        calorieEdit = view.findViewById(R.id.editTextNumber);
        submit = view.findViewById(R.id.button);
        final MySharedPreferences myPref = MySharedPreferences.getInstance(view.getContext());
        Log.d("current", getString(R.string.calories));


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calories = calorieEdit.getText().toString();
                Log.d("Butts", calories);
                //use constants file r.string blah blah
                Log.d("prevButts", myPref.getString("calories"));
                myPref.putString("calories", calories);
                Log.d("afterButts", myPref.getString("calories"));
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);

            }
        });

        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }
}