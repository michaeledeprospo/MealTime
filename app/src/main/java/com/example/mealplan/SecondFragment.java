package com.example.mealplan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mealplan.model.Meal;
import com.example.mealplan.view.SimpleAdapter;
import com.example.mealplan.view.SimpleViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SecondFragment extends Fragment {

    private TextView textView;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);


        SimpleAdapter adapter = new SimpleAdapter(generateSimpleList());
        RecyclerView rec = view.findViewById(R.id.rec);
        rec.setLayoutManager(new LinearLayoutManager(view.getContext()));
        rec.setHasFixedSize(true);
        rec.setAdapter(adapter);
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
    //helper method to generate list of dummy meals - this will be replaced with meal data from api
    private List<Meal> generateSimpleList(){
        List<Meal> cock = new ArrayList<>();

        for(int i = 0; i< 10; i++){
            cock.add(new Meal(String.format(Locale.US, "This is meal # %d", i)));
        }
        return cock;
    }
}