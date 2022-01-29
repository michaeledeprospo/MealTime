package com.example.mealplan.view;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;

import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.example.mealplan.MySharedPreferences;
import com.example.mealplan.R;
import com.example.mealplan.model.Meal;
import com.squareup.picasso.Picasso;



public class SimpleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    private TextView nameTextView, caloriesTextView, proteinTextView, fatTextView, carbsTextView, categoryTextView, mealTypeTextView;
    private ImageView image;
    private ImageButton select;
    private boolean selected = false;
    public SimpleViewHolder(final View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
//        simpleTextView =  itemView.findViewById(R.id.simple_meal_text);
        nameTextView = itemView.findViewById(R.id.name_text_view);
        caloriesTextView = itemView.findViewById(R.id.calories_text_view);
        proteinTextView = itemView.findViewById(R.id.protein_text_view);
        fatTextView = itemView.findViewById(R.id.fat_text_view);
        carbsTextView = itemView.findViewById(R.id.carbs_text_view);
        categoryTextView = itemView.findViewById(R.id.category_text_view);
        mealTypeTextView = itemView.findViewById(R.id.meal_type_text_view);
        image = itemView.findViewById(R.id.imageView);
        select = itemView.findViewById(R.id.addMealBTN);
        select.setVisibility(View.VISIBLE);
        select.setBackgroundResource(R.drawable.ic_circle_add);
        final MySharedPreferences myPref = MySharedPreferences.getInstance(itemView.getContext());
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select.setImageDrawable(null);

                Log.d("clickedya", String.valueOf(selected));
                if(!selected){
                    myPref.putString(caloriesTextView.getText().toString(), null);
                    select.setBackgroundResource(R.drawable.ic_circle_remove);
                    selected = true;
                    //add and remove from local display storage or whatever - TBD USE FIREBASE
                }
                else {

//https://stackoverflow.com/questions/30284067/handle-button-click-inside-a-row-in-recyclerview

                    myPref.putString(caloriesTextView.getText().toString(),caloriesTextView.getText().toString());
                    select.setBackgroundResource(R.drawable.ic_circle_add);
                    selected = false;

                }
            }
        });

    }
    public void bindData(final Meal meal) {
//        simpleTextView.setText(meal.getName());
        nameTextView.setText(meal.getName());
        caloriesTextView.setText( meal.getCalories());
//        categoryTextView.setText(meal.getCategory());
//
//        proteinTextView.setText(meal.getProtein());
//        fatTextView.setText(meal.getFat());
//        carbsTextView.setText(meal.getCarbs());
//
//        mealTypeTextView.setText(meal.getMealType());
        categoryTextView.setText("");

        proteinTextView.setText("");
        fatTextView.setText("");
        carbsTextView.setText("");

        mealTypeTextView.setText("");
        Handler uiHandler = new Handler(Looper.getMainLooper());
        image.setImageDrawable(null);
        uiHandler.post(new Runnable(){
            @Override
            public void run() {
                Picasso.get()
                        .load(meal.getImageUrl())
                        .into(image);
            }
        });
        Log.d("render1","adsad");

    }

    @Override
    public void onClick(View v){
        Log.d("nuts", "click");
    }


}
