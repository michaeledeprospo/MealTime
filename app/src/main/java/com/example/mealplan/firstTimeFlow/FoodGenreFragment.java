package com.example.mealplan.firstTimeFlow;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mealplan.FirstFragment;
import com.example.mealplan.MainActivity;
import com.example.mealplan.R;
import com.example.mealplan.SecondFragment;
import com.example.mealplan.view.SimpleAdapter;

import java.util.ArrayList;
import java.util.List;

public class FoodGenreFragment extends Fragment {
    private ImageButton opt1;
    private ImageButton opt2;
    private ImageButton opt3;
    private ImageButton opt4;
    private Button submitCuisine;
    private List<String> cuisineOptions = new ArrayList<>();
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_food_genre, container, false);
        final MainActivity mainActivity = (MainActivity) getActivity();
        opt1 = view.findViewById(R.id.imageButton);
        opt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cuisineOptions.contains("American")){
                    cuisineOptions.remove("American");
                }
                else {
                    cuisineOptions.add("American");
                }
                Log.d("opt1", cuisineOptions.toString());
            }
        });

        opt2 = view.findViewById(R.id.imageButton2);
        opt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cuisineOptions.contains("Chinese")){
                    cuisineOptions.remove("Chinese");
                }
                else {
                    cuisineOptions.add("Chinese");
                }
                Log.d("opt2", cuisineOptions.toString());
            }
        });

        opt3 = view.findViewById(R.id.imageButton3);
        opt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cuisineOptions.contains("Indian")){
                    cuisineOptions.remove("Indian");
                }
                else {
                    cuisineOptions.add("Indian");
                }
                Log.d("opt3", cuisineOptions.toString());
            }
        });

        opt4 = view.findViewById(R.id.imageButton4);
        opt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cuisineOptions.contains("Mexican")){
                    cuisineOptions.remove("Mexican");
                }
                else {
                    cuisineOptions.add("Mexican");
                }
                Log.d("opt4", cuisineOptions.toString());
            }
        });
        mainActivity.setCuisines(cuisineOptions);

        //oonclick if list contains the item then remove it, show text view with cuisine options in it
        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final MainActivity mainActivity = (MainActivity) getActivity();
        //move to next frag
        view.findViewById(R.id.addGenres).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> cuisines = mainActivity.getCuisines();
                for(String s: cuisines) {
//                    mainActivity.fetchMeals("pasta");
                    Log.d("cuisineIs", s);
                    mainActivity.fetchMeals(s);
                }
                NavHostFragment.findNavController(FoodGenreFragment.this)
                        .navigate(R.id.action_foodGenreFragment_to_SecondFragment);
            }
        });
    }

}
