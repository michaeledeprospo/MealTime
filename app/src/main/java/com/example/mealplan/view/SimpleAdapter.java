package com.example.mealplan.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mealplan.R;
import com.example.mealplan.model.Meal;

import java.util.List;

public class SimpleAdapter extends RecyclerView.Adapter {
    //List<SimpleViewModel> models;
    List<Meal> models;

    public SimpleAdapter(List<Meal> models){
        this.models= models;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((SimpleViewHolder) holder).bindData(models.get(position));
    }

    @Override
    public int getItemCount() {
        return models.size();
    }
    @Override
    public int getItemViewType(final int position) {
        return R.layout.meal_rec;
    }

    public void setMeals(List<Meal> meals){
        models = meals;
    }
}
