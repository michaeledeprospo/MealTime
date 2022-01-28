package com.example.mealplan;

import android.os.Bundle;

import com.example.mealplan.model.Meal;
import com.example.mealplan.service.MealDataService;
import com.example.mealplan.view.SimpleAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Meal> meals;
    List<String> mealIds;
    List<String> cuisines = new ArrayList<>();
    SimpleAdapter adapter;
    final MealDataService mealDataService = new MealDataService(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        meals = new ArrayList<>();
        adapter = new SimpleAdapter(meals);
//        fetchMeals("pasta");
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    public void fetchMeals(final String mealName){

                final List<Meal> cock = new ArrayList<>();
                mealDataService.getMealInfo(mealName,  new MealDataService.VolleyResponseListener() {
                    @Override
                    public void onError(String message) {
                        Log.d("first frag", "something wrong " + message);
                    }

                    @Override
                    public void onResponse(Meal meal) {
                        meals.add(meal);
                        mealIds.add(meal.getCalories()); //aka id
                        adapter.setMeals(meals);
                        adapter.notifyDataSetChanged();
                        Log.d("first frag", "something right " + meal.toString());
                    }
                });
            }




    public List<Meal> getMeals(){
        return meals;
    }
    public List<String> getCuisines(){
        return cuisines;
    }
    public void setCuisines(List<String> cuisines){
        this.cuisines = cuisines;
    }
    public List<String> getMealIds(){
        return mealIds;
    }
}