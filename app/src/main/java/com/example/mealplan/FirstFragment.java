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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mealplan.service.MealDataService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FirstFragment extends Fragment {

    EditText calorieEdit;
    String calories;
    Button submit;
    Button apiTest;


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
                        .navigate(R.id.action_FirstFragment_to_foodGenreFragment);

            }
        });

        return view;
    }
}