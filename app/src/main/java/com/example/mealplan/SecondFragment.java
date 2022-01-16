package com.example.mealplan;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mealplan.model.Meal;
import com.example.mealplan.service.MealDataService;
import com.example.mealplan.view.SimpleAdapter;
import com.example.mealplan.view.SimpleViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SecondFragment extends Fragment {

    private TextView textView;
    Button apiTest;
    List<Meal> mealList;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        apiTest = view.findViewById(R.id.button2);

        //need 4 async
        final MainActivity mainActivity = (MainActivity) getActivity();

//        List<Meal> cock = mainActivity.getMeals();
//        Log.d("cock in ass", cock.toString());
        SimpleAdapter adapter = mainActivity.adapter;
        RecyclerView rec = view.findViewById(R.id.rec);
        rec.setLayoutManager(new LinearLayoutManager(view.getContext()));
        rec.setHasFixedSize(true);
        rec.setAdapter(adapter);
        apiTest = view.findViewById(R.id.button2);
        apiTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.fetchMeals("pasta");

            }
        });
        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });

    }

}