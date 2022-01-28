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

import com.example.mealplan.firstTimeFlow.FoodGenreFragment;
import com.example.mealplan.model.Meal;
import com.example.mealplan.service.MealDataService;
import com.example.mealplan.view.SimpleAdapter;
import com.example.mealplan.view.SimpleViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SecondFragment extends Fragment {

    private TextView textView;
    Button generatePlan;
    List<Meal> mealList;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);


        //need 4 async
        final MainActivity mainActivity = (MainActivity) getActivity();

        SimpleAdapter adapter = mainActivity.adapter;
        RecyclerView rec = view.findViewById(R.id.rec);
        rec.setLayoutManager(new LinearLayoutManager(view.getContext()));
        rec.setHasFixedSize(true);
        rec.setAdapter(adapter);
        generatePlan = view.findViewById(R.id.generateplan);
        generatePlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_mealPlanFragment);
            }
        });
        final List<String> cuisine = mainActivity.getCuisines();
        return view;
    }
}